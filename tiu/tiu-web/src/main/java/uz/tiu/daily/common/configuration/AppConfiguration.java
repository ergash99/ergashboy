package uz.tiu.daily.common.configuration;

import javax.annotation.PostConstruct;
import java.io.Serializable;


public class AppConfiguration implements Serializable {

    private RoleConfiguration roleConfiguration;
    private AuthConfiguration authConfiguration;
    private FileTypeConfiguration fileTypeConfiguration;
    private RepositoryConfiguration repositoryConfiguration;
    private ReportConfiguration reportConfiguration;


    public void setRoleConfiguration(RoleConfiguration roleConfiguration) {
        this.roleConfiguration = roleConfiguration;
    }
    public RoleConfiguration getRoleConfiguration() {
        return roleConfiguration;
    }

    public AuthConfiguration getAuthConfiguration() {
        return authConfiguration;
    }

    public void setAuthConfiguration(AuthConfiguration authConfiguration) {
        this.authConfiguration = authConfiguration;
    }

    public FileTypeConfiguration getFileTypeConfiguration() {
        return fileTypeConfiguration;
    }

    public void setFileTypeConfiguration(FileTypeConfiguration fileTypeConfiguration) {
        this.fileTypeConfiguration = fileTypeConfiguration;
    }

    public RepositoryConfiguration getRepositoryConfiguration() {
        return repositoryConfiguration;
    }

    public void setRepositoryConfiguration(RepositoryConfiguration repositoryConfiguration) {
        this.repositoryConfiguration = repositoryConfiguration;
    }

    public ReportConfiguration getReportConfiguration() {
        return reportConfiguration;
    }

    public void setReportConfiguration(ReportConfiguration reportConfiguration) {
        this.reportConfiguration = reportConfiguration;
    }

    @PostConstruct
    public void loadConfiguration()
    {

    }
}
