package com.healt.cloud.checkup.vo.settlement.vo;

import com.healt.cloud.checkup.vo.settlement.HcDiscountSchemeDetailVo;
import com.healt.cloud.checkup.vo.settlement.HcDiscountSchemeVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-06 11:05
 */
@Data
public class SaveHcDiscountSchemeVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<HcDiscountSchemeVo> hcDiscountScheme;
    private List<HcDiscountSchemeDetailVo> hcDiscountSchemeDetail;

}
/**
 #region 打折信息维护
 public class SaveHcDiscountScheme
 {
 public List<HC_DISCOUNT_SCHEME> hcDiscountScheme { get; set; } //打折方案主表,为空只操作细表
 public List<HC_DISCOUNT_SCHEME_DETAIL> hcDiscountSchemeDetail { get; set; } //打折方案细表
 }

 public class HC_DISCOUNT_SCHEME
 {
 public string stat { get; set; } //add  update delete
 public string SCHEME_NAME { get; set; } // 打折方案名
 public string  SCHEME_CODE { get; set; } //打折方案编码
 public string  EFFECTIVE_FLAG { get; set; } //是否有效 1有效 0无效
 public string  HOSPITAL_ID { get; set; } // 医院编号
 }
 public class HC_DISCOUNT_SCHEME_DETAIL
 {
 public string stat { get; set; } //add  update delete
 public string SCHEME_CODE { get; set; } // 打折方案代码
 public string ITEM_ASSEM_CODE { get; set; } // 项目组合代码
 public string DISCOUNT_CLASS { get; set; } //  打折类别 打折系数0 打折金额1
 public string DISCOUNT_RATIO { get; set; } //  打折系数
 public string DISCOUNT_PRICE { get; set; } //  打折金额
 public string HOSPITAL_ID { get; set; } //  机构编号

 }
 #endregion
 */