package com.luo.apiinterface;

import com.luo.apiclientsdk.client.ApiClient;
import com.luo.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClient apiClient;
    @Test
    void contextLoads() {
        String res = apiClient.getNameByGet("lkx");
        apiClient.getNameByPost("王文沛");
        User user = new User();
        user.setUserName("lkx");
        apiClient.getUserNameByPost(user);
        System.out.println(res);
    }

}
