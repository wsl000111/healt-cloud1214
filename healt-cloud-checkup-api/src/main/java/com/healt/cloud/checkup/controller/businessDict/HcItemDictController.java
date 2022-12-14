package com.healt.cloud.checkup.controller.businessDict;

import com.healt.cloud.checkup.entity.HcItemDict;
import com.healt.cloud.checkup.service.business.ItemDictService;
import com.healt.cloud.checkup.vo.busniess.item.HcItemDictVo;
import com.healt.cloud.checkup.vo.busniess.item.SaveHcItemDictListVo;
import com.healt.cloud.common.pages.PageResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-11 9:25
 * @description: 项目设置
 */
@RestController
@AllArgsConstructor
@Api(tags = "项目设置接口API")
@RequestMapping("/business")
public class HcItemDictController {

    private ItemDictService businessService;

    @PostMapping("/findHcItemDict")
    public List<HcItemDict> findHcItemDict(@RequestBody HcItemDictVo hcItemDictVo){
        return businessService.findHcItemDict(hcItemDictVo);
    }

    @PostMapping("/findVHcItemDict")
    public List<? extends Serializable> findVHcItemDict(@RequestBody HcItemDictVo hcItemDictVo){
        return businessService.findVHcItemDict(hcItemDictVo);
    }

    @PostMapping("/findHcItemDictPage")
    public PageResult findHcItemDictPage(@RequestBody HcItemDictVo hcItemDictVo){
        return businessService.findHcItemDictPage(hcItemDictVo);
    }

    @PostMapping("/saveHcItemDictList")
    public void saveHcItemDictList(@RequestBody SaveHcItemDictListVo saveHcItemDictListVo){
        businessService.saveHcItemDictList(saveHcItemDictListVo);
    }

}
