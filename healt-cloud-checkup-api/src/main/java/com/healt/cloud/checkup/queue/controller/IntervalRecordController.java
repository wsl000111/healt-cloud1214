package com.healt.cloud.checkup.queue.controller;

import com.healt.cloud.checkup.entity.HcIntervalRecord;
import com.healt.cloud.checkup.queue.service.IntervalRecordService;
import com.healt.cloud.checkup.queue.vo.IntervalRecordDictVo;
import com.healt.cloud.checkup.queue.vo.SaveIntervalRecordListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 17:20
 */
@RestController
@AllArgsConstructor
@Api(tags = "体检时间间隔记录接口API")
@RequestMapping("/intervalRecord")
public class IntervalRecordController {

    private IntervalRecordService intervalRecordService;

    /**
     * 获取体检时间间隔记录
     * @param IntervalRecordDictVo
     * @return list
     */
    @ApiOperation(value = "获取体检时间间隔记录")
    @PostMapping("/findIntervalRecord")
    public List<HcIntervalRecord> findIntervalRecord(@RequestBody IntervalRecordDictVo IntervalRecordDictVo){
        return intervalRecordService.findIntervalRecord(IntervalRecordDictVo);
    }

    /**
     * 保存、删除和更新体检时间间隔记录
     * @param saveIntervalRecordList
     * @return
     */
    @ApiOperation(value = "保存、删除和更新体检时间间隔记录")
    @PostMapping("/saveIntervalRecord")
    public void saveIntervalRecord(@RequestBody SaveIntervalRecordListVo saveIntervalRecordList){
        intervalRecordService.saveIntervalRecord(saveIntervalRecordList);
    }
}
