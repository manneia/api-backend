package com.luo.apiinterface.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.util.Map;

/**
 * @author lkx
 * @version 1.0.0
 * @Description 签名生成
 */
public class SignUtils {
    /**
     * @Description 生成签名
     * @param body 待生成值
     * @param secretKey 密钥
     * @return 返回签名
     */
    public static String getSign(String body, String secretKey) {
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        return digester.digestHex(content);

    }
}
