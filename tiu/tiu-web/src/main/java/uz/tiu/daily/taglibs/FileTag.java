package uz.tiu.daily.taglibs;

import uz.tiu.daily.common.FileTypeInfo;
import uz.tiu.daily.persistence.FileStorage;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * @author Sheroz Khaydarov
 * @since 02.03.2009 17:35:24
 */

public class FileTag extends BodyTagSupport {

    private FileStorage fileStorage;
    private Integer language;
    private String fileDownloadPath;
    private String fileDownloadUrlById;
    private String imageFolderUrl;
    private Integer imageWidth;
    private Integer imageHeight;
    private String imageAlt;
    private Boolean targetBlank;
    private Boolean randomParam;
    private String randomParamName;
    private Map<String, FileTypeInfo> fileTypeInfoMapKeyMime;
    private Boolean useIdPrefix;
    private Boolean useFilename;

    public void setFileDownloadPath(String fileDownloadPath) {
        this.fileDownloadPath = fileDownloadPath;
    }


    public void setRandomParam(Boolean randomParam) {
        this.randomParam = randomParam;
    }


    public void setRandomParamName(String randomParamName) {
        this.randomParamName = randomParamName;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public void setTargetBlank(Boolean targetBlank) {
        this.targetBlank = targetBlank;
    }

    public void setFileStorage(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public void setFileDownloadUrlById(String fileDownloadUrlById) {
        this.fileDownloadUrlById = fileDownloadUrlById;
    }

    public void setImageFolderUrl(String imageFolderUrl) {
        this.imageFolderUrl = imageFolderUrl;
    }

    public void setFileTypeInfoMapKeyMime(Map<String, FileTypeInfo> fileTypeInfoMapKeyMime) {
        this.fileTypeInfoMapKeyMime = fileTypeInfoMapKeyMime;
    }

    public void setUseIdPrefix(Boolean useIdPrefix) {
        this.useIdPrefix = useIdPrefix;
    }

    public void setUseFilename(Boolean useFilename) {
        this.useFilename = useFilename;
    }

    public int doStartTag() throws JspException {

        if(fileStorage==null)
            throw new JspException("empty fileStorage class");

        return EVAL_BODY_BUFFERED;
    }

    public int doEndTag() throws JspException {

        if(fileStorage==null)
            throw new JspException("empty fileStorage class");


        if (language!=null)
        {

        }

        Long fileSize = fileStorage.getSize();
        Double aFileSize = fileSize.doubleValue();
        Double a1024 = 1024.0;
        String pfx;
        if (aFileSize>=a1024)
        {
            aFileSize/=a1024;
            if (aFileSize>=a1024)
            {
                aFileSize/=a1024;
                if (aFileSize>=a1024)
                {
                    aFileSize/=a1024;
                    pfx = " GB";
                } else pfx = " MB";
            } else pfx = " KB";
        } else pfx = " B";

        fileSize = aFileSize.longValue();

        if (targetBlank==null)
            targetBlank = true;

        if (randomParam ==null)
            randomParam = false;

        if (randomParam && (randomParamName==null || randomParamName.isEmpty()))
            randomParamName = "rnd";

        StringBuilder sb = new StringBuilder();

        sb.append("<a");
        if (targetBlank)
            sb.append(" target='_blank'");

        sb.append(" href='");
        if (fileDownloadPath==null && fileDownloadUrlById==null)
            fileDownloadPath = "";

        if (fileDownloadPath!=null)
        {
            sb.append(fileDownloadPath);
            sb.append(fileStorage.getFileUrl());
        } else if (fileDownloadUrlById!=null)
        {
            sb.append(fileDownloadUrlById);
            sb.append(fileStorage.getId());
            if (randomParam)
            {
                sb.append("&");
                sb.append(randomParamName);
                sb.append("=");
                Random random = new Random();
                sb.append(random.nextLong());
            }
        }
        sb.append("'>");

        if (fileTypeInfoMapKeyMime!=null && imageFolderUrl!=null && !imageFolderUrl.isEmpty())
        {
            String contentType = fileStorage.getContentType();
            String imageFile = null;
            if (contentType!=null)
            {
                FileTypeInfo info = fileTypeInfoMapKeyMime.get(contentType);
                if (info!=null)
                    imageFile = info.getImage();

            }
            if (imageFile!=null && !imageFile.isEmpty())
            {
                if (imageWidth==null)
                    imageWidth = 16;
                if (imageHeight==null)
                    imageHeight = 16;
                if (imageAlt==null)
                    imageAlt="";

                sb.append("<img src='").append(imageFolderUrl).append(imageFile).append("' width='").append(imageWidth).append("' height='").append(imageHeight).append("' alt='").append(imageAlt).append("'/>&nbsp;");
            }
        }

        sb.append(fileStorage.getFilename());
        sb.append(" (");
        sb.append(fileSize);
        sb.append(pfx);
        sb.append(")");
        sb.append("</a>");

        try {
            JspWriter out = pageContext.getOut();
            out.println(sb.toString());

        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }

        return EVAL_PAGE;
    }

    public void release() {
        fileStorage = null;
        language = null;
        imageFolderUrl = null;
        imageWidth = null;
        imageHeight = null;
        targetBlank = null;
        imageAlt = null;
        useIdPrefix = null;
        useFilename = null;
    }
}