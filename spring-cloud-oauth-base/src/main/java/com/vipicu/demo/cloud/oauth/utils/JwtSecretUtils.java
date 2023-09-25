package com.vipicu.demo.oauth.utils;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;

/**
 * JWT保密程序
 *
 * @author Lee
 * @since 1.0.0
 */
public final class JwtSecretUtils {

    public static final String KEY_ID = UUID.randomUUID().toString();


    /**
     * 生成rsa密钥
     *
     * @return {@link KeyPair}
     */
    public static KeyPair generateRsaKey() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return keyPair;
    }

    /**
     * 读取公钥
     *
     * @param bytes 字节
     * @return {@link PublicKey}
     */
    @SneakyThrows
    public static RSAPublicKey readReaPublicKey(byte[] bytes) {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(bytes));
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }


    /**
     * 读取私钥
     *
     * @param bytes 字节
     * @return {@link PrivateKey}
     */
    @SneakyThrows
    public static RSAPrivateKey readRsaPrivateKey(byte[] bytes) {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(bytes));
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    /**
     * 保存公钥
     *
     * @param path      路径
     * @param publicKey 公钥
     */
    public static void savePublicKey(String path, PublicKey publicKey) {
        saveFile(Base64.getEncoder().encode(publicKey.getEncoded()), path);
    }

    /**
     * 保存私钥
     *
     * @param path       路径
     * @param privateKey 私钥
     */
    public static void savePrivateKey(String path, PrivateKey privateKey) {
        saveFile(Base64.getEncoder().encode(privateKey.getEncoded()), path);
    }

    @SneakyThrows
    private static void saveFile(byte[] data, String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(data);
        }
    }

}
