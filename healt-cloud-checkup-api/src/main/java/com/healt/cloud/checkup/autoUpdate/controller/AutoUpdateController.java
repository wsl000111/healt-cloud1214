package com.healt.cloud.checkup.autoUpdate.controller;

import com.healt.cloud.checkup.autoUpdate.vo.AppParsVo;
import com.healt.cloud.checkup.autoUpdate.vo.ApplicationsParaVo;
import com.healt.cloud.checkup.autoUpdate.vo.HealtUpdateLogListVo;
import com.healt.cloud.checkup.autoUpdate.vo.SaveHealtUpdateParaListVo;
import com.healt.cloud.checkup.entity.HealtUpdatePara;
import com.healt.cloud.checkup.autoUpdate.service.AutoUpdateSerivce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-07 17:21
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@Api(tags = "自动更新接口API")
@RequestMapping("/update")
public class AutoUpdateController {

    private AutoUpdateSerivce autoUpdateSerivce;

    @PostMapping("/getLastUpLoadTime")
    public String getLastUpLoadTime(@RequestBody ApplicationsParaVo applicationsParaVo){
        return autoUpdateSerivce.lastUpLoadTime(applicationsParaVo);
    }

    @GetMapping("/getLastUpLoadTime/{code}")
    public String getLastUpLoadTime(@PathVariable("code") String code){
        return autoUpdateSerivce.lastUpLoadTime(code);
    }

    @ApiOperation("获取程序名列表")
    @GetMapping("/getAppPars")
    public List<AppParsVo> getAppPars(){
        return autoUpdateSerivce.getAppPars("");
    }

    @ApiOperation("获取程序名列表,根据hospitalId")
    @GetMapping("/getAppPars/{hospitalId}")
    public List<AppParsVo> getAppPars(@PathVariable("hospitalId") String hospitalId){
        return autoUpdateSerivce.getAppPars("");
    }

    @ApiOperation("获取服务端路径")
    @GetMapping("/getRemotepath/{hospitalId}/{code}")
    public String getRemotepath(@PathVariable("hospitalId") String hospitalId,
                                @PathVariable("code") String code){
        return autoUpdateSerivce.getRemotepath(hospitalId, code);
    }

    @ApiOperation("修改最后一次更新时间")
    @GetMapping("/updateLastuploadtime/{hospitalId}/{code}")
    public void updateLastuploadtime(@PathVariable("hospitalId") String hospitalId,
                                     @PathVariable("code") String code){
        autoUpdateSerivce.updateLastuploadtime(hospitalId, code);
    }

    @ApiOperation("新增或者修改HealtUpdatePara")
    @PostMapping("/saveHealtUpdatePara")
    public void saveHealtUpdatePara(@RequestBody SaveHealtUpdateParaListVo saveHealtUpdateParaListVo){
        autoUpdateSerivce.saveHealtUpdatePara(saveHealtUpdateParaListVo);
    }

    @ApiOperation("取ftp服务端设置")
    @GetMapping("/getFtpValue/{hospitalId}/{code}")
    public String getFtpValue(@PathVariable("hospitalId") String hospitalId,
                              @PathVariable("code") String code){
        return autoUpdateSerivce.getFtpValue(hospitalId, code);
    }

    @ApiOperation("hospitalId为*时不参与查询, bz为*时不参与查询")
    @GetMapping("/getFtpPara/{hospitalId}/{bz}")
    public List<HealtUpdatePara> getUpdatePara(@PathVariable("hospitalId") String hospitalId,
                                               @PathVariable("bz") String bz){
        return autoUpdateSerivce.getUpdatePara(hospitalId, bz);
    }

    @ApiOperation("hospitalId为*时不参与查询, bz为*时不参与查询")
    @GetMapping("/getFtpPara/{hospitalId}")
    public List<HealtUpdatePara> getUpdatePara(@PathVariable("hospitalId") String hospitalId){
        return autoUpdateSerivce.getUpdatePara(hospitalId, "*");
    }

    @ApiOperation("保存上传下载日志")
    @PostMapping("/saveHealtUpdateLog")
    public void saveHealtUpdateLog(@RequestBody HealtUpdateLogListVo healtUpdateLogListVo){
        autoUpdateSerivce.saveHealtUpdateLog(healtUpdateLogListVo);
    }

//    @GetMapping("/testMap")
//    public Map<String, Object> testMap(){
//        Map<String, Object> map = new HashMap<>();
//        map.put("1", "1");
//        map.put("2", null);
//        map.put("date", new Date());
//        return map;
//    }

}
