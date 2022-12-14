package com.healt.cloud.checkup.service.ws.his.archive;

import com.healt.cloud.checkup.service.ws.his.MsgLog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author GuYue
 * @date 2022-07-04 17:45
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class ArchiveCreateReqBody {

    @XmlElement(name = "MsgLog")
    private MsgLog msgLog;

    @XmlElement(name = "PatientInfo")
    private ArchiveCreatePatientInfo patientInfo;

    @XmlElement(name = "CardInfo")
    private ArchiveCreateCardInfo cardInfo;

    public MsgLog getMsgLog() {
        return msgLog;
    }

    public void setMsgLog(MsgLog msgLog) {
        this.msgLog = msgLog;
    }

    public ArchiveCreatePatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(ArchiveCreatePatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    public ArchiveCreateCardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(ArchiveCreateCardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    @Override
    public String toString() {
        return "ArchiveCreateReqBody{" +
                "msgLog=" + msgLog +
                ", patientInfo=" + patientInfo +
                ", cardInfo=" + cardInfo +
                '}';
    }
}
