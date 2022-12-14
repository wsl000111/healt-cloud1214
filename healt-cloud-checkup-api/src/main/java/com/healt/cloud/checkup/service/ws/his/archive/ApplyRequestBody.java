package com.healt.cloud.checkup.service.ws.his.archive;

import com.healt.cloud.checkup.service.ws.his.MsgLog;
import com.healt.cloud.checkup.service.ws.his.PatientInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-06-29 16:40
 * @description: TODO
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class ApplyRequestBody {

    @XmlElement(name = "MsgLog")
    private MsgLog msgLog;

    @XmlElement(name = "PatientInfo")
    private PatientInfo patientInfo;

    public MsgLog getMsgLog() {
        return msgLog;
    }

    public void setMsgLog(MsgLog msgLog) {
        this.msgLog = msgLog;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    @Override
    public String toString() {
        return "Body{" +
                "msgLog=" + msgLog +
                ", patientInfo=" + patientInfo +
                '}';
    }
}
