package com.healt.cloud.checkup.vo.appointmentReg.beforSign;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-03 10:30
 * @description: TODO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PersonByWherePageVo extends PageRequest implements Serializable {

    private String hospitalCode;      //机构编号
    private String sywbdgl;           //所有未报到过滤  非1值 语句就是 and (a.before_sign = '0' or a.before_sign is null)
    private String beforeSign;        //用来判断传的时间 是预约时间还是报到时间 0 是预约  其它是报到时间 空或者* 就不需要过滤
    private String startDate;         // 开始时间 空或者* 就不需要过滤
    private String endDate;           // 结束时间 空或者* 就不需要过滤
    private String unitId;            // 单位ID 如果 空或者* 就不需要过滤
    private String unitVisitId;       // 单位次数 如果 空或者* 就不需要过滤
    private String personId;          //  个人ID 空或者* 就不需要过滤
    private String personVisitId;     // 个人体检次数 空或者* 就不需要过滤

}
