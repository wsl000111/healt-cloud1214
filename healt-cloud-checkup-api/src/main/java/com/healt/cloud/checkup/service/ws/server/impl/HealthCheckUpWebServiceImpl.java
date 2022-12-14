package com.healt.cloud.checkup.service.ws.server.impl;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.service.ws.his.costChargeState.CostChargeHeader;
import com.healt.cloud.checkup.service.ws.his.costChargeState.CostChargeStateReqBody;
import com.healt.cloud.checkup.service.ws.his.costChargeState.CostChargeStateRequest;
import com.healt.cloud.checkup.service.ws.his.costChargeState.Item;
import com.healt.cloud.checkup.service.ws.his.costChargeState.response.CostChargeStateResBody;
import com.healt.cloud.checkup.service.ws.his.costChargeState.response.CostChargeStateResponse;
import com.healt.cloud.checkup.service.ws.his.costChargeState.response.Result;
import com.healt.cloud.checkup.service.ws.his.message.SoapRequest;
import com.healt.cloud.checkup.service.ws.his.message.SoapResponse;
import com.healt.cloud.checkup.service.ws.his.outpOrders.OutpOrdersReq;
import com.healt.cloud.checkup.service.ws.his.outpOrders.OutpOrdersRes;
import com.healt.cloud.checkup.service.ws.server.IHealthCheckUpWebService;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.DateUtils;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.common.utils.SoapUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * WebService涉及到的有这些 "四解三类 ", 即四个注解，三个类
 * 
 * @WebMethod
 * @WebService
 * @WebResult
 * @WebParam SpringBus Endpoint EndpointImpl
 *
 *           一般我们都会写一个接口，然后再写一个实现接口的实现类，但是这不是强制性的
 * @WebService 注解表明是一个webservice服务。 name：对外发布的服务名,
 *             对应于<wsdl:portType name="ServerServiceDemo"></wsdl:portType>
 *             targetNamespace：命名空间,一般是接口的包名倒序, 实现类与接口类的这个配置一定要一致这种错误 Exception
 *             in thread "main" org.apache.cxf.common.i18n.UncheckedException:
 *             No operation was found with the name xxxx
 *             对应于targetNamespace="http://server.webservice.example.com"
 *             endpointInterface：服务接口全路径（如果是没有接口，直接写实现类的，该属性不用配置）,
 *             指定做SEI（Service EndPoint Interface）服务端点接口
 *             serviceName：对应于<wsdl:service name=
 *             "ServerServiceDemoImplService"></wsdl:service>
 *             portName：对应于<wsdl:port binding=
 *             "tns:ServerServiceDemoImplServiceSoapBinding" name=
 *             "ServerServiceDemoPort"></wsdl:port>
 *
 * @WebMethod 表示暴露的服务方法, 这里有接口ServerServiceDemo存在，在接口方法已加上@WebMethod,
 *            所以在实现类中不用再加上，否则就要加上 operationName: 接口的方法名 action: 没发现又什么用处
 *            exclude: 默认是false, 用于阻止将某一继承方法公开为web服务
 *
 * @WebResult 表示方法的返回值 name：返回值的名称 partName： targetNamespace: header: 默认是false,
 *            是否将参数放到头信息中，用于保护参数，默认在body中
 *
 * @WebParam name：接口的参数 partName： targetNamespace: header: 默认是false,
 *           是否将参数放到头信息中，用于保护参数，默认在body中 model：WebParam.Mode.IN/OUT/INOUT
 */
