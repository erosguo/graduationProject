package cn.system.domain;

import java.io.Serializable;

/**
 * 系统管理员
 */
public class SystemManager implements Serializable {
    private String SystemManagerId;
    private String SystemManagerPassword;
    private String SystemManagerTel;
    private String SystemManagerEmail;
    private String SystemManagerName;

    public String getSystemManagerId() {
        return SystemManagerId;
    }

    public void setSystemManagerId(String systemManagerId) {
        SystemManagerId = systemManagerId;
    }

    public String getSystemManagerPassword() {
        return SystemManagerPassword;
    }

    public void setSystemManagerPassword(String systemManagerPassword) {
        SystemManagerPassword = systemManagerPassword;
    }

    public String getSystemManagerTel() {
        return SystemManagerTel;
    }

    public void setSystemManagerTel(String systemManagerTel) {
        SystemManagerTel = systemManagerTel;
    }

    public String getSystemManagerEmail() {
        return SystemManagerEmail;
    }

    public void setSystemManagerEmail(String systemManagerEmail) {
        SystemManagerEmail = systemManagerEmail;
    }

    public String getSystemManagerName() {
        return SystemManagerName;
    }

    public void setSystemManagerName(String systemManagerName) {
        SystemManagerName = systemManagerName;
    }


    @Override
    public String toString() {
        return "SystemManager{" +
                "SystemManagerId='" + SystemManagerId + '\'' +
                ", SystemManagerPassword='" + SystemManagerPassword + '\'' +
                ", SystemManagerTel='" + SystemManagerTel + '\'' +
                ", SystemManagerEmail='" + SystemManagerEmail + '\'' +
                ", SystemManagerName='" + SystemManagerName + '\'' +
                '}';
    }


}
