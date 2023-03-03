package com.luo.apiinterface.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.luo.apiinterface.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.luo.apiinterface.utils.SignUtils.getSign;

/**
 * @author lkx
 * @version 1.0.0
 * @Description 接口调用客户端
 */
public class ApiClient {
    private String accessKey;
    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(@RequestParam String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post("http://localhost:8123/api/name/user", paramMap);
        System.out.println(result);
        return result;
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("accessKey", accessKey);
        // 一定不能直接发送
//        headerMap.put("secretKey", secretKey);
        headerMap.put("nonce", RandomUtil.randomNumbers(4));
        headerMap.put("body", body);
        headerMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        headerMap.put("sign", getSign(body, secretKey));
        return headerMap;
    }

    public String getUserNameByPost(@RequestBody User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/").charset(StandardCharsets.UTF_8).addHeaders(getHeaderMap(json)).body(json).execute();
        return httpResponse.body();
    }
}
