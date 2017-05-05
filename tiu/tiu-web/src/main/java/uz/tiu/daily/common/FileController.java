package uz.tiu.daily.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uz.tiu.daily.persistence.FileStorage;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;



@Controller
@Transactional
public class FileController {

    @Autowired
    private FileStorageService storageService;

/*
    @Autowired
    private AclPermissionEvaluator aclPermissionEvaluator;
*/
    @Autowired
    private HttpFileSender httpFileSender;

    @Autowired
    private ObjectMapper jsonMapper;

    public final static String URL_FILE = "/file.htm";

    public final static String FILE_DOWNLOAD_PATH = "/download";

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(method = RequestMethod.GET, value = URL_FILE)
    public void download(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(value = "id", required = false) Long fileId) throws IOException {

        if (logger.isDebugEnabled())
            logger.debug("download file id={}", fileId);

        sendFile(request, response, fileId, null);
    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.HEAD}, value = FILE_DOWNLOAD_PATH + "/{filename}.{extension}")
    public void downloadFileByPath(HttpServletRequest request, HttpServletResponse response,
                                   @PathVariable("filename") String filename,
                                   @PathVariable("extension") String extension) throws IOException {

        if (logger.isDebugEnabled())
            logger.debug("download request by file path: method={}, filename={}, extension={}", request.getMethod(), filename, extension);

        if (filename!=null)
        {
            String fullname = filename;
            if (extension!=null && !extension.isEmpty())
                fullname += "." + extension;

            Long fileId;
            fileId = FileStorageService.parseFileIdFromFilename(filename, extension);
            if (fileId!=null)
                sendFile(request, response, fileId, fullname);
        }
    }

    @RequestMapping(method=RequestMethod.POST, value=URL_FILE)
    public void upload( HttpServletResponse response,
                        @RequestParam(value = "file", required = false) MultipartFile file,
                        @RequestParam(value = "sender-id", required = false) String senderId){

        // the method of retrieving request from spring context ))
        // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        if (logger.isDebugEnabled())
        {
            if (file!=null)
                logger.debug("Received file, name={}, size={}, content-type={}, senderId={}", file.getOriginalFilename(), file.getSize(), file.getContentType(), senderId);
            else
                logger.debug("Received file is null");
        }

        if (file!=null && file.getSize()>0 )
        {

            FileStorage fileStorage = storageService.saveMultipartFileToStorage(file);

            FileUploadJson fileUploadJson = new FileUploadJson();
            fileUploadJson.setName(file.getOriginalFilename());
            fileUploadJson.setSize(file.getSize());
            fileUploadJson.setUrl(fileStorage.getFileUrl());
            fileUploadJson.setFileId(fileStorage.getId());
            fileUploadJson.setSenderId(senderId);
            fileUploadJson.setTimestamp(new java.sql.Timestamp(new Date().getTime()));
            fileUploadJson.setDirty(true);

            if (logger.isDebugEnabled())
                logger.debug("Added UploadedFile item: {}", fileUploadJson.toString());

            storageService.getUploadedFiles().add(fileUploadJson);
        }

        try {
            ObjectWriter writer = jsonMapper.writer().withRootName("files");
            byte[] data;
            data = writer.writeValueAsBytes(storageService.getUploadedFilesBySenderId(senderId));
            response.setContentType("application/json");
            response.setContentLength(data.length);
            ServletOutputStream outStream;
            outStream = response.getOutputStream();
            outStream.write(data);
            outStream.close();
        } catch (IOException e) {
            logger.error("Error: ", e);
        }

    }

    public void sendFile(HttpServletRequest request, HttpServletResponse response, Long fileId, String filename)
            throws IOException {
        if (fileId!=null)
        {
            try {

                FileStorage fileStorage = storageService.getFileStorage(fileId);
                if (fileStorage!=null)
                {
                    // check if security is applied to fileData object
                    if (fileStorage.getSecured()!=null && fileStorage.getSecured())
                    {
                        // check security permissions
/*
                        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                        if (!aclPermissionEvaluator.hasPermission(authentication, fileStorage, BasePermission.READ))
                        {
                            response.sendError(HttpServletResponse.SC_FORBIDDEN);
                            return;
                        }
*/
                    }

                    if (filename==null)
                        filename = fileStorage.getFilename();

                    String contentType = fileStorage.getContentType();

                    boolean sendLocalFile = fileStorage.getExternal();
                    if (sendLocalFile)
                    {
                        String fileFullPath = storageService.getFileFullname(fileStorage, false);
                        httpFileSender.sendFileToHttpResponse(request, response, contentType, HttpFileSender.STREAM_DISPOSITION_INLINE, filename, fileFullPath);
                    }
                    else
                    {
                        long contentLength = fileStorage.getSize();
                        Date lastModified = fileStorage.getModifiedDate();
                        if (lastModified==null)
                            lastModified = fileStorage.getUploadDate();
                        if (lastModified==null)
                            lastModified = new Date();

                        byte [] sendArray = fileStorage.getData();
                        httpFileSender.sendFileBufferToHttpResponse(request, response, contentType, contentLength, lastModified.getTime(), HttpFileSender.STREAM_DISPOSITION_INLINE, filename, sendArray);
                    }
                }
            } catch (Exception e) {
                logger.error(getClass().getName()+": " + e.toString());
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

}