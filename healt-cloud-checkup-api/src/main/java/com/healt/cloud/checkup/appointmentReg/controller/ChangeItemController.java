package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.entity.HcChangeVsItem;
import com.healt.cloud.checkup.entity.HcChangeitemLog;
import com.healt.cloud.checkup.vo.appointmentReg.changeItem.SaveHcChargeItemListVo;
import com.healt.cloud.checkup.appointmentReg.service.ChangeItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-16 14:32
 */
@RestController
@AllArgsConstructor
@Api(tags = "换项操作接口API")
@RequestMapping("/changeItems")
public class ChangeItemController {

    private ChangeItemService changeItemService;

    /**
     * 获得兑换日志结构
     * @param
     * @return list
     */
    @ApiOperation(value = "获得兑换日志结构，原GetdtVslog方法")
    @GetMapping("/findChangeVsItemLog")
    public List<HcChangeitemLog> findChangeVsItemLog(){
        return changeItemService.findChangeVsItemLog();
    }

    /**
     * 获得对照信息
     * @param
     * @return list
     */
    @ApiOperation(value = "获得对照信息，原gVitem_RowClick方法")
    @GetMapping("/findChangeVsItem/{hospitalId}/{itemCode}")
    public List<HcChangeVsItem> findChangeVsItem(@PathVariable("hospitalId") String hospitalId,
                                                 @PathVariable("itemCode") String itemCode){
        return changeItemService.findChangeVsItem(hospitalId,itemCode);
    }

    /**
     * 确认兑换
     * @param saveHcChargeItemList
     * @return
     */
    @ApiOperation(value = "确认兑换，原btnOK_ItemClick方法")
    @PostMapping("/saveHcChargeItemList")
    public void saveHcChargeItemList(@RequestBody SaveHcChargeItemListVo saveHcChargeItemList){
        changeItemService.saveHcChargeItemList(saveHcChargeItemList);
    }

}
