package com.healt.cloud.checkup.service.ws.his.userInfo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author linklee
 * @create 2022-07-01 15:05
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class UserInfoRequestBody {

    @XmlElement(name = "UserName")
    protected String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserInfoRequestBody{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
