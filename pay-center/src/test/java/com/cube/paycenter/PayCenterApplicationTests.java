package com.cube.paycenter;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayCenterApplicationTests {
    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void contextLoads() {
        String url = "jdbc:mysql://rm-j6czx391hc17h46nr.mysql.rds.aliyuncs.com:3306/ub_ex1?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
        String username ="root";
        String password = "Aa1234567890woshinidaye";

        String redisUrl = "r-j6cd05966b2f3574.redis.rds.aliyuncs.com";
        String redisPwd = "Aa1234567890woshinidaye";

        String encryptUrl = encryptor.encrypt(url);
        String encryptusername = encryptor.encrypt(username);
        String encryptPwd = encryptor.encrypt(password);
        String encryptRedisUrl = encryptor.encrypt(redisUrl);
        String encryptredisPwd = encryptor.encrypt(redisPwd);
        System.out.println("密钥："+"bfcb82076aa849588389c7eb121d6af2");
        System.out.println("url加密:" + "ENC("+encryptUrl+")");
        System.out.println("username加密:" + "ENC("+encryptusername+")");
        System.out.println("password加密:" + "ENC("+encryptPwd+")");
        System.out.println("redisUrl加密:" + "ENC("+encryptRedisUrl+")");
        System.out.println("redisPwd加密:" + "ENC("+encryptredisPwd+")");

        System.out.println("=============================================");
        System.out.println("解密url：" + encryptor.decrypt(encryptUrl));
        System.out.println("解密username：" + encryptor.decrypt(encryptusername));
        System.out.println("解密password：" + encryptor.decrypt(encryptPwd));
        System.out.println("解密redisUrl：" + encryptor.decrypt(encryptRedisUrl));
        System.out.println("解密redisPwd：" + encryptor.decrypt(encryptredisPwd));

    }

    @Test
    public void generateUUID(){
        String key = UUID.randomUUID().toString().replace("-","");
        System.out.println(key);
    }

}