@WebService(
		serviceName = "HealthCheckUpWebService", //与接口中指定的name一致
		targetNamespace = "http://server.ws.service.checkup.cloud.healt.com", // 与接口中的命名空间一致
		endpointInterface = "com.healt.cloud.checkup.service.ws.server.IHealthCheckUpWebService" //接口地址
)
@Component
@BindingType(SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class HealthCheckUpWebServiceImpl implements IHealthCheckUpWebService {

	@Resource
	HcPersonAppregItemsService hcPersonAppregItemsService;

	@Resource
	private CostDetailBillingService costDetailBillingService;

	@Resource
	private CostChargeStateMasterService costChargeStateMasterService;

	@Resource
	private CostChargeStateDetailService costChargeStateDetailService;

	@Resource
	private WebserviceLogService webserviceLogService;

	//费用状态回传
	//状态回传时候更新COST_DETAIL_BILLING表的收据号REKID字段，状态回传还需 更新  hc_person_appreg_items 的BILL_INDICATOR（FeeStatus 状态收更1 退更0）
//	@Override
//	public CostChargeStateResponse message(CostChargeStateRequest costChargeStateRequest) {
//		WebserviceLog log = new WebserviceLog();
//		log.setUuid(CommonUtils.getUUID());
//		log.setInsertDate(new Date());
//		log.setDataStr(costChargeStateRequest.toString());
//		log.setDataType("入参");
//		log.setMethod("收费状态回传");
//		webserviceLogService.save(log);
//
//		String code = "CA";//CA 成功 CE 失败
//
//		String desc = "成功";
//
//		// 修改项目收费状态
//		costChargeStateRequest.getBody().getChargeState().getItemListVo().getItem();
//		// 体检号
//		String examNo = costChargeStateRequest.getBody().getChargeState().getExamNo();
//		if(StringUtils.isEmpty(examNo)){
//			code = "CE";
//			desc = "体检号不能为空";
//		}
//		//对体检号进行拆分
//		String[] examNoAry = examNo.split("_");
//		String personId = examNoAry[0];
//		//String visitId = examNoAry[1];
//		// 患者ID
//		String patientId = costChargeStateRequest.getBody().getChargeState().getPatientId();
//		// 就诊次数
//		String visitId = costChargeStateRequest.getBody().getChargeState().getVisitId();
//		if(StringUtils.isEmpty(visitId)){
//			code = "CE";
//			desc = "体检次数不能为空";
//		}
//		// 收费状态
//		String feeStatus = costChargeStateRequest.getBody().getChargeState().getFeeStatus();
//		if(StringUtils.isEmpty(feeStatus)){
//			code = "CE";
//			desc = "收费状态不能为空";
//		}
//		//RekId HIS 收费结算号
//		String rekid = costChargeStateRequest.getBody().getChargeState().getRekId();
//		//修改计费标记 hc_person_appreg_items 里的BILL_INDICATOR，完成1，退和未收费0， 主键HOSPITAL_ID, PERSON_ID, PERSON_VISIT_ID, ITEM_PACK_CODE, ITEM_NO
//		LambdaUpdateWrapper<HcPersonAppregItems> hcPersonAppregItemsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//		List<Item> items = costChargeStateRequest.getBody().getChargeState().getItemListVo().getItem();
//		for(Item item : items){
//			// 根据orderId查询响应的收费项目
//			String orderId = item.getOrderId();
//			LambdaQueryWrapper<CostDetailBilling> costDetailBillingQueryWrapper = new LambdaQueryWrapper<>();
//			costDetailBillingQueryWrapper.eq(CostDetailBilling::getOrderId, orderId);
////			costDetailBillingQueryWrapper.eq(CostDetailBilling::getPatientId, patientId);
////			costDetailBillingQueryWrapper.eq(CostDetailBilling::getPersonVisitId, visitId);
////			costDetailBillingQueryWrapper.eq(CostDetailBilling::getFeeItemId, itemCode);
//			List<CostDetailBilling> costDetailBillings = costDetailBillingService.list(costDetailBillingQueryWrapper);
//			if(costDetailBillings.size()<1){
//				code = "CE";
//				desc = "未找到对应的组合项目";
//			}else{
//				//更新COST_DETAIL_BILLING表的收据号REKID字段
//				LambdaUpdateWrapper<CostDetailBilling> costDetailBillingLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//				costDetailBillingLambdaUpdateWrapper.set(CostDetailBilling::getRekid, rekid);
//				costDetailBillingLambdaUpdateWrapper.eq(CostDetailBilling::getOrderId, orderId);
//				costDetailBillingService.update(costDetailBillingLambdaUpdateWrapper);
//				String itemPackCode = costDetailBillings.get(0).getItemPackCode();
//				switch (feeStatus){
//					case "0":
//						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getBillIndicator, "0");
//						break;
//					case "1":
//						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getBillIndicator, "1");
//						break;
//					case "2":
//						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getBillIndicator, "0");
//						break;
//					case "3":
//						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getBillIndicator, "0");
//						break;
//				}
//				hcPersonAppregItemsLambdaUpdateWrapper.eq(HcPersonAppregItems::getPersonId, personId);
//				hcPersonAppregItemsLambdaUpdateWrapper.eq(HcPersonAppregItems::getPersonVisitId, visitId);
//				hcPersonAppregItemsLambdaUpdateWrapper.eq(HcPersonAppregItems::getItemPackCode, itemPackCode);
//				hcPersonAppregItemsLambdaUpdateWrapper.eq(HcPersonAppregItems::getUploadFlag, "1");
//				if(!hcPersonAppregItemsService.update(hcPersonAppregItemsLambdaUpdateWrapper)){
//					code = "CE";
//					desc = "未找到对应的诊疗项目";
//				}
//			}
//		}
//		//收费记录状态回传增加了两个表HEALTHCHECKUP.COST_CHARGE_STATE_MASTER;与HEALTHCHECKUP.COST_CHARGE_STATE_DETAIL;
//		CostChargeStateMaster costChargeStateMaster = new CostChargeStateMaster();
//		costChargeStateMaster.setHospitalId("0001");
//		costChargeStateMaster.setUnitId(costChargeStateRequest.getBody().getChargeState().getExamCompanyNo());
//		//costChargeStateMaster.setUnitVisitId();
//		costChargeStateMaster.setPersonId(personId);
//		costChargeStateMaster.setPersonVisitId(Integer.parseInt(costChargeStateRequest.getBody().getChargeState().getVisitId()));
//		costChargeStateMaster.setExamtype(costChargeStateRequest.getBody().getChargeState().getExamType());
//		costChargeStateMaster.setExamno(costChargeStateRequest.getBody().getChargeState().getExamNo());
//		costChargeStateMaster.setExamcompanyno(costChargeStateRequest.getBody().getChargeState().getExamCompanyNo());
//		costChargeStateMaster.setExamcompanyname(costChargeStateRequest.getBody().getChargeState().getExamCompanyName());
//		costChargeStateMaster.setPatientid(costChargeStateRequest.getBody().getChargeState().getPatientId());
//		costChargeStateMaster.setVisitid(costChargeStateRequest.getBody().getChargeState().getVisitId());
//		costChargeStateMaster.setFeestatus(costChargeStateRequest.getBody().getChargeState().getFeeStatus());
//		costChargeStateMaster.setOperator(costChargeStateRequest.getBody().getChargeState().getOperator());
//		costChargeStateMaster.setOperatetime(DateUtils.parseString(costChargeStateRequest.getBody().getChargeState().getOperateTime(), "yyyyMMddHHmmss"));
//		costChargeStateMaster.setRekid(costChargeStateRequest.getBody().getChargeState().getRekId());
//		costChargeStateMaster.setInvoiceid(costChargeStateRequest.getBody().getChargeState().getInvoiceId());
//		costChargeStateMaster.setApplydoctorcode(costChargeStateRequest.getBody().getChargeState().getApplyDoctorCode());
//		costChargeStateMaster.setApplydoctorname(costChargeStateRequest.getBody().getChargeState().getApplyDoctorName());
//		costChargeStateMaster.setExecorgcode(costChargeStateRequest.getBody().getChargeState().getExecOrgCode());
//		costChargeStateMaster.setExecorgname(costChargeStateRequest.getBody().getChargeState().getExecOrgName());
//		costChargeStateMaster.setExecflag(costChargeStateRequest.getBody().getChargeState().getExecFlag());
//		costChargeStateMaster.setAreacode(costChargeStateRequest.getBody().getChargeState().getAreaCode());
//		costChargeStateMasterService.save(costChargeStateMaster);
//		for(Item item : items){
//			CostChargeStateDetail costChargeStateDetail = new CostChargeStateDetail();
//			costChargeStateDetail.setHospitalId("0001");
//			costChargeStateDetail.setUnitId("");
//			//costChargeStateDetail.setUnitVisitId("");
//			costChargeStateDetail.setPersonId(personId);
//			costChargeStateDetail.setPersonVisitId(Integer.parseInt(visitId));
//			costChargeStateDetail.setExamtype(costChargeStateMaster.getExamtype());
//			costChargeStateDetail.setExamno(costChargeStateMaster.getExamno());
//			costChargeStateDetail.setExamcompanyname(costChargeStateMaster.getExamcompanyname());
//			costChargeStateDetail.setExamcompanyno(costChargeStateMaster.getExamcompanyno());
//			costChargeStateDetail.setPatientid(costChargeStateMaster.getPatientid());
//			costChargeStateDetail.setVisitid(costChargeStateMaster.getVisitid());
//			costChargeStateDetail.setFeestatus(costChargeStateMaster.getFeestatus());
//			costChargeStateDetail.setRekid(costChargeStateMaster.getRekid());
//			costChargeStateDetail.setItemcode(item.getClinicItemId());
//			costChargeStateDetail.setItemname(item.getClinicItemName());
//			costChargeStateDetail.setItemunit(item.getUnit());
//			costChargeStateDetail.setUnitprice(item.getUnitPrice());
//			costChargeStateDetail.setNum(new BigDecimal(item.getNum()));
//			costChargeStateDetail.setItemprice(new BigDecimal(item.getUnit()).multiply(costChargeStateDetail.getNum()));
//			costChargeStateDetailService.save(costChargeStateDetail);
//		}
//
//		CostChargeStateResponse costChargeStateResponse = new CostChargeStateResponse();
//		String sender = costChargeStateRequest.getHeader().getSender();
//		String receivcer = costChargeStateRequest.getHeader().getReceiver();
//		costChargeStateRequest.getHeader().setReceiver(sender);
//		costChargeStateRequest.getHeader().setSender(receivcer);
//		costChargeStateRequest.getHeader().setServiceCode("ACK_COST_CHARGE_STATE");
//		costChargeStateResponse.setCostChargeHeader(costChargeStateRequest.getHeader());
//		CostChargeStateResBody costChargeStateResBody = new CostChargeStateResBody();
//		Result result = new Result();
//		result.setCode(code);
//		result.setDesc(desc);
//		costChargeStateResBody.setResult(result);
//		costChargeStateResponse.setCostChargeStateResBody(costChargeStateResBody);
//		return costChargeStateResponse;
//	}

	@Override
	public String costChargeState(String costChargeStateRequestStr) {
		//解析xml字符串
		CostChargeStateRequest costChargeStateRequest = SoapUtil.xml2Bean(costChargeStateRequestStr, CostChargeStateRequest.class);

		String code = "CA";//CA 成功 CE 失败

		String desc = "成功";

		// 修改项目收费状态
		costChargeStateRequest.getBody().getChargeState().getItemListVo().getItem();
		// 体检号
		String examNo = costChargeStateRequest.getBody().getChargeState().getExamNo();
		if(StringUtils.isEmpty(examNo)){
			code = "CE";
			desc = "体检号不能为空";
		}
		//对体检号进行拆分
		String[] examNoAry = examNo.split("_");
		String personId = examNoAry[0];
		//String visitId = examNoAry[1];
		// 患者ID
		String patientId = costChargeStateRequest.getBody().getChargeState().getPatientId();
		// 就诊次数
		String visitId = costChargeStateRequest.getBody().getChargeState().getVisitId();
		if(StringUtils.isEmpty(visitId)){
			code = "CE";
			desc = "体检次数不能为空";
		}
		// 收费状态
		String feeStatus = costChargeStateRequest.getBody().getChargeState().getFeeStatus();
		if(StringUtils.isEmpty(feeStatus)){
			code = "CE";
			desc = "收费状态不能为空";
		}

		WebserviceLog log = new WebserviceLog();
		log.setUuid(costChargeStateRequest.getHeader().getMsgId());
		log.setInsertDate(new Date());
		log.setDataStr(costChargeStateRequestStr);
		log.setDataType("入参");
		log.setMethod("收费状态回传");
		webserviceLogService.save(log);

		//RekId HIS 收费结算号
		String rekid = costChargeStateRequest.getBody().getChargeState().getRekId();
		//修改计费标记 hc_person_appreg_items 里的BILL_INDICATOR，完成1，退和未收费0， 主键HOSPITAL_ID, PERSON_ID, PERSON_VISIT_ID, ITEM_PACK_CODE, ITEM_NO
		LambdaUpdateWrapper<HcPersonAppregItems> hcPersonAppregItemsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
		List<Item> items = costChargeStateRequest.getBody().getChargeState().getItemListVo().getItem();
		for(Item item : items){
			// 根据orderId查询响应的收费项目
			String orderId = item.getOrderId();
			LambdaQueryWrapper<CostDetailBilling> costDetailBillingQueryWrapper = new LambdaQueryWrapper<>();
			costDetailBillingQueryWrapper.eq(CostDetailBilling::getOrderId, orderId);
//			costDetailBillingQueryWrapper.eq(CostDetailBilling::getPatientId, patientId);
//			costDetailBillingQueryWrapper.eq(CostDetailBilling::getPersonVisitId, visitId);
//			costDetailBillingQueryWrapper.eq(CostDetailBilling::getFeeItemId, itemCode);
			List<CostDetailBilling> costDetailBillings = costDetailBillingService.list(costDetailBillingQueryWrapper);
			if(costDetailBillings.size()<1){
				code = "CE";
				desc = "未找到对应的组合项目";
			}else{

				String itemPackCode = costDetailBillings.get(0).getItemPackCode();
				LambdaUpdateWrapper<CostDetailBilling> costDetailBillingLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
				switch (feeStatus){//0=未收、1=已收、2=已退、3=红冲
					case "0":
						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getBillIndicator, "0");
						break;
					case "1":
						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getBillIndicator, "1");
						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getUploadFlag, "1");
						//更新COST_DETAIL_BILLING表的收据号REKID字段
						costDetailBillingLambdaUpdateWrapper.set(CostDetailBilling::getRekid, rekid);
						costDetailBillingLambdaUpdateWrapper.eq(CostDetailBilling::getOrderId, orderId);
						costDetailBillingService.update(costDetailBillingLambdaUpdateWrapper);
						break;
					case "2":
						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getBillIndicator, "0");
						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getUploadFlag, null);
						//更新COST_DETAIL_BILLING的RETURN_REKID 退费收据号为 退费状态回传 的 REKID
						costDetailBillingLambdaUpdateWrapper.set(CostDetailBilling::getReturnRekid, rekid);
						costDetailBillingLambdaUpdateWrapper.eq(CostDetailBilling::getOrderId, orderId);
						costDetailBillingService.update(costDetailBillingLambdaUpdateWrapper);
						break;
					case "3":
						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getBillIndicator, "0");
						hcPersonAppregItemsLambdaUpdateWrapper.set(HcPersonAppregItems::getUploadFlag, null);
						costDetailBillingLambdaUpdateWrapper.set(CostDetailBilling::getReturnRekid, rekid);
						costDetailBillingLambdaUpdateWrapper.eq(CostDetailBilling::getOrderId, orderId);
						costDetailBillingService.update(costDetailBillingLambdaUpdateWrapper);
						break;
				}
				hcPersonAppregItemsLambdaUpdateWrapper.eq(HcPersonAppregItems::getPersonId, personId);
				hcPersonAppregItemsLambdaUpdateWrapper.eq(HcPersonAppregItems::getPersonVisitId, visitId);
				hcPersonAppregItemsLambdaUpdateWrapper.eq(HcPersonAppregItems::getItemPackCode, itemPackCode);

				if(!hcPersonAppregItemsService.update(hcPersonAppregItemsLambdaUpdateWrapper)){
					code = "CE";
					desc = "未找到对应的诊疗项目";
				}
			}
		}
		//收费记录状态回传增加了两个表HEALTHCHECKUP.COST_CHARGE_STATE_MASTER;与HEALTHCHECKUP.COST_CHARGE_STATE_DETAIL;
		CostChargeStateMaster costChargeStateMaster = new CostChargeStateMaster();
		costChargeStateMaster.setHospitalId("0001");
		costChargeStateMaster.setUnitId(costChargeStateRequest.getBody().getChargeState().getExamCompanyNo());
		//costChargeStateMaster.setUnitVisitId();
		costChargeStateMaster.setPersonId(personId);
		costChargeStateMaster.setPersonVisitId(Integer.parseInt(costChargeStateRequest.getBody().getChargeState().getVisitId()));
		costChargeStateMaster.setExamtype(costChargeStateRequest.getBody().getChargeState().getExamType());
		costChargeStateMaster.setExamno(costChargeStateRequest.getBody().getChargeState().getExamNo());
		costChargeStateMaster.setExamcompanyno(costChargeStateRequest.getBody().getChargeState().getExamCompanyNo());
		costChargeStateMaster.setExamcompanyname(costChargeStateRequest.getBody().getChargeState().getExamCompanyName());
		costChargeStateMaster.setPatientid(costChargeStateRequest.getBody().getChargeState().getPatientId());
		costChargeStateMaster.setVisitid(costChargeStateRequest.getBody().getChargeState().getVisitId());
		costChargeStateMaster.setFeestatus(costChargeStateRequest.getBody().getChargeState().getFeeStatus());
		costChargeStateMaster.setOperator(costChargeStateRequest.getBody().getChargeState().getOperator());
		costChargeStateMaster.setOperatetime(DateUtils.parseString(costChargeStateRequest.getBody().getChargeState().getOperateTime(), "yyyyMMddHHmmss"));
		costChargeStateMaster.setRekid(costChargeStateRequest.getBody().getChargeState().getRekId());
		costChargeStateMaster.setInvoiceid(costChargeStateRequest.getBody().getChargeState().getInvoiceId());
		costChargeStateMaster.setApplydoctorcode(costChargeStateRequest.getBody().getChargeState().getApplyDoctorCode());
		costChargeStateMaster.setApplydoctorname(costChargeStateRequest.getBody().getChargeState().getApplyDoctorName());
		costChargeStateMaster.setExecorgcode(costChargeStateRequest.getBody().getChargeState().getExecOrgCode());
		costChargeStateMaster.setExecorgname(costChargeStateRequest.getBody().getChargeState().getExecOrgName());
		costChargeStateMaster.setExecflag(costChargeStateRequest.getBody().getChargeState().getExecFlag());
		costChargeStateMaster.setAreacode(costChargeStateRequest.getBody().getChargeState().getAreaCode());
		try {
			costChargeStateMasterService.save(costChargeStateMaster);
		}catch (Exception e){
			code = "CE";
			if(e.getMessage().contains("ORA-00001")){
				desc = "违反唯一约束条件";
			}
		}
		for(Item item : items){
			CostChargeStateDetail costChargeStateDetail = new CostChargeStateDetail();
			costChargeStateDetail.setHospitalId("0001");
			costChargeStateDetail.setUnitId("");
			//costChargeStateDetail.setUnitVisitId("");
			costChargeStateDetail.setPersonId(personId);
			costChargeStateDetail.setPersonVisitId(Integer.parseInt(visitId));
			costChargeStateDetail.setExamtype(costChargeStateMaster.getExamtype());
			costChargeStateDetail.setExamno(costChargeStateMaster.getExamno());
			costChargeStateDetail.setExamcompanyname(costChargeStateMaster.getExamcompanyname());
			costChargeStateDetail.setExamcompanyno(costChargeStateMaster.getExamcompanyno());
			costChargeStateDetail.setPatientid(costChargeStateMaster.getPatientid());
			costChargeStateDetail.setVisitid(costChargeStateMaster.getVisitid());
			costChargeStateDetail.setFeestatus(costChargeStateMaster.getFeestatus());
			costChargeStateDetail.setRekid(costChargeStateMaster.getRekid());
			costChargeStateDetail.setItemcode(item.getClinicItemId());
			costChargeStateDetail.setItemname(item.getClinicItemName());
			costChargeStateDetail.setItemunit(item.getUnit());
			costChargeStateDetail.setUnitprice(item.getUnitPrice());
			costChargeStateDetail.setNum(new BigDecimal(item.getNum()));
			costChargeStateDetail.setItemprice(new BigDecimal(item.getUnit()).multiply(costChargeStateDetail.getNum()));
			try {
				costChargeStateDetailService.save(costChargeStateDetail);
			}catch (Exception e){
				code = "CE";
				if(e.getMessage().contains("ORA-00001")){
					desc = "违反唯一约束条件";
				}
			}
		}

		StringBuilder costChargeStateResponse = new StringBuilder();
		costChargeStateResponse.append("<Response>")
				.append("<Header>")
				.append("<Sender>").append(PropertiesUtils.SENDER).append("</Sender>")
				.append("<Receiver>").append(costChargeStateRequest.getHeader().getSender()).append("</Receiver>")
				.append("<SendDate>").append(DateUtils.getDateYYYYMMDDHHMMSS()).append("</SendDate>")
				.append("<ServiceCode>ACK_COST_CHARGE_STATE</ServiceCode>")
				.append("<MsgId>").append(costChargeStateRequest.getHeader().getMsgId()).append("</MsgId>")
				.append("<AuthCode>").append(PropertiesUtils.AUTHCODE).append("</AuthCode>")
				.append("<Version>1.0</Version>")
				.append("</Header>")
				.append("<Body>")
				.append("<Result>")
				.append("<Code>").append(code).append("</Code>")
				.append("<Desc>").append(desc).append("</Desc>")
				.append("</Result>")
				.append("</Body>")
				.append("</Response>");
		WebserviceLog logRes = new WebserviceLog();
		logRes.setUuid(costChargeStateRequest.getHeader().getMsgId());
		logRes.setInsertDate(new Date());
		logRes.setDataStr(costChargeStateResponse.toString());
		logRes.setDataType("返参");
		logRes.setMethod("收费状态回传");
		webserviceLogService.save(logRes);
		return costChargeStateResponse.toString();
	}

//	@Override
//	public OutpOrdersRes getOutpOrders(OutpOrdersReq outpOrdersReq) {
//		OutpOrdersRes outpOrdersRes = new OutpOrdersRes();
//		outpOrdersRes.setAmount("sdfsdf");
//		return outpOrdersRes;
//	}
}
