package com.healt.cloud.checkup.controller.socket;

import com.healt.cloud.checkup.service.tcp.client.ExamQueryMLLPTCPClient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuYue
 * @date 2022-07-18 10:48
 * @description: TODO
 */
@Api(tags = "TCPClient接口测试")
@RestController
@RequestMapping("/tcpClient")
public class TCPClient {

    @GetMapping("/examQuery")
    public String examQuery(){
        ExamQueryMLLPTCPClient client = new ExamQueryMLLPTCPClient();
        return client.examApplyQuery(null);
    }

}
