package com.healt.cloud.checkup.service.ws.his.userInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author linklee
 * @create 2022-07-01 16:28
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userInfo", propOrder = {
        "userName",
        "pyCode",
        "workDept",
        "workPost",
        "peopleClass",
        "peopleIdentifier"
})
public class UserInfo {

    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "WorkDept")
    protected String workDept;
    @XmlElement(name = "WorkPost")
    protected String workPost;
    @XmlElement(name = "PeopleClass")
    protected String peopleClass;
    @XmlElement(name = "PeopleIdentifier")
    protected String peopleIdentifier;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    public String getWorkDept() {
        return workDept;
    }

    public void setWorkDept(String workDept) {
        this.workDept = workDept;
    }

    public String getWorkPost() {
        return workPost;
    }

    public void setWorkPost(String workPost) {
        this.workPost = workPost;
    }

    public String getPeopleClass() {
        return peopleClass;
    }

    public void setPeopleClass(String peopleClass) {
        this.peopleClass = peopleClass;
    }

    public String getPeopleIdentifier() {
        return peopleIdentifier;
    }

    public void setPeopleIdentifier(String peopleIdentifier) {
        this.peopleIdentifier = peopleIdentifier;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", pyCode='" + pyCode + '\'' +
                ", workDept='" + workDept + '\'' +
                ", workPost='" + workPost + '\'' +
                ", peopleClass='" + peopleClass + '\'' +
                ", peopleIdentifier='" + peopleIdentifier + '\'' +
                '}';
    }
}
