
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.healt.cloud.checkup.service.ws.his package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AccountInfo_QNAME = new QName("http://wegohis.com", "AccountInfo");
    private final static QName _AgeInfo_QNAME = new QName("http://wegohis.com", "AgeInfo");
    private final static QName _Area_QNAME = new QName("http://wegohis.com", "Area");
    private final static QName _BedInfo_QNAME = new QName("http://wegohis.com", "BedInfo");
    private final static QName _Body_QNAME = new QName("http://wegohis.com", "Body");
    private final static QName _CategoryDetailDefinition_QNAME = new QName("http://wegohis.com", "CategoryDetailDefinition");
    private final static QName _ClinicItem_QNAME = new QName("http://wegohis.com", "ClinicItem");
    private final static QName _ClinicPrice_QNAME = new QName("http://wegohis.com", "ClinicPrice");
    private final static QName _ConsultingRoom_QNAME = new QName("http://wegohis.com", "ConsultingRoom");
    private final static QName _DiagInfo_QNAME = new QName("http://wegohis.com", "DiagInfo");
    private final static QName _Diagnosis_QNAME = new QName("http://wegohis.com", "Diagnosis");
    private final static QName _DialysisScheduling_QNAME = new QName("http://wegohis.com", "DialysisScheduling");
    private final static QName _DialysisSchedulingList_QNAME = new QName("http://wegohis.com", "DialysisSchedulingList");
    private final static QName _DoctorInfo_QNAME = new QName("http://wegohis.com", "DoctorInfo");
    private final static QName _FrequencyDict_QNAME = new QName("http://wegohis.com", "FrequencyDict");
    private final static QName _Header_QNAME = new QName("http://wegohis.com", "Header");
    private final static QName _Item_QNAME = new QName("http://wegohis.com", "Item");
    private final static QName _Material_QNAME = new QName("http://wegohis.com", "Material");
    private final static QName _MedIns_QNAME = new QName("http://wegohis.com", "MedIns");
    private final static QName _MsgLog_QNAME = new QName("http://wegohis.com", "MsgLog");
    private final static QName _OperationDict_QNAME = new QName("http://wegohis.com", "OperationDict");
    private final static QName _Organization_QNAME = new QName("http://wegohis.com", "Organization");
    private final static QName _OutpOrder_QNAME = new QName("http://wegohis.com", "OutpOrder");
    private final static QName _OutpOrderItem_QNAME = new QName("http://wegohis.com", "OutpOrderItem");
    private final static QName _PatientInfo_QNAME = new QName("http://wegohis.com", "PatientInfo");
    private final static QName _PatientQrInfo_QNAME = new QName("http://wegohis.com", "PatientQrInfo");
    private final static QName _PatientVisit_QNAME = new QName("http://wegohis.com", "PatientVisit");
    private final static QName _PhamInfo_QNAME = new QName("http://wegohis.com", "PhamInfo");
    private final static QName _PhamItem_QNAME = new QName("http://wegohis.com", "PhamItem");
    private final static QName _Prescription_QNAME = new QName("http://wegohis.com", "Prescription");
    private final static QName _RechargeInfo_QNAME = new QName("http://wegohis.com", "RechargeInfo");
    private final static QName _ReportInfo_QNAME = new QName("http://wegohis.com", "ReportInfo");
    private final static QName _Request_QNAME = new QName("http://wegohis.com", "Request");
    private final static QName _ReserveInfo_QNAME = new QName("http://wegohis.com", "ReserveInfo");
    private final static QName _Response_QNAME = new QName("http://wegohis.com", "Response");
    private final static QName _ReturnInfo_QNAME = new QName("http://wegohis.com", "ReturnInfo");
    private final static QName _Schedulings_QNAME = new QName("http://wegohis.com", "Schedulings");
    private final static QName _SpecialClinic_QNAME = new QName("http://wegohis.com", "SpecialClinic");
    private final static QName _Standard_QNAME = new QName("http://wegohis.com", "Standard");
    private final static QName _Message_QNAME = new QName("http://wegohis.com", "message");
    private final static QName _MessageResponse_QNAME = new QName("http://wegohis.com", "messageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.healt.cloud.checkup.service.ws.his
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultingRoomResponse }
     * 
     */
    public ConsultingRoomResponse createConsultingRoomResponse() {
        return new ConsultingRoomResponse();
    }

    /**
     * Create an instance of {@link UnpaidAccountQueryResponse }
     * 
     */
    public UnpaidAccountQueryResponse createUnpaidAccountQueryResponse() {
        return new UnpaidAccountQueryResponse();
    }

    /**
     * Create an instance of {@link OperAccountResponse }
     * 
     */
    public OperAccountResponse createOperAccountResponse() {
        return new OperAccountResponse();
    }

    /**
     * Create an instance of {@link ExamineBackResponse }
     * 
     */
    public ExamineBackResponse createExamineBackResponse() {
        return new ExamineBackResponse();
    }

    /**
     * Create an instance of {@link InspectBackResponse }
     * 
     */
    public InspectBackResponse createInspectBackResponse() {
        return new InspectBackResponse();
    }

    /**
     * Create an instance of {@link GetTicketInfoResponse }
     * 
     */
    public GetTicketInfoResponse createGetTicketInfoResponse() {
        return new GetTicketInfoResponse();
    }

    /**
     * Create an instance of {@link NotPayDetailQueryResponse }
     * 
     */
    public NotPayDetailQueryResponse createNotPayDetailQueryResponse() {
        return new NotPayDetailQueryResponse();
    }

    /**
     * Create an instance of {@link LeavePatientQueryResponse }
     * 
     */
    public LeavePatientQueryResponse createLeavePatientQueryResponse() {
        return new LeavePatientQueryResponse();
    }

    /**
     * Create an instance of {@link MaterialQueryResponse }
     * 
     */
    public MaterialQueryResponse createMaterialQueryResponse() {
        return new MaterialQueryResponse();
    }

    /**
     * Create an instance of {@link HerbOrderResponse }
     * 
     */
    public HerbOrderResponse createHerbOrderResponse() {
        return new HerbOrderResponse();
    }

    /**
     * Create an instance of {@link PhamLocationResponse }
     * 
     */
    public PhamLocationResponse createPhamLocationResponse() {
        return new PhamLocationResponse();
    }

    /**
     * Create an instance of {@link BedDictResponse }
     * 
     */
    public BedDictResponse createBedDictResponse() {
        return new BedDictResponse();
    }

    /**
     * Create an instance of {@link BdAreaQueryResponse }
     * 
     */
    public BdAreaQueryResponse createBdAreaQueryResponse() {
        return new BdAreaQueryResponse();
    }

    /**
     * Create an instance of {@link QueryBdClinicpriceListRrsponse }
     * 
     */
    public QueryBdClinicpriceListRrsponse createQueryBdClinicpriceListRrsponse() {
        return new QueryBdClinicpriceListRrsponse();
    }

    /**
     * Create an instance of {@link QueryPatientVisitInfoResponse }
     * 
     */
    public QueryPatientVisitInfoResponse createQueryPatientVisitInfoResponse() {
        return new QueryPatientVisitInfoResponse();
    }

    /**
     * Create an instance of {@link MaterialClassResponse }
     * 
     */
    public MaterialClassResponse createMaterialClassResponse() {
        return new MaterialClassResponse();
    }

    /**
     * Create an instance of {@link PayDetailQueryResponse }
     * 
     */
    public PayDetailQueryResponse createPayDetailQueryResponse() {
        return new PayDetailQueryResponse();
    }

    /**
     * Create an instance of {@link RegMasterResponse }
     * 
     */
    public RegMasterResponse createRegMasterResponse() {
        return new RegMasterResponse();
    }

    /**
     * Create an instance of {@link OrderReserveResponse }
     * 
     */
    public OrderReserveResponse createOrderReserveResponse() {
        return new OrderReserveResponse();
    }

    /**
     * Create an instance of {@link BdMedInsResponse }
     * 
     */
    public BdMedInsResponse createBdMedInsResponse() {
        return new BdMedInsResponse();
    }

    /**
     * Create an instance of {@link PrescritionQueryResponse }
     * 
     */
    public PrescritionQueryResponse createPrescritionQueryResponse() {
        return new PrescritionQueryResponse();
    }

    /**
     * Create an instance of {@link PhamItemResponse }
     * 
     */
    public PhamItemResponse createPhamItemResponse() {
        return new PhamItemResponse();
    }

    /**
     * Create an instance of {@link AccountRecordResponse }
     * 
     */
    public AccountRecordResponse createAccountRecordResponse() {
        return new AccountRecordResponse();
    }

    /**
     * Create an instance of {@link OperationResponse }
     * 
     */
    public OperationResponse createOperationResponse() {
        return new OperationResponse();
    }

    /**
     * Create an instance of {@link SpecialClinicResponse }
     * 
     */
    public SpecialClinicResponse createSpecialClinicResponse() {
        return new SpecialClinicResponse();
    }

    /**
     * Create an instance of {@link ClinicItemResponse }
     * 
     */
    public ClinicItemResponse createClinicItemResponse() {
        return new ClinicItemResponse();
    }

    /**
     * Create an instance of {@link PdfReportResponse }
     * 
     */
    public PdfReportResponse createPdfReportResponse() {
        return new PdfReportResponse();
    }

    /**
     * Create an instance of {@link DiagnosisDictResponse }
     * 
     */
    public DiagnosisDictResponse createDiagnosisDictResponse() {
        return new DiagnosisDictResponse();
    }

    /**
     * Create an instance of {@link QueryCategoryDetailDefinitionResponse }
     * 
     */
    public QueryCategoryDetailDefinitionResponse createQueryCategoryDetailDefinitionResponse() {
        return new QueryCategoryDetailDefinitionResponse();
    }

    /**
     * Create an instance of {@link UsageDictResponse }
     * 
     */
    public UsageDictResponse createUsageDictResponse() {
        return new UsageDictResponse();
    }

    /**
     * Create an instance of {@link OutpDoctorInfoResponse }
     * 
     */
    public OutpDoctorInfoResponse createOutpDoctorInfoResponse() {
        return new OutpDoctorInfoResponse();
    }

    /**
     * Create an instance of {@link FrequencyResponse }
     * 
     */
    public FrequencyResponse createFrequencyResponse() {
        return new FrequencyResponse();
    }

    /**
     * Create an instance of {@link CodeTableResponse }
     * 
     */
    public CodeTableResponse createCodeTableResponse() {
        return new CodeTableResponse();
    }

    /**
     * Create an instance of {@link OrganizationResponse }
     * 
     */
    public OrganizationResponse createOrganizationResponse() {
        return new OrganizationResponse();
    }

    /**
     * Create an instance of {@link BcsUumUserResponse }
     * 
     */
    public BcsUumUserResponse createBcsUumUserResponse() {
        return new BcsUumUserResponse();
    }

    /**
     * Create an instance of {@link UserPrivilege }
     * 
     */
    public UserPrivilege createUserPrivilege() {
        return new UserPrivilege();
    }

    /**
     * Create an instance of {@link SsoUserInfoResponse }
     * 
     */
    public SsoUserInfoResponse createSsoUserInfoResponse() {
        return new SsoUserInfoResponse();
    }

    /**
     * Create an instance of {@link CodeTable }
     * 
     */
    public CodeTable createCodeTable() {
        return new CodeTable();
    }

    /**
     * Create an instance of {@link DiagnosticsQueryPatientInfoVO }
     * 
     */
    public DiagnosticsQueryPatientInfoVO createDiagnosticsQueryPatientInfoVO() {
        return new DiagnosticsQueryPatientInfoVO();
    }

    /**
     * Create an instance of {@link OutpOrderInfo }
     * 
     */
    public OutpOrderInfo createOutpOrderInfo() {
        return new OutpOrderInfo();
    }

    /**
     * Create an instance of {@link QueryDialysisScheduling }
     * 
     */
    public QueryDialysisScheduling createQueryDialysisScheduling() {
        return new QueryDialysisScheduling();
    }

    /**
     * Create an instance of {@link PatientAgeEntity }
     * 
     */
    public PatientAgeEntity createPatientAgeEntity() {
        return new PatientAgeEntity();
    }

    /**
     * Create an instance of {@link BdAreaQueryVO }
     * 
     */
    public BdAreaQueryVO createBdAreaQueryVO() {
        return new BdAreaQueryVO();
    }

    /**
     * Create an instance of {@link BedDictVO }
     * 
     */
    public BedDictVO createBedDictVO() {
        return new BedDictVO();
    }

    /**
     * Create an instance of {@link CategoryDetailDefinition }
     * 
     */
    public CategoryDetailDefinition createCategoryDetailDefinition() {
        return new CategoryDetailDefinition();
    }

    /**
     * Create an instance of {@link ClinicItemEntity }
     * 
     */
    public ClinicItemEntity createClinicItemEntity() {
        return new ClinicItemEntity();
    }

    /**
     * Create an instance of {@link BdClinicpriceQueryVO }
     * 
     */
    public BdClinicpriceQueryVO createBdClinicpriceQueryVO() {
        return new BdClinicpriceQueryVO();
    }

    /**
     * Create an instance of {@link ConsultingRoomEntity }
     * 
     */
    public ConsultingRoomEntity createConsultingRoomEntity() {
        return new ConsultingRoomEntity();
    }

    /**
     * Create an instance of {@link DiagnosticsQueryEntity }
     * 
     */
    public DiagnosticsQueryEntity createDiagnosticsQueryEntity() {
        return new DiagnosticsQueryEntity();
    }

    /**
     * Create an instance of {@link DiagnosisDict }
     * 
     */
    public DiagnosisDict createDiagnosisDict() {
        return new DiagnosisDict();
    }

    /**
     * Create an instance of {@link DialysisPatientInfo }
     * 
     */
    public DialysisPatientInfo createDialysisPatientInfo() {
        return new DialysisPatientInfo();
    }

    /**
     * Create an instance of {@link FrequencyEntity }
     * 
     */
    public FrequencyEntity createFrequencyEntity() {
        return new FrequencyEntity();
    }

    /**
     * Create an instance of {@link SoapHeader }
     * 
     */
    public SoapHeader createSoapHeader() {
        return new SoapHeader();
    }

    /**
     * Create an instance of {@link CodeTableItem }
     * 
     */
    public CodeTableItem createCodeTableItem() {
        return new CodeTableItem();
    }

    /**
     * Create an instance of {@link BdMedInsQueryVO }
     * 
     */
    public BdMedInsQueryVO createBdMedInsQueryVO() {
        return new BdMedInsQueryVO();
    }

    /**
     * Create an instance of {@link BaseMsgLog }
     * 
     */
    public BaseMsgLog createBaseMsgLog() {
        return new BaseMsgLog();
    }

    /**
     * Create an instance of {@link OperationEntity }
     * 
     */
    public OperationEntity createOperationEntity() {
        return new OperationEntity();
    }

    /**
     * Create an instance of {@link OutpOrderItem }
     * 
     */
    public OutpOrderItem createOutpOrderItem() {
        return new OutpOrderItem();
    }

    /**
     * Create an instance of {@link PatientInfo }
     * 
     */
    public PatientInfo createPatientInfo() {
        return new PatientInfo();
    }

    /**
     * Create an instance of {@link EleheCardGetqrInfoEntity }
     * 
     */
    public EleheCardGetqrInfoEntity createEleheCardGetqrInfoEntity() {
        return new EleheCardGetqrInfoEntity();
    }

    /**
     * Create an instance of {@link PhamLocationPO }
     * 
     */
    public PhamLocationPO createPhamLocationPO() {
        return new PhamLocationPO();
    }

    /**
     * Create an instance of {@link PhamItem }
     * 
     */
    public PhamItem createPhamItem() {
        return new PhamItem();
    }

    /**
     * Create an instance of {@link PrescriptionPO }
     * 
     */
    public PrescriptionPO createPrescriptionPO() {
        return new PrescriptionPO();
    }

    /**
     * Create an instance of {@link PdfReport }
     * 
     */
    public PdfReport createPdfReport() {
        return new PdfReport();
    }

    /**
     * Create an instance of {@link SoapRequest }
     * 
     */
    public SoapRequest createSoapRequest() {
        return new SoapRequest();
    }

    /**
     * Create an instance of {@link ReserveInfo }
     * 
     */
    public ReserveInfo createReserveInfo() {
        return new ReserveInfo();
    }

    /**
     * Create an instance of {@link SoapResponse }
     * 
     */
    public SoapResponse createSoapResponse() {
        return new SoapResponse();
    }

    /**
     * Create an instance of {@link EleheCardGetstAticsCodeEntity }
     * 
     */
    public EleheCardGetstAticsCodeEntity createEleheCardGetstAticsCodeEntity() {
        return new EleheCardGetstAticsCodeEntity();
    }

    /**
     * Create an instance of {@link QueryScheduling }
     * 
     */
    public QueryScheduling createQueryScheduling() {
        return new QueryScheduling();
    }

    /**
     * Create an instance of {@link SpecialClinic }
     * 
     */
    public SpecialClinic createSpecialClinic() {
        return new SpecialClinic();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link MessageResponse }
     * 
     */
    public MessageResponse createMessageResponse() {
        return new MessageResponse();
    }

    /**
     * Create an instance of {@link SoapHeaderResponse }
     * 
     */
    public SoapHeaderResponse createSoapHeaderResponse() {
        return new SoapHeaderResponse();
    }

    /**
     * Create an instance of {@link SoapBaseResponse }
     * 
     */
    public SoapBaseResponse createSoapBaseResponse() {
        return new SoapBaseResponse();
    }

    /**
     * Create an instance of {@link BcsUumUser }
     * 
     */
    public BcsUumUser createBcsUumUser() {
        return new BcsUumUser();
    }

    /**
     * Create an instance of {@link MediTeam }
     * 
     */
    public MediTeam createMediTeam() {
        return new MediTeam();
    }

    /**
     * Create an instance of {@link UserPrivilegeRole }
     * 
     */
    public UserPrivilegeRole createUserPrivilegeRole() {
        return new UserPrivilegeRole();
    }

    /**
     * Create an instance of {@link UserPrivilegeFunc }
     * 
     */
    public UserPrivilegeFunc createUserPrivilegeFunc() {
        return new UserPrivilegeFunc();
    }

    /**
     * Create an instance of {@link UserPrivilegeSysCtlAuth }
     * 
     */
    public UserPrivilegeSysCtlAuth createUserPrivilegeSysCtlAuth() {
        return new UserPrivilegeSysCtlAuth();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link ResultResponse }
     * 
     */
    public ResultResponse createResultResponse() {
        return new ResultResponse();
    }

    /**
     * Create an instance of {@link Org }
     * 
     */
    public Org createOrg() {
        return new Org();
    }

    /**
     * Create an instance of {@link OutDoctorInfoVO }
     * 
     */
    public OutDoctorInfoVO createOutDoctorInfoVO() {
        return new OutDoctorInfoVO();
    }

    /**
     * Create an instance of {@link UsageDict }
     * 
     */
    public UsageDict createUsageDict() {
        return new UsageDict();
    }

    /**
     * Create an instance of {@link PatientAgeResponse }
     * 
     */
    public PatientAgeResponse createPatientAgeResponse() {
        return new PatientAgeResponse();
    }

    /**
     * Create an instance of {@link BalanceDetail }
     * 
     */
    public BalanceDetail createBalanceDetail() {
        return new BalanceDetail();
    }

    /**
     * Create an instance of {@link ApplyCardResponse }
     * 
     */
    public ApplyCardResponse createApplyCardResponse() {
        return new ApplyCardResponse();
    }

    /**
     * Create an instance of {@link ApplyCardPatientInfoVO }
     * 
     */
    public ApplyCardPatientInfoVO createApplyCardPatientInfoVO() {
        return new ApplyCardPatientInfoVO();
    }

    /**
     * Create an instance of {@link CreateArchiveAccountInfoVO }
     * 
     */
    public CreateArchiveAccountInfoVO createCreateArchiveAccountInfoVO() {
        return new CreateArchiveAccountInfoVO();
    }

    /**
     * Create an instance of {@link PrepayBalanceResponse }
     * 
     */
    public PrepayBalanceResponse createPrepayBalanceResponse() {
        return new PrepayBalanceResponse();
    }

    /**
     * Create an instance of {@link EditPatientResponse }
     * 
     */
    public EditPatientResponse createEditPatientResponse() {
        return new EditPatientResponse();
    }

    /**
     * Create an instance of {@link RegLockResponse }
     * 
     */
    public RegLockResponse createRegLockResponse() {
        return new RegLockResponse();
    }

    /**
     * Create an instance of {@link RegLockInfo }
     * 
     */
    public RegLockInfo createRegLockInfo() {
        return new RegLockInfo();
    }

    /**
     * Create an instance of {@link CreateArchiveResponse }
     * 
     */
    public CreateArchiveResponse createCreateArchiveResponse() {
        return new CreateArchiveResponse();
    }

    /**
     * Create an instance of {@link CreateArchivePatientInfoVO }
     * 
     */
    public CreateArchivePatientInfoVO createCreateArchivePatientInfoVO() {
        return new CreateArchivePatientInfoVO();
    }

    /**
     * Create an instance of {@link VerifyCardResponse }
     * 
     */
    public VerifyCardResponse createVerifyCardResponse() {
        return new VerifyCardResponse();
    }

    /**
     * Create an instance of {@link VerifyCardPatientInfoVO }
     * 
     */
    public VerifyCardPatientInfoVO createVerifyCardPatientInfoVO() {
        return new VerifyCardPatientInfoVO();
    }

    /**
     * Create an instance of {@link VerifyCardAccountInfoVO }
     * 
     */
    public VerifyCardAccountInfoVO createVerifyCardAccountInfoVO() {
        return new VerifyCardAccountInfoVO();
    }

    /**
     * Create an instance of {@link VerifyCardInfoVO }
     * 
     */
    public VerifyCardInfoVO createVerifyCardInfoVO() {
        return new VerifyCardInfoVO();
    }

    /**
     * Create an instance of {@link RegVisitResponse }
     * 
     */
    public RegVisitResponse createRegVisitResponse() {
        return new RegVisitResponse();
    }

    /**
     * Create an instance of {@link RegVisitVO }
     * 
     */
    public RegVisitVO createRegVisitVO() {
        return new RegVisitVO();
    }

    /**
     * Create an instance of {@link OpcPaymentResponse }
     * 
     */
    public OpcPaymentResponse createOpcPaymentResponse() {
        return new OpcPaymentResponse();
    }

    /**
     * Create an instance of {@link SettleInfoEntity }
     * 
     */
    public SettleInfoEntity createSettleInfoEntity() {
        return new SettleInfoEntity();
    }

    /**
     * Create an instance of {@link SearchArchiveResponse }
     * 
     */
    public SearchArchiveResponse createSearchArchiveResponse() {
        return new SearchArchiveResponse();
    }

    /**
     * Create an instance of {@link SearchArchivePatientInfoVO }
     * 
     */
    public SearchArchivePatientInfoVO createSearchArchivePatientInfoVO() {
        return new SearchArchivePatientInfoVO();
    }

    /**
     * Create an instance of {@link RegMaster }
     * 
     */
    public RegMaster createRegMaster() {
        return new RegMaster();
    }

    /**
     * Create an instance of {@link RegMasterAtime }
     * 
     */
    public RegMasterAtime createRegMasterAtime() {
        return new RegMasterAtime();
    }

    /**
     * Create an instance of {@link RegMasterDetail }
     * 
     */
    public RegMasterDetail createRegMasterDetail() {
        return new RegMasterDetail();
    }

    /**
     * Create an instance of {@link CancelRegResponse }
     * 
     */
    public CancelRegResponse createCancelRegResponse() {
        return new CancelRegResponse();
    }

    /**
     * Create an instance of {@link PayInfo }
     * 
     */
    public PayInfo createPayInfo() {
        return new PayInfo();
    }

    /**
     * Create an instance of {@link NotpayDetailQueryPatientInfoVO }
     * 
     */
    public NotpayDetailQueryPatientInfoVO createNotpayDetailQueryPatientInfoVO() {
        return new NotpayDetailQueryPatientInfoVO();
    }

    /**
     * Create an instance of {@link PayDetailQuery }
     * 
     */
    public PayDetailQuery createPayDetailQuery() {
        return new PayDetailQuery();
    }

    /**
     * Create an instance of {@link PrescAdjustStatusResponse }
     * 
     */
    public PrescAdjustStatusResponse createPrescAdjustStatusResponse() {
        return new PrescAdjustStatusResponse();
    }

    /**
     * Create an instance of {@link OrderReserveMasterResponse }
     * 
     */
    public OrderReserveMasterResponse createOrderReserveMasterResponse() {
        return new OrderReserveMasterResponse();
    }

    /**
     * Create an instance of {@link OrderReserveMaster }
     * 
     */
    public OrderReserveMaster createOrderReserveMaster() {
        return new OrderReserveMaster();
    }

    /**
     * Create an instance of {@link CancelOrderReserveResponse }
     * 
     */
    public CancelOrderReserveResponse createCancelOrderReserveResponse() {
        return new CancelOrderReserveResponse();
    }

    /**
     * Create an instance of {@link MaterialClassPO }
     * 
     */
    public MaterialClassPO createMaterialClassPO() {
        return new MaterialClassPO();
    }

    /**
     * Create an instance of {@link OuptPatientSignInResponse }
     * 
     */
    public OuptPatientSignInResponse createOuptPatientSignInResponse() {
        return new OuptPatientSignInResponse();
    }

    /**
     * Create an instance of {@link AccountInvestResponse }
     * 
     */
    public AccountInvestResponse createAccountInvestResponse() {
        return new AccountInvestResponse();
    }

    /**
     * Create an instance of {@link AccountInvestRechargeInfo }
     * 
     */
    public AccountInvestRechargeInfo createAccountInvestRechargeInfo() {
        return new AccountInvestRechargeInfo();
    }

    /**
     * Create an instance of {@link QueryPatientVisitEntity }
     * 
     */
    public QueryPatientVisitEntity createQueryPatientVisitEntity() {
        return new QueryPatientVisitEntity();
    }

    /**
     * Create an instance of {@link DiagnosticsQueryInfoResponse }
     * 
     */
    public DiagnosticsQueryInfoResponse createDiagnosticsQueryInfoResponse() {
        return new DiagnosticsQueryInfoResponse();
    }

    /**
     * Create an instance of {@link MsgLog }
     * 
     */
    public MsgLog createMsgLog() {
        return new MsgLog();
    }

    /**
     * Create an instance of {@link OutpOrderPatientInfo }
     * 
     */
    public OutpOrderPatientInfo createOutpOrderPatientInfo() {
        return new OutpOrderPatientInfo();
    }

    /**
     * Create an instance of {@link MaterialQueryVO }
     * 
     */
    public MaterialQueryVO createMaterialQueryVO() {
        return new MaterialQueryVO();
    }

    /**
     * Create an instance of {@link DetailBillingResponse }
     * 
     */
    public DetailBillingResponse createDetailBillingResponse() {
        return new DetailBillingResponse();
    }

    /**
     * Create an instance of {@link DetailReturnResponse }
     * 
     */
    public DetailReturnResponse createDetailReturnResponse() {
        return new DetailReturnResponse();
    }

    /**
     * Create an instance of {@link EleheCardGetPaientInfoResponse }
     * 
     */
    public EleheCardGetPaientInfoResponse createEleheCardGetPaientInfoResponse() {
        return new EleheCardGetPaientInfoResponse();
    }

    /**
     * Create an instance of {@link SoapEmptyResponse }
     * 
     */
    public SoapEmptyResponse createSoapEmptyResponse() {
        return new SoapEmptyResponse();
    }

    /**
     * Create an instance of {@link LeavePatientInfo }
     * 
     */
    public LeavePatientInfo createLeavePatientInfo() {
        return new LeavePatientInfo();
    }

    /**
     * Create an instance of {@link NotPayDetailQuery }
     * 
     */
    public NotPayDetailQuery createNotPayDetailQuery() {
        return new NotPayDetailQuery();
    }

    /**
     * Create an instance of {@link DialysisSchedulingQueryResponse }
     * 
     */
    public DialysisSchedulingQueryResponse createDialysisSchedulingQueryResponse() {
        return new DialysisSchedulingQueryResponse();
    }

    /**
     * Create an instance of {@link EleheCardGetstAticsCodeResponse }
     * 
     */
    public EleheCardGetstAticsCodeResponse createEleheCardGetstAticsCodeResponse() {
        return new EleheCardGetstAticsCodeResponse();
    }

    /**
     * Create an instance of {@link EleheCardGetqrInfoResponse }
     * 
     */
    public EleheCardGetqrInfoResponse createEleheCardGetqrInfoResponse() {
        return new EleheCardGetqrInfoResponse();
    }

    /**
     * Create an instance of {@link GetTicketInfo }
     * 
     */
    public GetTicketInfo createGetTicketInfo() {
        return new GetTicketInfo();
    }

    /**
     * Create an instance of {@link Orders }
     * 
     */
    public Orders createOrders() {
        return new Orders();
    }

    /**
     * Create an instance of {@link MedNumGrnResponse }
     * 
     */
    public MedNumGrnResponse createMedNumGrnResponse() {
        return new MedNumGrnResponse();
    }

    /**
     * Create an instance of {@link MedInfo }
     * 
     */
    public MedInfo createMedInfo() {
        return new MedInfo();
    }

    /**
     * Create an instance of {@link PharmQrResponse }
     * 
     */
    public PharmQrResponse createPharmQrResponse() {
        return new PharmQrResponse();
    }

    /**
     * Create an instance of {@link PdaItem }
     * 
     */
    public PdaItem createPdaItem() {
        return new PdaItem();
    }

    /**
     * Create an instance of {@link AccountInfo }
     * 
     */
    public AccountInfo createAccountInfo() {
        return new AccountInfo();
    }

    /**
     * Create an instance of {@link UnpaidAccountInfo }
     * 
     */
    public UnpaidAccountInfo createUnpaidAccountInfo() {
        return new UnpaidAccountInfo();
    }

    /**
     * Create an instance of {@link DistributionResponse }
     * 
     */
    public DistributionResponse createDistributionResponse() {
        return new DistributionResponse();
    }

    /**
     * Create an instance of {@link ConsultingRoomResponse.ConsultingRoomList }
     * 
     */
    public ConsultingRoomResponse.ConsultingRoomList createConsultingRoomResponseConsultingRoomList() {
        return new ConsultingRoomResponse.ConsultingRoomList();
    }

    /**
     * Create an instance of {@link UnpaidAccountQueryResponse.AccountInfoList }
     * 
     */
    public UnpaidAccountQueryResponse.AccountInfoList createUnpaidAccountQueryResponseAccountInfoList() {
        return new UnpaidAccountQueryResponse.AccountInfoList();
    }

    /**
     * Create an instance of {@link OperAccountResponse.AccountInfoList }
     * 
     */
    public OperAccountResponse.AccountInfoList createOperAccountResponseAccountInfoList() {
        return new OperAccountResponse.AccountInfoList();
    }

    /**
     * Create an instance of {@link ExamineBackResponse.OrdersList }
     * 
     */
    public ExamineBackResponse.OrdersList createExamineBackResponseOrdersList() {
        return new ExamineBackResponse.OrdersList();
    }

    /**
     * Create an instance of {@link InspectBackResponse.OrdersList }
     * 
     */
    public InspectBackResponse.OrdersList createInspectBackResponseOrdersList() {
        return new InspectBackResponse.OrdersList();
    }

    /**
     * Create an instance of {@link GetTicketInfoResponse.TicketInfoList }
     * 
     */
    public GetTicketInfoResponse.TicketInfoList createGetTicketInfoResponseTicketInfoList() {
        return new GetTicketInfoResponse.TicketInfoList();
    }

    /**
     * Create an instance of {@link NotPayDetailQueryResponse.ChargeItemList }
     * 
     */
    public NotPayDetailQueryResponse.ChargeItemList createNotPayDetailQueryResponseChargeItemList() {
        return new NotPayDetailQueryResponse.ChargeItemList();
    }

    /**
     * Create an instance of {@link LeavePatientQueryResponse.PatientInfoList }
     * 
     */
    public LeavePatientQueryResponse.PatientInfoList createLeavePatientQueryResponsePatientInfoList() {
        return new LeavePatientQueryResponse.PatientInfoList();
    }

    /**
     * Create an instance of {@link MaterialQueryResponse.MaterialList }
     * 
     */
    public MaterialQueryResponse.MaterialList createMaterialQueryResponseMaterialList() {
        return new MaterialQueryResponse.MaterialList();
    }

    /**
     * Create an instance of {@link HerbOrderResponse.OutpOrderList }
     * 
     */
    public HerbOrderResponse.OutpOrderList createHerbOrderResponseOutpOrderList() {
        return new HerbOrderResponse.OutpOrderList();
    }

    /**
     * Create an instance of {@link PhamLocationResponse.PhamInfoList }
     * 
     */
    public PhamLocationResponse.PhamInfoList createPhamLocationResponsePhamInfoList() {
        return new PhamLocationResponse.PhamInfoList();
    }

    /**
     * Create an instance of {@link BedDictResponse.BedInfoList }
     * 
     */
    public BedDictResponse.BedInfoList createBedDictResponseBedInfoList() {
        return new BedDictResponse.BedInfoList();
    }

    /**
     * Create an instance of {@link BdAreaQueryResponse.AreaList }
     * 
     */
    public BdAreaQueryResponse.AreaList createBdAreaQueryResponseAreaList() {
        return new BdAreaQueryResponse.AreaList();
    }

    /**
     * Create an instance of {@link QueryBdClinicpriceListRrsponse.ClinicPriceList }
     * 
     */
    public QueryBdClinicpriceListRrsponse.ClinicPriceList createQueryBdClinicpriceListRrsponseClinicPriceList() {
        return new QueryBdClinicpriceListRrsponse.ClinicPriceList();
    }

    /**
     * Create an instance of {@link QueryPatientVisitInfoResponse.RegVisitList }
     * 
     */
    public QueryPatientVisitInfoResponse.RegVisitList createQueryPatientVisitInfoResponseRegVisitList() {
        return new QueryPatientVisitInfoResponse.RegVisitList();
    }

    /**
     * Create an instance of {@link MaterialClassResponse.MaterialList }
     * 
     */
    public MaterialClassResponse.MaterialList createMaterialClassResponseMaterialList() {
        return new MaterialClassResponse.MaterialList();
    }

    /**
     * Create an instance of {@link PayDetailQueryResponse.ChargeItemList }
     * 
     */
    public PayDetailQueryResponse.ChargeItemList createPayDetailQueryResponseChargeItemList() {
        return new PayDetailQueryResponse.ChargeItemList();
    }

    /**
     * Create an instance of {@link RegMasterResponse.RegMasterList }
     * 
     */
    public RegMasterResponse.RegMasterList createRegMasterResponseRegMasterList() {
        return new RegMasterResponse.RegMasterList();
    }

    /**
     * Create an instance of {@link OrderReserveResponse.ReserveList }
     * 
     */
    public OrderReserveResponse.ReserveList createOrderReserveResponseReserveList() {
        return new OrderReserveResponse.ReserveList();
    }

    /**
     * Create an instance of {@link BdMedInsResponse.MedInsList }
     * 
     */
    public BdMedInsResponse.MedInsList createBdMedInsResponseMedInsList() {
        return new BdMedInsResponse.MedInsList();
    }

    /**
     * Create an instance of {@link PrescritionQueryResponse.PrescriptionList }
     * 
     */
    public PrescritionQueryResponse.PrescriptionList createPrescritionQueryResponsePrescriptionList() {
        return new PrescritionQueryResponse.PrescriptionList();
    }

    /**
     * Create an instance of {@link PhamItemResponse.PhamItemList }
     * 
     */
    public PhamItemResponse.PhamItemList createPhamItemResponsePhamItemList() {
        return new PhamItemResponse.PhamItemList();
    }

    /**
     * Create an instance of {@link AccountRecordResponse.BalanceDetailList }
     * 
     */
    public AccountRecordResponse.BalanceDetailList createAccountRecordResponseBalanceDetailList() {
        return new AccountRecordResponse.BalanceDetailList();
    }

    /**
     * Create an instance of {@link OperationResponse.OperationDictList }
     * 
     */
    public OperationResponse.OperationDictList createOperationResponseOperationDictList() {
        return new OperationResponse.OperationDictList();
    }

    /**
     * Create an instance of {@link SpecialClinicResponse.SpecialClinicInfoList }
     * 
     */
    public SpecialClinicResponse.SpecialClinicInfoList createSpecialClinicResponseSpecialClinicInfoList() {
        return new SpecialClinicResponse.SpecialClinicInfoList();
    }

    /**
     * Create an instance of {@link ClinicItemResponse.ClinicItemDictList }
     * 
     */
    public ClinicItemResponse.ClinicItemDictList createClinicItemResponseClinicItemDictList() {
        return new ClinicItemResponse.ClinicItemDictList();
    }

    /**
     * Create an instance of {@link PdfReportResponse.ReportList }
     * 
     */
    public PdfReportResponse.ReportList createPdfReportResponseReportList() {
        return new PdfReportResponse.ReportList();
    }

    /**
     * Create an instance of {@link DiagnosisDictResponse.DiagnosisList }
     * 
     */
    public DiagnosisDictResponse.DiagnosisList createDiagnosisDictResponseDiagnosisList() {
        return new DiagnosisDictResponse.DiagnosisList();
    }

    /**
     * Create an instance of {@link QueryCategoryDetailDefinitionResponse.CategoryDetailDefinitionList }
     * 
     */
    public QueryCategoryDetailDefinitionResponse.CategoryDetailDefinitionList createQueryCategoryDetailDefinitionResponseCategoryDetailDefinitionList() {
        return new QueryCategoryDetailDefinitionResponse.CategoryDetailDefinitionList();
    }

    /**
     * Create an instance of {@link UsageDictResponse.UsageDictList }
     * 
     */
    public UsageDictResponse.UsageDictList createUsageDictResponseUsageDictList() {
        return new UsageDictResponse.UsageDictList();
    }

    /**
     * Create an instance of {@link OutpDoctorInfoResponse.DoctorInfoList }
     * 
     */
    public OutpDoctorInfoResponse.DoctorInfoList createOutpDoctorInfoResponseDoctorInfoList() {
        return new OutpDoctorInfoResponse.DoctorInfoList();
    }

    /**
     * Create an instance of {@link FrequencyResponse.FrequencyDictList }
     * 
     */
    public FrequencyResponse.FrequencyDictList createFrequencyResponseFrequencyDictList() {
        return new FrequencyResponse.FrequencyDictList();
    }

    /**
     * Create an instance of {@link CodeTableResponse.StandardList }
     * 
     */
    public CodeTableResponse.StandardList createCodeTableResponseStandardList() {
        return new CodeTableResponse.StandardList();
    }

    /**
     * Create an instance of {@link OrganizationResponse.OrganizationList }
     * 
     */
    public OrganizationResponse.OrganizationList createOrganizationResponseOrganizationList() {
        return new OrganizationResponse.OrganizationList();
    }

    /**
     * Create an instance of {@link BcsUumUserResponse.UserInfoList }
     * 
     */
    public BcsUumUserResponse.UserInfoList createBcsUumUserResponseUserInfoList() {
        return new BcsUumUserResponse.UserInfoList();
    }

    /**
     * Create an instance of {@link UserPrivilege.RoleList }
     * 
     */
    public UserPrivilege.RoleList createUserPrivilegeRoleList() {
        return new UserPrivilege.RoleList();
    }

    /**
     * Create an instance of {@link UserPrivilege.FuncList }
     * 
     */
    public UserPrivilege.FuncList createUserPrivilegeFuncList() {
        return new UserPrivilege.FuncList();
    }

    /**
     * Create an instance of {@link UserPrivilege.AuthList }
     * 
     */
    public UserPrivilege.AuthList createUserPrivilegeAuthList() {
        return new UserPrivilege.AuthList();
    }

    /**
     * Create an instance of {@link SsoUserInfoResponse.MediTeamList }
     * 
     */
    public SsoUserInfoResponse.MediTeamList createSsoUserInfoResponseMediTeamList() {
        return new SsoUserInfoResponse.MediTeamList();
    }

    /**
     * Create an instance of {@link CodeTable.ItemList }
     * 
     */
    public CodeTable.ItemList createCodeTableItemList() {
        return new CodeTable.ItemList();
    }

    /**
     * Create an instance of {@link DiagnosticsQueryPatientInfoVO.DiagList }
     * 
     */
    public DiagnosticsQueryPatientInfoVO.DiagList createDiagnosticsQueryPatientInfoVODiagList() {
        return new DiagnosticsQueryPatientInfoVO.DiagList();
    }

    /**
     * Create an instance of {@link OutpOrderInfo.OutpOrderItemList }
     * 
     */
    public OutpOrderInfo.OutpOrderItemList createOutpOrderInfoOutpOrderItemList() {
        return new OutpOrderInfo.OutpOrderItemList();
    }

    /**
     * Create an instance of {@link QueryDialysisScheduling.Schedulings }
     * 
     */
    public QueryDialysisScheduling.Schedulings createQueryDialysisSchedulingSchedulings() {
        return new QueryDialysisScheduling.Schedulings();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "AccountInfo")
    public JAXBElement<Object> createAccountInfo(Object value) {
        return new JAXBElement<Object>(_AccountInfo_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientAgeEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "AgeInfo")
    public JAXBElement<PatientAgeEntity> createAgeInfo(PatientAgeEntity value) {
        return new JAXBElement<PatientAgeEntity>(_AgeInfo_QNAME, PatientAgeEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BdAreaQueryVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Area")
    public JAXBElement<BdAreaQueryVO> createArea(BdAreaQueryVO value) {
        return new JAXBElement<BdAreaQueryVO>(_Area_QNAME, BdAreaQueryVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BedDictVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "BedInfo")
    public JAXBElement<BedDictVO> createBedInfo(BedDictVO value) {
        return new JAXBElement<BedDictVO>(_BedInfo_QNAME, BedDictVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Body")
    public JAXBElement<Object> createBody(Object value) {
        return new JAXBElement<Object>(_Body_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryDetailDefinition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "CategoryDetailDefinition")
    public JAXBElement<CategoryDetailDefinition> createCategoryDetailDefinition(CategoryDetailDefinition value) {
        return new JAXBElement<CategoryDetailDefinition>(_CategoryDetailDefinition_QNAME, CategoryDetailDefinition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClinicItemEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "ClinicItem")
    public JAXBElement<ClinicItemEntity> createClinicItem(ClinicItemEntity value) {
        return new JAXBElement<ClinicItemEntity>(_ClinicItem_QNAME, ClinicItemEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BdClinicpriceQueryVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "ClinicPrice")
    public JAXBElement<BdClinicpriceQueryVO> createClinicPrice(BdClinicpriceQueryVO value) {
        return new JAXBElement<BdClinicpriceQueryVO>(_ClinicPrice_QNAME, BdClinicpriceQueryVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultingRoomEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "ConsultingRoom")
    public JAXBElement<ConsultingRoomEntity> createConsultingRoom(ConsultingRoomEntity value) {
        return new JAXBElement<ConsultingRoomEntity>(_ConsultingRoom_QNAME, ConsultingRoomEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiagnosticsQueryEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "DiagInfo")
    public JAXBElement<DiagnosticsQueryEntity> createDiagInfo(DiagnosticsQueryEntity value) {
        return new JAXBElement<DiagnosticsQueryEntity>(_DiagInfo_QNAME, DiagnosticsQueryEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiagnosisDict }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Diagnosis")
    public JAXBElement<DiagnosisDict> createDiagnosis(DiagnosisDict value) {
        return new JAXBElement<DiagnosisDict>(_Diagnosis_QNAME, DiagnosisDict.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DialysisPatientInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "DialysisScheduling")
    public JAXBElement<DialysisPatientInfo> createDialysisScheduling(DialysisPatientInfo value) {
        return new JAXBElement<DialysisPatientInfo>(_DialysisScheduling_QNAME, DialysisPatientInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryDialysisScheduling }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "DialysisSchedulingList")
    public JAXBElement<QueryDialysisScheduling> createDialysisSchedulingList(QueryDialysisScheduling value) {
        return new JAXBElement<QueryDialysisScheduling>(_DialysisSchedulingList_QNAME, QueryDialysisScheduling.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "DoctorInfo")
    public JAXBElement<Object> createDoctorInfo(Object value) {
        return new JAXBElement<Object>(_DoctorInfo_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FrequencyEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "FrequencyDict")
    public JAXBElement<FrequencyEntity> createFrequencyDict(FrequencyEntity value) {
        return new JAXBElement<FrequencyEntity>(_FrequencyDict_QNAME, FrequencyEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Header")
    public JAXBElement<SoapHeader> createHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_Header_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeTableItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Item")
    public JAXBElement<CodeTableItem> createItem(CodeTableItem value) {
        return new JAXBElement<CodeTableItem>(_Item_QNAME, CodeTableItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Material")
    public JAXBElement<Object> createMaterial(Object value) {
        return new JAXBElement<Object>(_Material_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BdMedInsQueryVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "MedIns")
    public JAXBElement<BdMedInsQueryVO> createMedIns(BdMedInsQueryVO value) {
        return new JAXBElement<BdMedInsQueryVO>(_MedIns_QNAME, BdMedInsQueryVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseMsgLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "MsgLog")
    public JAXBElement<BaseMsgLog> createMsgLog(BaseMsgLog value) {
        return new JAXBElement<BaseMsgLog>(_MsgLog_QNAME, BaseMsgLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "OperationDict")
    public JAXBElement<OperationEntity> createOperationDict(OperationEntity value) {
        return new JAXBElement<OperationEntity>(_OperationDict_QNAME, OperationEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Organization")
    public JAXBElement<Object> createOrganization(Object value) {
        return new JAXBElement<Object>(_Organization_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutpOrderInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "OutpOrder")
    public JAXBElement<OutpOrderInfo> createOutpOrder(OutpOrderInfo value) {
        return new JAXBElement<OutpOrderInfo>(_OutpOrder_QNAME, OutpOrderInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutpOrderItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "OutpOrderItem")
    public JAXBElement<OutpOrderItem> createOutpOrderItem(OutpOrderItem value) {
        return new JAXBElement<OutpOrderItem>(_OutpOrderItem_QNAME, OutpOrderItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "PatientInfo")
    public JAXBElement<PatientInfo> createPatientInfo(PatientInfo value) {
        return new JAXBElement<PatientInfo>(_PatientInfo_QNAME, PatientInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EleheCardGetqrInfoEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "PatientQrInfo")
    public JAXBElement<EleheCardGetqrInfoEntity> createPatientQrInfo(EleheCardGetqrInfoEntity value) {
        return new JAXBElement<EleheCardGetqrInfoEntity>(_PatientQrInfo_QNAME, EleheCardGetqrInfoEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiagnosticsQueryPatientInfoVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "PatientVisit")
    public JAXBElement<DiagnosticsQueryPatientInfoVO> createPatientVisit(DiagnosticsQueryPatientInfoVO value) {
        return new JAXBElement<DiagnosticsQueryPatientInfoVO>(_PatientVisit_QNAME, DiagnosticsQueryPatientInfoVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhamLocationPO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "PhamInfo")
    public JAXBElement<PhamLocationPO> createPhamInfo(PhamLocationPO value) {
        return new JAXBElement<PhamLocationPO>(_PhamInfo_QNAME, PhamLocationPO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhamItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "PhamItem")
    public JAXBElement<PhamItem> createPhamItem(PhamItem value) {
        return new JAXBElement<PhamItem>(_PhamItem_QNAME, PhamItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrescriptionPO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Prescription")
    public JAXBElement<PrescriptionPO> createPrescription(PrescriptionPO value) {
        return new JAXBElement<PrescriptionPO>(_Prescription_QNAME, PrescriptionPO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "RechargeInfo")
    public JAXBElement<Object> createRechargeInfo(Object value) {
        return new JAXBElement<Object>(_RechargeInfo_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PdfReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "ReportInfo")
    public JAXBElement<PdfReport> createReportInfo(PdfReport value) {
        return new JAXBElement<PdfReport>(_ReportInfo_QNAME, PdfReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Request")
    public JAXBElement<SoapRequest> createRequest(SoapRequest value) {
        return new JAXBElement<SoapRequest>(_Request_QNAME, SoapRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "ReserveInfo")
    public JAXBElement<ReserveInfo> createReserveInfo(ReserveInfo value) {
        return new JAXBElement<ReserveInfo>(_ReserveInfo_QNAME, ReserveInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Response")
    public JAXBElement<SoapResponse> createResponse(SoapResponse value) {
        return new JAXBElement<SoapResponse>(_Response_QNAME, SoapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EleheCardGetstAticsCodeEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "ReturnInfo")
    public JAXBElement<EleheCardGetstAticsCodeEntity> createReturnInfo(EleheCardGetstAticsCodeEntity value) {
        return new JAXBElement<EleheCardGetstAticsCodeEntity>(_ReturnInfo_QNAME, EleheCardGetstAticsCodeEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryScheduling }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Schedulings")
    public JAXBElement<QueryScheduling> createSchedulings(QueryScheduling value) {
        return new JAXBElement<QueryScheduling>(_Schedulings_QNAME, QueryScheduling.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpecialClinic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "SpecialClinic")
    public JAXBElement<SpecialClinic> createSpecialClinic(SpecialClinic value) {
        return new JAXBElement<SpecialClinic>(_SpecialClinic_QNAME, SpecialClinic.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "Standard")
    public JAXBElement<CodeTable> createStandard(CodeTable value) {
        return new JAXBElement<CodeTable>(_Standard_QNAME, CodeTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Message }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "message")
    public JAXBElement<Message> createMessage(Message value) {
        return new JAXBElement<Message>(_Message_QNAME, Message.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wegohis.com", name = "messageResponse")
    public JAXBElement<MessageResponse> createMessageResponse(MessageResponse value) {
        return new JAXBElement<MessageResponse>(_MessageResponse_QNAME, MessageResponse.class, null, value);
    }

}
