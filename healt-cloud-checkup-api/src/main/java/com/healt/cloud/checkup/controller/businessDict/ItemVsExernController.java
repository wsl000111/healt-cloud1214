package com.healt.cloud.checkup.controller.businessDict;

import com.healt.cloud.checkup.entity.HcItemVsExternal;
import com.healt.cloud.checkup.service.business.ItemVsExernService;
import com.healt.cloud.checkup.vo.busniess.itemExtern.ItemPackLabVo;
import com.healt.cloud.checkup.vo.busniess.itemExtern.SaveHcItemVsExternalListVo;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-18 9:29
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "项目与检验项目结果对照接口API")
@RequestMapping("/business")
public class ItemVsExernController {

    private ItemVsExernService itemVsExernService;

    @GetMapping("/findDtItemVsExtern/{hospitalId}/{itemCode}")
    public List<HcItemVsExternal> findDtItemVsExtern(@PathVariable("hospitalId") String hospitalId, @PathVariable(value = "itemCode") String itemCode){
        return itemVsExernService.findDtItemVsExtern(hospitalId, itemCode);
    }

    @GetMapping("/findAllDtItemVsExtern/{hospitalId}")
    public List<HcItemVsExternal> findAllDtItemVsExtern(@PathVariable("hospitalId") String hospitalId){
        return itemVsExernService.findDtItemVsExtern(hospitalId, null);
    }

    @GetMapping("/findDtItemPackLab/{hospitalId}")
    public List<ItemPackLabVo> findDtItemPackLab(@PathVariable("hospitalId") String hospitalId){
        return itemVsExernService.findDtItemPackLab(hospitalId);
    }

    @PostMapping("/saveHcItemVsExternalList")
    public void saveHcItemVsExternalListVo(@RequestBody SaveHcItemVsExternalListVo saveHcItemVsExternalListVo){
        itemVsExernService.saveHcItemVsExternalListVo(saveHcItemVsExternalListVo);
    }

}
