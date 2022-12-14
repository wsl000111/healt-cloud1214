package com.healt.cloud.checkup.controller.login;

import com.healt.cloud.checkup.service.ws.WebServiceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuYue
 * @date 2022-08-20 21:10
 * @description: TODO
 */
@Api(tags = "单点登录接口API")
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private WebServiceClient client;

    @ApiOperation("单点登录")
    @GetMapping("/ssoLogin/{sysUri}/{ticket}")
    public String ssoLogin(@PathVariable String sysUri, @PathVariable String ticket){
        return client.ssoLogin(sysUri, ticket);
    }

}
