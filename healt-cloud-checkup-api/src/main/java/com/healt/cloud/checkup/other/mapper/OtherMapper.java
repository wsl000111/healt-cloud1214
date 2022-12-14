package com.healt.cloud.checkup.other.mapper;

import com.healt.cloud.checkup.entity.CostDetailBilling;
import com.healt.cloud.checkup.other.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-26 18:53
 * @description: TODO
 */
@Mapper
public interface OtherMapper {

    @Select("select a.test_no testNo,a.print_order printOrder,a.item_no itemNo,a.report_item_name reportItemName, a.report_item_code reportItemCode," +
            "a.result result,a.units units,a.abnormal_indicator abnormalIndicator,a.print_context printContext from hclab_result a where a.test_no in " +
            "(select apply_no from hc_person_appreg_items hi where hi.person_id = #{personId} and " +
            "hi.person_visit_id = #{personVisitId} and hi.apply_no is not null )")
    public List<HclabResultByPVVo> findHclabResultByPV(String personId, String personVisitId);

    @Select("select a.dept_name deptName,a.item_assem_code itemAssemCode,a.item_assem_name itemAssemName,a.hc_item_code hcItemCode,a.hc_item_name hcItemName,a.assem_sort_no assemSortNo,a.item_order_no itemOrderNo," +
            "a.key_name keyName,a.hc_result hcResult,a.unit,a.print_context printContext,a.abnormal_indicator abnormalIndicator,a.hc_result_date hcResultDate,a.abnormal_flag abnormalFlag" +
            " from hc_result_dict a " +
            "where a.dept_id = #{deptId} and a.person_id = #{personId} and  a.person_visit_id = #{personVisitId}")
    public List<HcResultDictOtherVo> findHcResultDict(String deptId, String personId, String personVisitId);

    @Update("update hc_dept_result_items a set a.in_chief_report ='1' " +
            "where a.hospital_id ='${hospitalId}' and a.person_id = #{personId} " +
            "and a.person_visit_id ='${personVisitId}' and  a.content = #{content}")
    public void updateDeptResultItems(String hospitalId, String personId, String personVisitId, String contentClass, String content);

    @Select("select patientid,PERSON_ID personId,PERSON_VISIT_ID personVisitId,UNIT_ID unitId,UNIT_VISIT_ID unitVisitId," +
            "        patientname,patienttype,visitid,paivisitid,examtype,examcompanyno,examcompanyname,currentorgdcode,currentwardcode," +
            "        orderid,applyno,clinictype,feeitemclass,clinicitemid,clinicitemname,itemtype,feeitemid,feeitemname,drugspec," +
            "        pharmacyfactoryname,num,unit,unitprice,unitcoeff,totalprice,charges,classonrcpt,applydoctorcode,applydoctorname," +
            "        applyorgcode,applyorgname,execorgcode,execorgname,chargedate,enterdate,HOSPITAL_ID hospitalId,ITEM_PACK_CODE itemPackCode," +
            "        HC_ITEM_NO hcItemNo,rekid,RETURN_REKID returnRekid from cost_detail_billing a  where a.person_id =#{personId} and a.person_visit_id =#{personVisitId} and rekid is null")
    public List<CostDetailBilling> findCostDetailBilling(String personId, String personVisitId);

    @Select("select a.item_pack_name itemPackName,a.apply_no applyNo,b.name,b.sex,b.person_id personId,b.patient_id patientId," +
            "b.id_no idNo, b.unit_name unitName, a.person_visit_id personVisitId ," +
            "c.req_date_time reqDateTime, c.req_dept reqDept, c.req_physician reqPhysician" +
            " from hc_person_appreg_items a,hc_person_info b,hc_exam_master c " +
            " where a.person_id = b.person_id " +
            " and a.apply_no =c.exam_no " +
            " and a.dept_id ='6'  and a.person_id ='${personId}' and a.person_visit_id = '${personVisitId}'" +
            " and b.patient_id is not null ")
    List<FinidPathologyApplyVo> findPathologyApply(String personId, String personVisitId);

    @Select("   select   aaa.dept_id deptId,aaa.dept_name deptName, aaa.item_pack_code itemPackCode,aaa.item_pack_name itemPackName, aaa.dj ,sum(grs) grs,sum(grcosts) as grcosts," +
            "   sum(grcharges) as grcharges,sum(tjcosts) as tjcosts,sum(tjcharges) as tjcharges,sum(tjrs) as tjrs from" +
            "( select c.dept_id,c.dept_name, c.item_pack_code,c.item_pack_name ,c.costs as dj," +
            "    count(distinct c.person_id ) grs, sum(a.totalprice) grcosts ,sum(a.charges ) as grcharges ,0 tjcosts, 0 tjcharges ,0 tjrs" +
            "     from cost_detail_billing a ,cost_charge_state_master b,hc_person_appreg_items c" +
            "     where a.person_id = b.person_id" +
            "     and a.person_visit_id = b.person_visit_id" +
            "      and a.rekid = b.rekid" +
            "     and a.person_id = c.person_id" +
            "     and a.person_visit_id = c.person_visit_id" +
            "     and a.orderid = c.order_id" +
            "     and b.operatetime >= to_date('${beginDate}','yyyy-MM-dd hh24:mi:ss') " +
            "     and b.operatetime <= to_date('${endDate}','yyyy-MM-dd hh24:mi:ss')" +
            "     and b.Feestatus ='1'" +
            "     group by  c.dept_id,c.dept_name, c.item_pack_code,c.item_pack_name ,c.costs " +
            "     union all " +
            "     select cc.dept_id,cc.dept_name,cc.item_pack_code,cc.item_pack_name,cc.costs as dj," +
            "         0 as grs, 0 grcosts,0 grcharges,sum(cc.costs) as tjcosts ,sum(cc.charges) as tjcharges ,count(distinct cc.person_id ) as tjrs" +
            "      from  HEALTHCHECKUP.ACCOUNTS_CHARGE_BACK aa,HEALTHCHECKUP.COMPANY_COST_BACK bb," +
            "     hc_person_appreg_items cc" +
            "     where aa.rekid = bb.rekid " +
            "     and aa.orderid = cc.tj_order_id" +
            "       and aa.operatetime >= to_date('${beginDate}','yyyy-MM-dd hh24:mi:ss') " +
            "     and aa.operatetime <= to_date('${endDate}','yyyy-MM-dd hh24:mi:ss')" +
            "     and aa.Feestatus ='1'" +
            "     group by cc.dept_id,cc.dept_name,cc.item_pack_code,cc.item_pack_name,cc.costs" +
            "     ) aaa" +
            "     group by aaa.dept_id,aaa.dept_name, aaa.item_pack_code,aaa.item_pack_name  ,aaa.dj")
    List<CostDetailBillingByTimeVo> findCostDetailBillingByTime(String beginDate, String endDate);

    @Select("update hc_person_visit_info a set a.unit_id = '${unitId}' ,a.unit_visit_id ='${unitVisitId}'," +
            "a.unit_name = '${unitName}' where a.person_id ='${personId}' and a.person_visit_id ='${personVisitId}' ")
    void updatePersonVisitInfo(String unitId, String unitVisitId, String unitName, String personId, String personVisitId);

    List<PersonUnitInfoVo> findPersonUnitInfo(PersonUnitInfoDictVo personUnitInfoDictVo);

    List<TjShouRuTongJi> findTjtj(String tbegindate, String tenddate);

    List<TjtjDept> findTjtjDept(String tbegindate, String tenddate);
}
