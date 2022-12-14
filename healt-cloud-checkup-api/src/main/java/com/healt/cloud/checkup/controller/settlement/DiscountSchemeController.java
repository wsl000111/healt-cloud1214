package com.healt.cloud.checkup.controller.settlement;

import com.healt.cloud.checkup.entity.HcDiscountScheme;
import com.healt.cloud.checkup.entity.HcDiscountSchemeDetail;
import com.healt.cloud.checkup.service.settlement.DiscountSchemeService;
import com.healt.cloud.checkup.vo.settlement.DtItemPackVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcDiscountSchemeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-05 14:19
 */
@RestController
@AllArgsConstructor
@Api(tags = "打折方案维护接口API")
@RequestMapping("/discountScheme")
public class DiscountSchemeController {

    private DiscountSchemeService discountSchemeService;

    @ApiOperation(value = "原GetDtItemPack方法")
    @GetMapping("/findDtItemPack/{hospitalId}")
    public List<DtItemPackVo> findDtItemPack(@PathVariable("hospitalId") String hospitalId){
        return discountSchemeService.findDtItemPack(hospitalId);
    }

    @ApiOperation(value = "查询主表，原FrmDiscounScheme_Load的第一个方法")
    @GetMapping("/findDiscountScheme")
    public List<HcDiscountScheme> findDiscountScheme(){
        return discountSchemeService.findDiscountScheme();
    }

    @ApiOperation(value = "查询细表，原FrmDiscounScheme_Load的第二个方法")
    @GetMapping("/findDiscountSchemeDetail")
    public List<HcDiscountSchemeDetail> findDiscountSchemeDetail(){
        return discountSchemeService.findDiscountSchemeDetail();
    }

    @ApiOperation(value = "原bBadd_ItemClick的select方法")
    @GetMapping("/findSysdate")
    public String findSysdate(){
        return discountSchemeService.findSysdate();
    }

    @ApiOperation(value = "删除主表和细表，原bBdelete_ItemClick方法")
    @GetMapping("/deleteDiscountSchemeAndDetail/{hospitalId}/{schemeCode}")
    public void deleteDiscountSchemeAndDetail(@PathVariable("hospitalId") String hospitalId,
                                              @PathVariable("schemeCode") String schemeCode){
        discountSchemeService.deleteDiscountSchemeAndDetail(hospitalId,schemeCode);
    }

    @ApiOperation(value = "保存或者更新主表和细表，原bBsave_ItemClick方法")
    @PostMapping("/saveDiscountSchemeAndDetail")
    public void saveDiscountSchemeAndDetail(@RequestBody SaveHcDiscountSchemeVo saveHcDiscountScheme) {
        discountSchemeService.saveDiscountSchemeAndDetail(saveHcDiscountScheme);
    }

    @ApiOperation(value = "删除细表，原bBdeleteDetail_ItemClick方法")
    @GetMapping("/deleteDiscountSchemeDetail/{itemAssemCode}/{schemeCode}")
    public void deleteDiscountSchemeDetail(@PathVariable("itemAssemCode") String itemAssemCode,
                                              @PathVariable("schemeCode") String schemeCode){
        discountSchemeService.deleteDiscountSchemeDetail(itemAssemCode,schemeCode);
    }
}
