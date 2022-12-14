package com.healt.cloud.common.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

public class SoapUtil {
	//生产库
	//public static String postUrl = "http://10.131.3.13/isc/services";//http://192.168.10.129:52773/wgpasst/PHYS-EnsLib.SOAP.GenericService/isc/services";

	//测试库
	public static String postUrl = "http://192.168.10.131/isc/services?wsdl";
	//public static String postUrl = "http://192.168.10.110:8081/isc/services";
	public static String soapXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n" +
			"<soap:Envelope\r\n" + 
			"    xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n" + 
			"    xmlns:weg=\"http://wegohis.com\">\r\n" + 
			"    <soap:Header/>\r\n" + 
			"    <soap:Body>\r\n" + 
			"        <weg:message>\r\n" + 
			"            <Request>\r\n" + 
			"                <Header>\r\n" + 
			"                    <Sender>HIS</Sender>\r\n" + 
			"                    <Receiver>HIS</Receiver>\r\n" + 
			"                    <SendDate>20220701151131</SendDate>\r\n" + 
			"                    <ServiceCode>USER_QUERY_LIST</ServiceCode>\r\n" + 
			"                    <MsgId>b345a3909cdc487fac77a4444a10b2da</MsgId>\r\n" + 
			"                    <AuthCode>f4d032801283371e266828fed1101828</AuthCode>\r\n" + 
			"                    <Version>1.0</Version>\r\n" + 
			"                </Header>\r\n" + 
			"                <Body>\r\n" + 
			"				<UserInfo>\r\n" + 
			"				<UserName></UserName>\r\n" + 
			"				<PyCode></PyCode>\r\n" + 
			"				<WorkDept></WorkDept>\r\n" + 
			"				<WorkPost></WorkPost>\r\n" + 
			"				<PeopleClass></PeopleClass>\r\n" + 
			"				<PeopleIdentifier></PeopleIdentifier>\r\n" + 
			"				</UserInfo>\r\n" + 
			"                </Body>\r\n" + 
			"            </Request>\r\n" + 
			"        </weg:message>\r\n" + 
			"    </soap:Body>\r\n" + 
			"</soap:Envelope>";
	
	public static void main(String[] args) {
		SoapUtil.doPostSoap1_1(SoapUtil.postUrl, SoapUtil.soapXml, "");
	}

	public static String doPostSoap1_1(String soapXml){
		return doPostSoap1_1(SoapUtil.postUrl, soapXml, "");
	}
	public static String doPostSoap1_1(String soapXml,String soapAction){
		return doPostSoap1_1(SoapUtil.postUrl, soapXml, soapAction);
	}

	public static String doPostSoap1_1(String postUrl, String soapXml,String soapAction) {         
		//System.out.println("开始转发webservice：" + postUrl);
		String retStr = "";         
		// 创建HttpClientBuilder         
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();         
		// HttpClient        
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();         
		HttpPost httpPost = new HttpPost(postUrl);         
		//  设置请求和传输超时时间        
		/* RequestConfig requestConfig = RequestConfig.custom()
		 * .setSocketTimeout(socketTimeout)
		 * .setConnectTimeout(connectTimeout).build();         
		 * httpPost.setConfig(requestConfig);*/         
		try {             
			httpPost.setHeader("Content-Type", "application/soap+xml;charset=UTF-8");             
			httpPost.setHeader("SOAPAction", soapAction);             
			StringEntity data = new StringEntity(soapXml,Charset.forName("UTF-8"));             
			httpPost.setEntity(data);             
			CloseableHttpResponse response = closeableHttpClient.execute(httpPost);             
			HttpEntity httpEntity = response.getEntity();             
			if (httpEntity != null) {                 
				// 打印响应内容                 
				retStr = EntityUtils.toString(httpEntity, "UTF-8");                 
				//System.out.println("response:" + retStr);
			}          
		} catch (Exception e) {             
			e.printStackTrace();   
		} finally {// 释放资源             
			try {                 
				closeableHttpClient.close();
			} catch (IOException e) {                 
				e.printStackTrace();             
			}         
		}         
		return retStr;     
	}      
	public static String doPostSoap1_2(String postUrl, String soapXml, String soapAction) {         
		String retStr = "";         
		// 创建HttpClientBuilder         
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();         
		// HttpClient        
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();         
		HttpPost httpPost = new HttpPost(postUrl);       
		/*  // 设置请求和传输超时时间         RequestConfig requestConfig = RequestConfig.custom() .setSocketTimeout(socketTimeout)                 .setConnectTimeout(connectTimeout).build();         httpPost.setConfig(requestConfig);*/         
		try {             
			httpPost.setHeader("Content-Type","text/xml;charset=UTF-8;action=\"" + soapAction + "\"");
			StringEntity data = new StringEntity(soapXml, Charset.forName("UTF-8"));             
			httpPost.setEntity(data);             
			CloseableHttpResponse response = closeableHttpClient.execute(httpPost);             
			HttpEntity httpEntity = response.getEntity();             
			if (httpEntity != null) {                 
				// 打印响应内容                 
				retStr = EntityUtils.toString(httpEntity, "UTF-8");                 
				System.out.println("response:" + retStr);             
			}             
			// 释放资源           
			closeableHttpClient.close();         
		} catch (Exception e) {             
			e.printStackTrace();       
		}         
		return retStr;     
	}

	public static String bean2Xml(Object obj){

		String result = null;
		StringWriter writer = null;
		String prefix = "";

		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
			//System.out.println(result);
			return result;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static <T> T xml2Bean(String soapXml, Class<T> aClass){
		try{
			InputStream stream = new ByteArrayInputStream(soapXml.getBytes(StandardCharsets.UTF_8));
			JAXBContext context = JAXBContext.newInstance(aClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(stream);
			JAXBElement<T> tjaxbElement = unmarshaller.unmarshal(eventReader, aClass);
			T t = tjaxbElement.getValue();
			return t;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 字符串截取，只留<Response>部分
	 * @return
	 */
	public static String subXml(String resXml, String start, String end){
		return resXml.substring(resXml.indexOf(start), resXml.indexOf(end)+end.length());
	}

	public static String getValue(String resXml, String start, String end){
		return resXml.substring(resXml.indexOf(start)+start.length(), resXml.indexOf(end));
	}

	public static String getChargeItemList(String resXml, String start, String end) {
		try {
			return resXml.substring(resXml.indexOf(start), resXml.indexOf(end)+end.length());
		}catch (Exception e){
			return null;
		}
	}
}
