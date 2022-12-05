package chiche.server.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encryptor {

    public String encrypt(String data){
        return BCrypt.hashpw(data, BCrypt.gensalt(10));
    }

    public Boolean validate(String password, String encryptedData){
        return BCrypt.checkpw(password, encryptedData);
    }

}
