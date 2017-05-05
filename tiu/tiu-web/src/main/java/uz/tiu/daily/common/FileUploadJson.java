package uz.tiu.daily.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;


public class FileUploadJson implements Serializable {

    @JsonIgnore
	private static final long serialVersionUID = -38331060124340967L;

    @JsonIgnore
    private Long fileId;

    @JsonIgnore
    private String senderId;

    @JsonIgnore
    private Timestamp timestamp;

    @JsonIgnore
    private boolean dirty;

	private String name;
	private Long size;
	private String url;

    @JsonProperty("thumbnail_url")
	private String thumbnailUrl;

    @JsonProperty("delete_url")
	private String deleteUrl;

    @JsonProperty("delete_type")
	private String deleteType;

	public FileUploadJson() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public String getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(String deleteType) {
        this.deleteType = deleteType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean getDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    @Override
	public String toString() {
		return "UploadedFile [name=" + name + ", size=" + size + ", url=" + url
				+ ", thumbnailUrl=" + thumbnailUrl + ", deleteUrl="
				+ deleteUrl + ", deleteType=" + deleteType + "]";
	}
	
}
