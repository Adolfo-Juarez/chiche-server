package chiche.server.utility;

public class TokensTransform {
    
    /**
     * Regresa el token eliminando el prefix Barier
     * @param token - String como viene en el header
     * @return - token
     */
    public String getToken(String token){
        StringBuffer rawToken = new StringBuffer(token);
        return rawToken.replace(0, 7, "").toString(). trim();  
    }

}
