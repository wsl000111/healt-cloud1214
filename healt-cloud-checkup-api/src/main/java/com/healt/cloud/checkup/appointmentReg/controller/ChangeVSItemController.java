package com.healt.cloud.checkup.appointmentReg.controller;

import com.healt.cloud.checkup.vo.appointmentReg.changeVSItem.SaveHcChangeVsItemListVo;
import com.healt.cloud.checkup.appointmentReg.service.ChangeVSItemService;
import com.healt.cloud.checkup.vo.appointmentReg.changeVSItem.ChangeVSItemVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author linklee
 * @create 2022-05-13 10:46
 */
@RestController
@AllArgsConstructor
@Api(tags = "换项对照接口API")
@RequestMapping("/changeVSItem")
public class ChangeVSItemController {

    private ChangeVSItemService changeVSItemService;

    /**
     * 获取换项对照表并分页
     * @param changeVSItemVo
     * @return list
     */
    @ApiOperation(value = "获取换项对照表并分页，原GetDtChargeItemt方法")
    @PostMapping("/findDtChangeVSItem")
    public PageResult findDtChangeVSItem(@RequestBody ChangeVSItemVo changeVSItemVo){
        return changeVSItemService.findDtChangeVSItem(changeVSItemVo);
    }

    /**
     * 保存、更新或删除换项对照表
     * @param saveHcChangeVsItemList
     * @return list
     */
    @ApiOperation(value = "保存、更新或删除换项对照表，原btnSave_ItemClick方法")
    @PostMapping("/saveHcChangeVsItemList")
    public void saveHcChangeVsItemList(@RequestBody SaveHcChangeVsItemListVo saveHcChangeVsItemList){
        changeVSItemService.saveHcChangeVsItemList(saveHcChangeVsItemList);
    }
}
