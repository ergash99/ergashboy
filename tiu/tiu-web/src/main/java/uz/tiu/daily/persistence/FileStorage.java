package uz.tiu.daily.persistence;

import uz.tiu.daily.common.FileStorageService;
import uz.tiu.daily.common.TableName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name = TableName.FILE)
public class FileStorage implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_UZGPS_FILE_ID")
    @SequenceGenerator(name = "SEQ_UZGPS_FILE_ID", sequenceName = "SEQ_UZGPS_FILE_ID")
    @Column(name = "ID", nullable=false)
    private Long id;

    @Column(name ="FILENAME", nullable=false, length = 512)
    private String filename;

    @Column(name ="SIZE", nullable=false)
    private long size;

    @Column(name ="CONTENT_TYPE", nullable=true, length = 128)
    private String contentType;

    @Column(name ="IS_EXTERNAL", nullable=false)
    private Boolean external;

    @Column(name ="IS_STORED_SEPARATE", nullable=true)
    private Boolean storedInSeparatePath; // true, if file pre-stored somewhere in separate location, other than repo root

    @Column(name ="STORED_PATH", nullable=true, length = 512)
    private String storedPath; // full path of the stored file

    @Column(name ="STORED_EXISTS", nullable=true, length = 512)
    private Boolean storedExists; // file is already exists and read-only

    @Column(name ="IS_CRYPTED", nullable=true)
    private Boolean crypted;

    @Column(name ="CRYPT_ALGORITHM", nullable=true, length = 64)
    private String cryptAlgorithm;

    @Column(name ="CRYPT_BASE64KEY", nullable=true, length = 256)
    private String cryptKey;

    @Lob
    @Column(name = "DATA", nullable=true)
    private byte []  data;

    @Column(name ="UPLOAD_DATE", nullable=false)
    private Date uploadDate;

    @Column(name ="MODIFIED_DATE", nullable=true)
    private Date modifiedDate;

    @Column(name ="SESSION_ID", nullable=true, precision = 19)
    private Long sessionID;

    @Column(name ="SECURED", nullable=true)
    private Boolean secured;

    public FileStorage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Long getSessionID() {
        return sessionID;
    }

    public void setSessionID(Long sessionID) {
        this.sessionID = sessionID;
    }

    public Boolean getCrypted() {
        return crypted;
    }

    public void setCrypted(Boolean crypted) {
        this.crypted = crypted;
    }

    public String getCryptAlgorithm() {
        return cryptAlgorithm;
    }

    public void setCryptAlgorithm(String cryptAlgorithm) {
        this.cryptAlgorithm = cryptAlgorithm;
    }

    public String getCryptKey() {
        return cryptKey;
    }

    public void setCryptKey(String cryptKey) {
        this.cryptKey = cryptKey;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Boolean getStoredInSeparatePath() {
        return storedInSeparatePath;
    }

    public void setStoredInSeparatePath(Boolean storedInSeparatePath) {
        this.storedInSeparatePath = storedInSeparatePath;
    }

    public String getStoredPath() {
        return storedPath;
    }

    public void setStoredPath(String storedPath) {
        this.storedPath = storedPath;
    }

    public Boolean getSecured() {
        return secured;
    }

    public void setSecured(Boolean secured) {
        this.secured = secured;
    }

    public Boolean getStoredExists() {
        return storedExists;
    }

    public void setStoredExists(Boolean storedExists) {
        this.storedExists = storedExists;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Transient
    public String getFileUrl()
    {
        return FileStorageService.generateFileName(id, filename);
    }
}
