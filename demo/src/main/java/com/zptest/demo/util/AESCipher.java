package com.zptest.demo.util;


import com.zptest.demo.exception.AesException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Key;

/**
 * Created by wzq on 2017/3/7.
 */
public class AESCipher {

    private static Charset CHARSET = Charset.forName("utf-8");
    /**
     * 加密
     */
    public static String encryptAES(String aesKey,String text) {
        try {
            Base64 base64 = new Base64();
            //实例化加密类，参数为加密方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            SecretKeySpec keySpec = new SecretKeySpec(aesKey.getBytes(CHARSET), "AES");
            //初始化向量参数，AES 为16bytes
            IvParameterSpec ivSpec = new IvParameterSpec(aesKey.getBytes(CHARSET));
            //初始化，可以采用三种方式，即第三个参数 1）无  2）为random随机数对象(不采用) 3）iv
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            //加密操作,返回加密后的字节数组，然后需要编码。主要编解码方式有Base64, HEX, UUE,7bit等等
            byte[] encrypted = cipher.doFinal(text.getBytes(CHARSET));
            return base64.encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(1000, "AES加密失败");
        }
    }

    /**
     * 解密
     */
    public static String decryptAES(String aesKey,String text) {
        try {
            Base64 base64 = new Base64();
            byte[] b = base64.decode(text);   //先用Base64解码

            IvParameterSpec ivSpec = new IvParameterSpec(aesKey.getBytes());
            Key key = new SecretKeySpec(aesKey.getBytes(CHARSET), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);    //与加密时不同MODE:Cipher.DECRYPT_MODE

            byte[] ret = cipher.doFinal(b);

            return new String(ret, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(1001, "AES解密失败");
        }
    }
}
