package com.healt.cloud.web.entity.sms;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-14 15:53
 * @description: TODO
 */
@Data
public class SMSResponseBody implements Serializable {
    private String rspcod;		//响应状态，详见下表。
    private String msgGroup;	//消息批次号，由云MAS平台生成，用于关联短信发送请求与状态报告，注：若数据验证不通过，该参数值为空。
    private boolean success;	//数据校验结果。
}
