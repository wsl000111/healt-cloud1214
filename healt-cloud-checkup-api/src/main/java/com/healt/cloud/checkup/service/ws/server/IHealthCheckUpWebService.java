package com.healt.cloud.checkup.service.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

//@WebService(name = "HealthCheckUpWebService", //暴露服务名称
// targetNamespace = "http://server.ws.service.checkup.cloud.healt.com" //命名空间，接口包名倒序
//)
//@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface IHealthCheckUpWebService {

	//体检费用状态回传
//	@WebMethod
	public String costChargeState(@WebParam(name = "costChargeStateRequestStr") String costChargeStateRequestStr);

}





//	@WebMethod
//	public @WebResult(name = "OutpOrdersResponse") OutpOrdersRes getOutpOrders(@WebParam(name = "OutpOrdersRequest") OutpOrdersReq outpOrdersReq);

//体检费用状态回传
//@WebParam(name = "costChargeStateRequest")必须写name，不然报错

//	@WebMethod
//	public @WebResult(name = "Response") CostChargeStateResponse message(@WebParam(name = "Request") CostChargeStateRequest costChargeStateRequest);
