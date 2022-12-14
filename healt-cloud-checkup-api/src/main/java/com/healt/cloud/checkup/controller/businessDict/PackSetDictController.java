package com.healt.cloud.checkup.controller.businessDict;

import com.healt.cloud.checkup.entity.HcPackSetDict;
import com.healt.cloud.checkup.service.business.PackSetDictService;
import com.healt.cloud.checkup.vo.busniess.packClinic.SaveHcPackSetDictListVo;
import com.healt.cloud.checkup.vo.busniess.packSet.HcSetVsPackDictVo;
import com.healt.cloud.checkup.vo.busniess.packSet.PackSetNewVo;
import com.healt.cloud.checkup.vo.busniess.packSet.SaveHcSetVsPackDictVo;
import com.healt.cloud.checkup.vo.busniess.packSet.VHcItemPackDictVo;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-17 8:52
 * @description: 套餐设置
 */
@RestController
@AllArgsConstructor
@Api(tags = "套餐设置接口API")
@RequestMapping("/business")
public class PackSetDictController {

    private PackSetDictService packSetDictService;


    @GetMapping("/findDtPackSetDict/{hospitalId}")
    public List<HcPackSetDict> findDtPackSetDict(@PathVariable String hospitalId){
        return packSetDictService.findDtPackSetDict(hospitalId);
    }

    @GetMapping("/findDtSetVsPack/{hospitalId}/{setCode}")
    public List<HcSetVsPackDictVo> findDtSetVsPack(@PathVariable("hospitalId") String hospitalId, @PathVariable("setCode") String setCode){
        return packSetDictService.findDtSetVsPack(hospitalId, setCode);
    }

    @GetMapping("/findDtItemPackDict/{hospitalId}")
    public List<VHcItemPackDictVo> findDtItemPackDict(@PathVariable String hospitalId){
        return packSetDictService.findDtItemPackDict(hospitalId);
    }

    @PostMapping("/saveHcPackSetDictList")
    public void saveHcPackSetDictList(@RequestBody SaveHcPackSetDictListVo saveHcPackSetDictListVo){
        packSetDictService.saveHcPackSetDictList(saveHcPackSetDictListVo);
    }

    @PostMapping("/saveHcSetVsPackDict")
    public void saveHcSetVsPackDictList(@RequestBody SaveHcSetVsPackDictVo saveHcSetVsPackDictVo){
        packSetDictService.saveHcSetVsPackDictList(saveHcSetVsPackDictVo);
    }

    @GetMapping("/findPackSetNew")
    public List<PackSetNewVo> findPackSetNew(){
        return packSetDictService.findPackSetNew();
    }
}
