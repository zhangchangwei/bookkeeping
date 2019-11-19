package com.book.keeping.bookkeeping.common;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @date 2019/3/15 18:10
 */
@Slf4j
public class AesOperator {

    private static final String AES_KEY = "4t5354t56yt9o8ik";
    private static final String AES_ASCII = "ASCII";
    private static final String AES_ALGORITHM = "AES";
    private static final String AES_CIPHER_ALGORITHM = "AES/GCM/PKCS5Padding";

    private static volatile AesOperator aesOperator;

    private AesOperator() {
    }

    public static AesOperator getInstance() {
        if (aesOperator == null) {
            synchronized (AesOperator.class) {
                if (aesOperator == null) {
                    aesOperator = new AesOperator();
                }
            }
        }
        return aesOperator;
    }

    public String encrypt(String sSrc) throws Exception {
        String result;
        try {
            //AES加密算法需要与安全模式一起使用
            byte[] raw = AES_KEY.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, AesOperator.AES_ALGORITHM);
            Cipher cipher= Cipher.getInstance(AES_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] iv = cipher.getIV();
            byte[]  encryptData = cipher.doFinal(sSrc.getBytes());
            byte[] message = new byte[12 + sSrc.getBytes().length + 16];
            System.arraycopy(iv, 0, message, 0, 12);
            System.arraycopy(encryptData, 0, message, 12, encryptData.length);
            result = Base64.getEncoder().encodeToString(message);
        } catch (Exception e) {
            throw new Exception();
        }
        // 此处使用BASE64做转码。
        return result;

    }

    public String decrypt(String sSrc) {
        try {
            byte[] raw = AES_KEY.getBytes(AES_ASCII);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, AesOperator.AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
            // 先用base64解密
            byte[] message = Base64.getDecoder().decode(sSrc);
            GCMParameterSpec params = new GCMParameterSpec(128, message, 0, 12);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, params);
            byte[]  decryptData = cipher.doFinal(message, 12, message.length - 12);
            return new String(decryptData);
        } catch (Exception ex) {
            log.info(ex.getMessage());
            return null;
        }
    }
}
