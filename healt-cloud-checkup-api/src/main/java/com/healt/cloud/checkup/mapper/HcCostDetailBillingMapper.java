package com.healt.cloud.checkup.mapper;

import com.healt.cloud.checkup.entity.CostDetailBilling;
import com.healt.cloud.checkup.vo.busniess.costDetail.CostDetailBillingDictVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author linklee
 * @create 2022-08-01 13:11
 */
@Mapper
public interface HcCostDetailBillingMapper {

    List<CostDetailBilling> findCostDetailBillingFilter(CostDetailBillingDictVo costDetailBillingDictVo);

    Integer findCompanyOrderId();

    @Select("select sum(CHARGES) from cost_detail_billing where orderid='${orderId}'")
    BigDecimal sumCharges(String orderId);
}
