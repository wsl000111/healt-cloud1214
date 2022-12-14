package com.healt.cloud.checkup.encrypt.controller;

import com.healt.cloud.checkup.encrypt.service.MyEncryptDictSerivce;
import com.healt.cloud.checkup.entity.HealtEncryptDict;
import io.swagger.annotations.Api;
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
@Api(tags = "授权接口API")
@RequestMapping("/encrypt")
public class MyEncryptDictController {

    private MyEncryptDictSerivce myEncryptDictSerivce;

    @GetMapping("/getEncryptDict/{hospitalId}/{applicationCode}")
    public List<HealtEncryptDict> getEncryptDict(@PathVariable("hospitalId") String hospitalId,
                                                 @PathVariable("applicationCode") String applicationCode){
        return myEncryptDictSerivce.getEncryptDict(hospitalId, applicationCode);
    }

}
