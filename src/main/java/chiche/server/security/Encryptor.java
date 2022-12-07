package chiche.server.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encryptor {

    /**
     * Retorna un hash para el texto plano ingresado
     * @param data - Información a encriptar
     * @return - Hash en String
     */
    public String encrypt(String data){
        return BCrypt.hashpw(data, BCrypt.gensalt(10));
    }

    /**
     * Compara un hash encriptado con el método encrypt y retorna true o false según coincidan
     * @param password - Texto plano 
     * @param encryptedData - Hash a comparar con el texto plano
     * @return - True or False
     */
    public Boolean validate(String password, String encryptedData){
        return BCrypt.checkpw(password, encryptedData);
    }

}
