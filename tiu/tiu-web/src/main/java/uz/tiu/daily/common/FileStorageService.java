package uz.tiu.daily.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import uz.tiu.daily.common.configuration.AppConfiguration;
import uz.tiu.daily.persistence.FileStorage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FileStorageService {


    @Autowired
    private AppConfiguration appConfiguration;

    @PersistenceContext
    private EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private List<FileUploadJson> uploadedFiles = new ArrayList<FileUploadJson>();

    public List<FileUploadJson> getUploadedFiles() {
        return uploadedFiles;
    }

    public List<FileUploadJson> getUploadedFilesBySenderId(String senderId) {
        List<FileUploadJson> list = new ArrayList<FileUploadJson>();
        for (FileUploadJson fileUploadJson : uploadedFiles)
            if (senderId.equalsIgnoreCase(fileUploadJson.getSenderId()))
                list.add(fileUploadJson);

        return list;
    }

    public void removeUploadedFilesBySenderId(String senderId) {
        for (int pos = 0; pos < uploadedFiles.size(); pos++) {
            FileUploadJson fileUploadJson = uploadedFiles.get(pos);
            if (senderId.equalsIgnoreCase(fileUploadJson.getSenderId())) {
                if (fileUploadJson.getDirty()) {
                    removeFileFromStorage(fileUploadJson.getFileId());
                    uploadedFiles.remove(pos);
                }
            }
        }
    }

    public void removeUploadedFilesAll() {
        for (int pos = 0; pos < uploadedFiles.size(); pos++) {
            FileUploadJson fileUploadJson = uploadedFiles.get(pos);
            if (fileUploadJson.getDirty()) {
                removeFileFromStorage(fileUploadJson.getFileId());
                uploadedFiles.remove(pos);
            }
        }
    }

    public void clearFromUploadedFilesById(Long fileId) {
        if (fileId == null)
            return;
        for (FileUploadJson fileUploadJson : uploadedFiles) {
            if (fileId.equals(fileUploadJson.getFileId())) {

                fileUploadJson.setDirty(false);
                uploadedFiles.remove(fileUploadJson);
                break;
            }
        }
    }

    public FileStorage assignFileFromUploadedFiles(Long fileId) {
        if (fileId == null)
            return null;

        // remove file item from the temporary uploaded list
        clearFromUploadedFilesById(fileId);
        return getFileStorage(fileId);
    }

    /*@PreDestroy
    public void destroy()
    {
        removeUploadedFilesAll();
    }*/

    @Transactional(readOnly = true)
    public FileStorage getFileStorage(Long fileId) {
        if (fileId == null)
            return null;

        try {
            TypedQuery<FileStorage> query;
            query = em.createNamedQuery("FileStorage.getById", FileStorage.class);
            query.setParameter("id", fileId);
            return query.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    @Transactional
    public FileStorage saveMultipartFileToStorage(MultipartFile file) {
        if (file == null || file.getOriginalFilename().isEmpty())
            throw new IllegalArgumentException("file is null or empty");

        String filename = file.getOriginalFilename();
        Timestamp currentDate = new Timestamp(new Date().getTime());

        FileStorage fileStorage = new FileStorage();

        byte storageType = appConfiguration.getRepositoryConfiguration().getStorageType();
        if (storageType == Constants.STORAGE_TYPE_FILE) {
            fileStorage.setExternal(true);
        } else if (storageType == Constants.STORAGE_TYPE_DATABASE) {
            fileStorage.setExternal(false);
        } else {
            throw new IllegalStateException("Repository configuration error, unknown storage type : " + storageType);
        }
        fileStorage.setUploadDate(currentDate);
        fileStorage.setSessionID(0L);
        fileStorage.setSize(file.getSize());

        String contentType = file.getContentType() == null ? "" : file.getContentType();

        if (contentType.isEmpty()) {
            String ext = GrpUtils.getFileExtension(filename);
            if (ext != null && !ext.isEmpty()) {
                FileTypeInfo info = appConfiguration.getFileTypeConfiguration().getFileTypeInfoMapKeyExt().get(ext);
                if (info != null) {
                    contentType = info.getMime();
                    if (contentType == null)
                        contentType = "";
                }
            }
        }

        fileStorage.setFilename(filename);
        fileStorage.setContentType(contentType);

        em.persist(fileStorage);
        saveMultipartFileToStorage(file, fileStorage);

        return fileStorage;
    }

    public String getFileFullname(FileStorage fileData, boolean createPath) {
        String fullname = getFilePath(fileData, createPath);

        if (fileData.getStoredInSeparatePath() != null && fileData.getStoredInSeparatePath())
            fullname += fileData.getFilename();
        else
            fullname += fileData.getId();

        return fullname;
    }

    public String getFilePath(FileStorage fileData, boolean createPath) {
        String filePath;
        if (fileData.getStoredInSeparatePath() != null && fileData.getStoredInSeparatePath())
            filePath = fileData.getStoredPath();
        else {
            filePath = appConfiguration.getRepositoryConfiguration().getPath();
            String dirChar = filePath.substring(filePath.length() - 1);
            Date uploadDate = fileData.getUploadDate();
            if (uploadDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy" + dirChar + "MM" + dirChar + "dd" + dirChar);
                filePath += dateFormat.format(uploadDate);
            }
        }

        if (createPath) {
            File f = new File(filePath);
            if (f.mkdirs())
                filePath = filePath.trim();    // to ignore warning :)
        }
        return filePath;
    }

    public void removeFileFromStorage(long fileId) {
        FileStorage fileStorage;
        fileStorage = getFileStorage(fileId);
        removeFileFromStorage(fileStorage);
    }

    @Transactional
    public void removeFileFromStorage(FileStorage fileStorage) {
        if (fileStorage == null)
            throw new IllegalArgumentException("fileStorage is null");

        if (logger.isTraceEnabled())
            logger.trace("removeFileFromStorage, fileStorageId={}", fileStorage.getId());

        String filename = getFilePath(fileStorage, false) + fileStorage.getId();
        GrpUtils.removeFile(filename);

        fileStorage = getFileStorage(fileStorage.getId());
        em.remove(fileStorage);
    }

    public void saveMultipartFileToStorage(MultipartFile file, FileStorage fileData) {

        byte storageType = appConfiguration.getRepositoryConfiguration().getStorageType();
        try {
            switch (storageType) {
                case Constants.STORAGE_TYPE_FILE:
                    fileData.setExternal(true);
                    boolean preStored = (fileData.getStoredExists() != null && fileData.getStoredExists());
                    if (!preStored) {
                        String outFilename = getFileFullname(fileData, true);
                        File outFile = new File(outFilename);
                        if (outFile.createNewFile()) {
                            GrpUtils.removeFile(outFilename);
                            file.transferTo(outFile);
                        }
                    }
                    break;
                case Constants.STORAGE_TYPE_DATABASE:
                    fileData.setExternal(false);
                    fileData.setData(file.getBytes());
                    break;
                default:
                    throw new IllegalStateException("Repository configuration error, unknown storage type : " + storageType);
            }
        } catch (IOException e) {
            logger.error("Exception:", e);
        }
    }

    public void saveFileToStorage(File file, FileStorage fileData) throws IOException {
        byte storageType = appConfiguration.getRepositoryConfiguration().getStorageType();
        switch (storageType) {
            case Constants.STORAGE_TYPE_FILE:
                fileData.setExternal(true);
                String outFilename = getFilePath(fileData, true) + fileData.getId();
                File outFile = new File(outFilename);
                if (outFile.createNewFile()) {
                    GrpUtils.removeFile(outFilename);
                    GrpUtils.copyFile(file, outFile);
                }
                break;
            case Constants.STORAGE_TYPE_DATABASE:
                byte[] data = GrpUtils.getBytesFromFile(file);
                fileData.setExternal(false);
                fileData.setData(data);
                break;
            default:
                throw new IllegalStateException("Repository configuration error, unknown storage type : " + storageType);
        }
    }

    @Transactional
    public FileStorage copyFileData(FileStorage fileStorage) {
        if (fileStorage == null)
            throw new IllegalArgumentException("fileStorage is null");

        if (logger.isTraceEnabled())
            logger.trace("removeFileFromStorage, fileDataId={}", fileStorage.getId());

        String filename = getFilePath(fileStorage, false) + fileStorage.getId();

        FileStorage fileDataCopy = new FileStorage();
        fileDataCopy.setContentType(fileStorage.getContentType());
        fileDataCopy.setCryptAlgorithm(fileStorage.getCryptAlgorithm());
        fileDataCopy.setCrypted(fileStorage.getCrypted());
        fileDataCopy.setCryptKey(fileStorage.getCryptKey());
        fileDataCopy.setFilename(fileStorage.getFilename());
        fileDataCopy.setSize(fileStorage.getSize());
        fileDataCopy.setUploadDate(new Timestamp(new Date().getTime()));
        fileDataCopy.setExternal(fileStorage.getExternal());
        fileDataCopy.setSecured(fileStorage.getSecured());
        fileDataCopy.setStoredInSeparatePath(fileStorage.getStoredInSeparatePath());
        fileDataCopy.setStoredPath(fileStorage.getStoredPath());
        fileDataCopy.setSessionID(0L);

        // todo: copy ACL Security objects

        try {
            if (fileStorage.getExternal()) {
                em.persist(fileDataCopy);
                String inFilename = getFilePath(fileStorage, false) + fileStorage.getId();
                String outFilename = getFilePath(fileDataCopy, true) + fileDataCopy.getId();
                GrpUtils.copyFile(new File(inFilename), new File(outFilename));
            } else {
                fileDataCopy.setData(fileStorage.getData());
                em.persist(fileDataCopy);
            }
        } catch (IOException e) {
            logger.error("Exception:", e);
            return null;
        }

        return fileDataCopy;
    }

    public static String generateFileName(Long fileId, String name) {
        String filename = "";
        if (fileId != null) {
            filename = String.format("%09d", fileId);
            String ext = GrpUtils.getFileExtension(name);
            if (ext != null && !ext.isEmpty())
                filename += "." + ext;
        }
        return filename;
    }

    public static Long parseFileIdFromFilename(String filename, String extension) {
        Long fileId = null;
        if (filename != null && !filename.isEmpty()) {
            try {
                fileId = Long.parseLong(filename);
            } catch (NumberFormatException e) {
            }
        }
        return fileId;
    }

    public static Long parseFileIdFromFileUrl(String fileUrl) {
        Long fileId = null;
        String name = GrpUtils.extractName(fileUrl);
        if (name != null && !name.isEmpty()) {
            try {
                fileId = Long.parseLong(name);
            } catch (NumberFormatException e) {
            }
        }
        return fileId;
    }

}