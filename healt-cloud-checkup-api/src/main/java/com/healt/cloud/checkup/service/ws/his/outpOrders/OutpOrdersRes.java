package com.healt.cloud.checkup.service.ws.his.outpOrders;

import lombok.Data;

/**
 * @author GuYue
 * @date 2022-07-23 22:41
 * @description: TODO
 */
@Data
public class OutpOrdersRes {
    //1 hospitalcode 送检医院代码，本院送检的不填
    private String hospitalcode;
    //2 pat_type 病人类型  1＝门诊，2＝急诊，3＝住院，4＝体检等，体检时也可直接保存名称
    private String pat_type;
    //3 pat_no 病人号  就诊号门诊为门诊号住院为住院号（习惯号码）
    private String pat_no;
    //4 pat_id 病人唯一号  内部的唯一号，接病人id比较时使用
    private String pat_id;
    //5 pat_cardno 就诊卡号
    private String pat_cardno;
    //6 inp_id 住院标识  用于区分同一住院号多次住院，门诊用于保存就诊序号
    private String inp_id;
    //7 inp_date 住院为入院日期，门诊为就诊日期
    private String inp_date;
    //8 pat_name 病人姓名
    private String pat_name;
    //9 pat_sex  性别  1男，2女，3未知（系统支持识别：男、女、M、F）
    private String pat_sex;
    //10 pat_birth 病人生日日期 如：1975-05-11 或年龄字串  如：1岁，12月23天，这样的格式都支持，新增生日加年龄复合格式“生日|年龄”
    private String pat_birth;
    //
    //11 pat_diag 临床诊断
    private String pat_diag;
    //12 charge_typeno 收费类型 如：自费、医保等
    private String charge_typeno;
    //13 req_wardno 病人病区，门诊为空
    private String req_wardno;
    //14 req_bedno 病人床号，门诊为空
    private String req_bedno;
    //15 req_comm 医生备注  开单时由医生填写的备注信息
    private String req_comm;
    //16 req_deptno 申请科室
    private String req_deptno;
    //17 req_docno 申请医生
    private String req_docno;
    //18 req_dt 申请时间
    private String req_dt;
    //19 emer_flag 加急标志  急诊状态0非急1急
    private String emer_flag;
    //20 original_reqno 原始单号  HIS系统中的申请单号，外来标本的原始申请号条码号，如无为空
    private String original_reqno;
    //
    //21 perform_dept 执行科室
    private String perform_dept;
    //22 req_groupna 申请单类别 如：生化、免疫、临检等
    private String req_groupna;
    //23 specimen_name --标本类型 如：血、尿等
    private String specimen_name;
    //24 sample_detail 标本备注说明
    private String sample_detail;
    //25 req_reason 送检目的
    private String req_reason;
    //26 sample_items 项目描述
    private String sample_items;
    //27 charge_flag  收费标志  0未收费1已收费9已退费
    private String charge_flag;
    //28 charge_user 计价人
    private String charge_user;
    //29 charge_dt 计价时间
    private String charge_dt;
    //30 secrecy  加密标志
    private String secrecy;
    //
    //31 other_stat 备用标志  备用状态，可能his中以后会遇到在状态
    private String other_stat;
    //32 abo_bldtype  ABO血型  A/B/AB/O
    private String abo_bldtype;
    //33 rh_bldtype RH血型  +,- 表示阴性、阳性
    private String rh_bldtype;
    //34 pat_diag_icd 诊断的ICD10编码
    private String pat_diag_icd;
    //35 pat_address 病人联系地址
    private String pat_address;
    //36 pat_nation 国籍
    private String pat_nation;
    //37 pat_idcardno 身份证号护照号
    private String pat_idcardno;
    //38 pat_phone 联系电话
    private String pat_phone;
    //39 pat_height 身高  单位cm，如：175
    private String pat_height;
    //40 weight 体重  单位kg，如：58.5
    private String weight;
    //
    //41 his_itemcode HIS申请项目代码
    private String his_itemcode;
    //42 req_itemcode LIS申请项目代码
    private String req_itemcode;
    //43 req_itemname 申请项目名称
    private String req_itemname;
    //44 combitemna 所属组合名称（如H开组套肝功能，包含10个小项，则返回10条记录，本字段都是“肝功能）
    private String combitemna;
    //45 base_price 项目基准价格  检验中心时填入区域价格，普通医院填入项目单价
    private String base_price;
    //46 item_price 项目实际价格  检验中心时填入实际价格，普通医院开单时填入项目单价
    private String item_price;
    //47 qty   数量  检验一般都是1，用血时为具体申请数量
    private String qty;
    //48 amount 项目金额
    private String amount;
    //49 his_recordid 申请明细记录号 通过本字段可以追踪到HIS中一条医嘱或者一条申请项目记录，可以使用多个字段联合成唯一号
    private String his_recordid;
    //50 his_refcol1 HIS表相关备用字段1  备用，由于RecordID有时候是几个字段组合成的，编程序回调时可能需要拆分，导致编码（或者存储过程）编写不便，所以可以使用这三个字段冗余相关HIS信息
    private String his_refcol1;
    //51 his_refcol2 HIS表相关字段2
    private String his_refcol2;
    //52 his_refcol3 HIS表相关字段3
    private String his_refcol3;
    //53 popmsg弹窗提示信息
    private String popmsg;
    //54 last_menstrual 末次月经
    private String last_menstrual;
    //55 pregnancy_weeks 孕周
    private String pregnancy_weeks;
    //56 pregnancy_type 单胎/多胎妊娠
    private String pregnancy_type;
    //57 pat_enname 病人英文姓名
    private String pat_enname;
    //58 pat_othno1 病人编号1
    private String pat_othno1;
    //59 pat_othno2 病人编号2
    private String pat_othno2;
    //60 pat_othno3 病人编号3
    private String pat_othno3;
    //
    //61 生理周期
    private String MenstrualCycle;
    //62 MaritalStatus 婚姻状况
    private String MaritalStatus;
}
