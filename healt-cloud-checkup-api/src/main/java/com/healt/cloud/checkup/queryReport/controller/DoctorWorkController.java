package com.healt.cloud.checkup.queryReport.controller;

import com.healt.cloud.checkup.queryReport.service.DoctorWorkService;
import com.healt.cloud.checkup.queryReport.vo.DoctorItemVo;
import com.healt.cloud.checkup.queryReport.vo.EditerItemVo;
import com.healt.cloud.checkup.queryReport.vo.FinalDocoterVo;
import com.healt.cloud.checkup.queryReport.vo.ItemPackVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 13:12
 */
@RestController
@AllArgsConstructor
@Api(tags = "医生工作量统计接口API")
@RequestMapping("/doctorWork")
public class DoctorWorkController {

    private DoctorWorkService doctorWorkService;

    /**
     *
     * @param beginDate,endDate
     * @return list
     */
    @ApiOperation(value = "原Bsearch_ItemClick的第一个select方法")
    @GetMapping("/findDoctorItem/{beginDate}/{endDate}")
    public List<DoctorItemVo> findDoctorItem(@PathVariable String beginDate, @PathVariable String endDate){
        return doctorWorkService.findDoctorItem(beginDate,endDate);
    }

    /**
     *
     * @param beginDate,endDate
     * @return list
     */
    @ApiOperation(value = "原Bsearch_ItemClick的第二个select方法")
    @GetMapping("/findEditerItem/{beginDate}/{endDate}")
    public List<EditerItemVo> findEditerItem(@PathVariable String beginDate, @PathVariable String endDate){
        return doctorWorkService.findEditerItem(beginDate,endDate);
    }

    /**
     *
     * @param beginDate,endDate
     * @return list
     */
    @ApiOperation(value = "原Bsearch_ItemClick的第三个select方法")
    @GetMapping("/findFinalDocoter/{beginDate}/{endDate}")
    public List<FinalDocoterVo> findFinalDocoter(@PathVariable String beginDate, @PathVariable String endDate){
        return doctorWorkService.findFinalDocoter(beginDate,endDate);
    }

    /**
     *
     * @param beginDate,endDate
     * @return list
     */
    @ApiOperation(value = "原Bsearch_ItemClick的第四个select方法")
    @GetMapping("/findItemPack/{beginDate}/{endDate}")
    public List<ItemPackVo> findItemPack(@PathVariable String beginDate, @PathVariable String endDate){
        return doctorWorkService.findItemPack(beginDate,endDate);
    }
}
