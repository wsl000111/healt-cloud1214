package com.healt.cloud.checkup.vo.settlement.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.healt.cloud.checkup.vo.settlement.RevItemsBillIndicator;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-27 8:58
 */
@Data
public class SaveHcReturnSettleListVo implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;//机构编号
    public String rcptNo;//要退费的收据号 获取原收据
    public String newRcptNo;//产生的全部退费负记录收据号
    public String userName;//用户代码
    public String userRealName;//用户名称

    public List<RevItemsBillIndicator> revItemsBillIndicators;//还原收费项目计价标志集合
    public List<SaveHcSettleVo> saveHcSettleList;//收费主表细表支付方式 如果是全部退费了，就是空，如果部分退费，就是剩余需要缴费的组合

    /*
    #region 退费按钮
        public class SaveHcReturnSettleList
        {
            public string HOSPITAL_ID { get; set; } // 机构编号
            public string rcptNo { get; set; } // 要退费的收据号 获取原收据
            public string newRcptNo { get; set; } //产生的全部退费负记录收据号
            public string userName { get; set; } //用户代码
            public string userRealName { get; set; } //用户名称
            public List<RevItemsBillIndicator> revItemsBillIndicators { get; set; } //还原收费项目计价标志集合
            public List<SaveHcSettle> saveHcSettleList { get; set; } //收费主表细表支付方式 如果是全部退费了，就是空，如果部分退费，就是剩余需要缴费的组合
        }
        public class RevItemsBillIndicator // 还原收费项目计价标志
        {
            public string PERSON_ID { get; set; } // 个人编号
            public string PERSON_VISIT_ID { get; set; } // 体检次数
            public string ITEM_PACK_CODE { get; set; } // 项目代码
            public string ITEM_NO { get; set; } //项目序号
        }
    * */
}
