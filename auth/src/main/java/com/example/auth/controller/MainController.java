package com.example.auth.controller;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @RequestMapping("/hello")
    public Object hello() {
        Map<String, String> result = new HashMap<>();
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        Map<String, Object> claims = new HashMap<String, Object>();//创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        claims.put("uid", "DSSFAWDWADAS...");
        claims.put("user_name", "admin");
        claims.put("nick_name", "DASDA121");
        JwtBuilder builder = Jwts.builder()
                .setId("id100")                                      // JWT_ID
                .setAudience("czp")                                // 接受者
                .setClaims(null)                                // 自定义属性
                .setSubject("czpSub")                                 // 主题
                .setIssuer("czpIss")                                  // 签发者
                .setIssuedAt(new Date())                        // 签发时间
                .setNotBefore(new Date())                       // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))                                // 过期时间
                .signWith(signatureAlgorithm, secretKey);           // 签名算法以及密匙
        result.put("jwt", builder.compact());
        return result;
    }

    @RequestMapping("/auth")
    public Object hello2(@RequestHeader("Authorization") String auth) {
        Map<String, String> result = new HashMap<>();
        if (auth == null) {
            result.put("msg","fuck");
        } else {
            result.put("msg","nice");
        }
        return result;
    }

    public SecretKey generalKey() {
        byte[] encodedKey = Base64.decode("sss1");
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}
