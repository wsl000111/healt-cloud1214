package com.healt.cloud.checkup.controller.businessDict;

import com.healt.cloud.checkup.entity.HcPackVsClinic;
import com.healt.cloud.checkup.entity.VClinicItemClass;
import com.healt.cloud.checkup.vo.busniess.clinicPrice.ClinicItemPrice;
import com.healt.cloud.checkup.vo.busniess.packClinic.SaveHcPackVsClincListVo;
import com.healt.cloud.checkup.vo.busniess.packClinic.VClinicItemsVo;
import com.healt.cloud.checkup.service.business.PackVsClinicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-11 9:25
 * @description: 组合和诊疗对照
 */
@RestController
@AllArgsConstructor
@Api(tags = "组合和诊疗对照接口API")
@RequestMapping("/business")
public class HcPackVsClinicController {

    private PackVsClinicService packVsClinicService;

    @PostMapping("/findDtClinicItemClass")
    private List<VClinicItemClass> findDtClinicItemClass(){
        return packVsClinicService.findDtClinicItemClass();
    }

    @GetMapping("/findDtClinicItems/{itemClass}")
    private List<VClinicItemsVo> findDtClinicItems(@PathVariable String itemClass){
        return packVsClinicService.findDtClinicItems(itemClass);
    }

    @GetMapping("/findDtPackVsClinic/{hospitalCode}/{itemPackCode}")
    private List<HcPackVsClinic> findDtPackVsClinic(@PathVariable("hospitalCode") String hospitalCode, @PathVariable("itemPackCode") String itemPackCode){
        return packVsClinicService.findDtPackVsClinic(hospitalCode, itemPackCode);
    }

    @PostMapping("/saveHcPackVsClincList")
    public void saveHcPackVsClincList(@RequestBody SaveHcPackVsClincListVo saveHcPackVsClincListVo){
        packVsClinicService.saveHcPackVsClincList(saveHcPackVsClincListVo);
    }

    @ApiOperation("按类别更新诊疗项目字典，时间较长")
    @GetMapping("/reloadMdmClinicitemQuery/{itemClass}")
    public void reloadMdmClinicitemQuery(@PathVariable String itemClass){
        packVsClinicService.reloadMdmClinicitemQuery(itemClass);
    }

    @ApiOperation("更新价表项目字典，参数都为*时更新全部字典")
    @GetMapping("/reloadMdmClinicpriceQuery/{itemClass}/{itemCode}")
    public void reloadMdmClinicpriceQuery(@PathVariable String itemClass,
                                          @PathVariable String itemCode){
        packVsClinicService.reloadMdmClinicpriceQuery(itemClass, itemCode);
    }

    @ApiOperation("/价表项目查询, ItemClass项目类型为*时查询所有价表项目，ItemCode为*时不进行过滤")
    @GetMapping("/findClinicItemPrice/{itemClass}/{itemCode}")
    public List<ClinicItemPrice> findClinicItemPrice(@PathVariable String itemClass,
                                                     @PathVariable String itemCode){
        return packVsClinicService.findClinicItemPrice(itemClass, itemCode, "findClinicItemPrice");
    }

}
