
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>soapBaseResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="soapBaseResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Result" type="{http://wegohis.com}result" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapBaseResponse", propOrder = {
    "result"
})
@XmlSeeAlso({
    SsoUserInfoResponse.class,
    BcsUumUserResponse.class,
    OrganizationResponse.class,
    CodeTableResponse.class,
    FrequencyResponse.class,
    OutpDoctorInfoResponse.class,
    UsageDictResponse.class,
    QueryCategoryDetailDefinitionResponse.class,
    DiagnosisDictResponse.class,
    PatientAgeResponse.class,
    PdfReportResponse.class,
    ClinicItemResponse.class,
    SpecialClinicResponse.class,
    OperationResponse.class,
    AccountRecordResponse.class,
    ApplyCardResponse.class,
    PrepayBalanceResponse.class,
    EditPatientResponse.class,
    RegLockResponse.class,
    PhamItemResponse.class,
    CreateArchiveResponse.class,
    PrescritionQueryResponse.class,
    VerifyCardResponse.class,
    RegVisitResponse.class,
    BdMedInsResponse.class,
    OpcPaymentResponse.class,
    SearchArchiveResponse.class,
    OrderReserveResponse.class,
    RegMasterResponse.class,
    CancelRegResponse.class,
    PayDetailQueryResponse.class,
    PrescAdjustStatusResponse.class,
    OrderReserveMasterResponse.class,
    CancelOrderReserveResponse.class,
    MaterialClassResponse.class,
    OuptPatientSignInResponse.class,
    AccountInvestResponse.class,
    QueryPatientVisitInfoResponse.class,
    QueryBdClinicpriceListRrsponse.class,
    DiagnosticsQueryInfoResponse.class,
    BdAreaQueryResponse.class,
    BedDictResponse.class,
    PhamLocationResponse.class,
    HerbOrderResponse.class,
    MaterialQueryResponse.class,
    DetailBillingResponse.class,
    DetailReturnResponse.class,
    EleheCardGetPaientInfoResponse.class,
    SoapEmptyResponse.class,
    LeavePatientQueryResponse.class,
    NotPayDetailQueryResponse.class,
    DialysisSchedulingQueryResponse.class,
    EleheCardGetstAticsCodeResponse.class,
    EleheCardGetqrInfoResponse.class,
    GetTicketInfoResponse.class,
    InspectBackResponse.class,
    Orders.class,
    ExamineBackResponse.class,
    MedNumGrnResponse.class,
    MedInfo.class,
    PharmQrResponse.class,
    OperAccountResponse.class,
    UnpaidAccountQueryResponse.class,
    DistributionResponse.class,
    ConsultingRoomResponse.class
})
public class SoapBaseResponse {

    @XmlElement(name = "Result")
    protected Result result;

    /**
     * 获取result属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getResult() {
        return result;
    }

    /**
     * 设置result属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setResult(Result value) {
        this.result = value;
    }

    @Override
    public String toString() {
        return "SoapBaseResponse{" +
                "result=" + result +
                '}';
    }
}
