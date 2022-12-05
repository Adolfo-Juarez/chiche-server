package chiche.server.security;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Encryptor {

    public String encrypt(String data){
        return (BCrypt.with(BCrypt.Version.VERSION_2Y)
                .hashToChar(6, data.toCharArray()))
                .toString();
    }

    public Boolean validate(String password, String encryptedData){
        return BCrypt
                .verifyer()
                .verify(encryptedData.toCharArray(), 
                BCrypt.with(BCrypt.Version.VERSION_2Y)
                .hashToChar(6, password.toCharArray()))
                .verified;
    }

}
