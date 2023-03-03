package com.luo.apiinterface;

import com.luo.apiinterface.client.ApiClient;
import com.luo.apiinterface.model.User;

/**
 * @author lkx
 * @version 1.0.0
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        String accessKey = "lkx";
        String secretKey = "abcdefgh";
        ApiClient client = new ApiClient(accessKey, secretKey);
        String res1 = client.getNameByGet("王文沛");
        String res2 = client.getNameByPost("王文倩");
        User user = new User();
        user.setUserName("lkx");
        String res3 = client.getUserNameByPost(user);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
