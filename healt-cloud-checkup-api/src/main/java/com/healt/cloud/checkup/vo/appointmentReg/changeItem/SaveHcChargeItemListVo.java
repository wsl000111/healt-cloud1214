package com.healt.cloud.checkup.vo.appointmentReg.changeItem;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-16 16:12
 */
@Data
public class SaveHcChargeItemListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveHcChargeItemVo> saveHcChargeItemList;
}

/**
 #region  换项 确认
 public class SaveHcChargeItemList
 {
 public List<SaveHcChargeItem> saveHcChargeItemList { get; set; }
 }
 public class SaveHcChargeItem  //缴费标记与原来一样
 {
 public string HOSPITAL_ID { get; set; }// 机构ID
 public string ITEM_PACK_CODE { get; set; }//被兑换项目编码
 public string ITEM_PACK_NAME { get; set; }// 被兑换项目名称
 public List<ChangeItemm> changeItemm { get; set; }
 public string OPER_DATE { get; set; }//   产生时间
 public string OPER_ID { get; set; }// 操作人
 public string OPER_NAME { get; set; }// 操作人姓名
 public string PERSON_ID { get; set; }//人员编号
 public string PERSON_VISIT_ID { get; set; }//体检次数
 public string ITEM_NO { get; set; }//序号
 }
 public class ChangeItemm
 {
 public string CHANGE_ITEM_CODE { get; set; }//兑换项目编码(存日志的时候 多个项目时用| 分割)
 public string CHANGE_ITEM_NAME { get; set; }//兑换项目名称(存日志的时候 多个项目时用| 分割)
 }
 #endregion
 */
