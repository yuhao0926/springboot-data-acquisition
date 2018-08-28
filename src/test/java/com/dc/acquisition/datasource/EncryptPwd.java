package com.dc.acquisition.datasource;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;

public class EncryptPwd {
 
    @Test
    public void encryptPwd() {
    	BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("dataacquisition");
        String encrypted = encryptor.encrypt("yh159753mysql");
        System.out.println(encrypted);
        System.out.println(encryptor.decrypt(encrypted));
    }
}
