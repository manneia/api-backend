package com.luo.apiinterface.controller;

import com.luo.apiclientsdk.model.User;
import com.luo.apiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lkx
 * @version 1.0.0
 * @Description 查询名字
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String getNameByGet(String name,HttpServletRequest request) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        String oldAccessKey = "lkx";
        String oldSecretKey = "abcdefgh";
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String sign = request.getHeader("sign");
        String timestamp = request.getHeader("timestamp");
        String body = request.getHeader("body");
        // todo 实际情况应该是去数据库查看是否已经分配给用户
        if (!oldAccessKey.equals(accessKey)) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限 ");
        }
        // todo 时间不能超过当前时间五分钟
        String serverSign = SignUtils.getSign(body, "abcdefgh");
        if (!sign.equals(serverSign)) {
            throw new RuntimeException("无权限 ");
        }
        String result = "POST 你的名字是" + user.getUserName();
        // todo 调用次数 + 1
        return result;
    }
}
