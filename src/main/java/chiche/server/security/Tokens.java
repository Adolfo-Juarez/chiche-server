package chiche.server.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Tokens {

    private final static String SECRET_KEY =
            // Por seguridad, cambia tu palabra secreta de abajo para firmar tus tokens
            // Debe tener mímo 256 bits (Al rededor de 64 de carácteres) para evitar
            // cualquier error
            // al momento de auténtica tu firma.
            "1234567890123456789012345678901234567890123456789012345678901234";

    /**
     * 
     * Genera un token bajo el algoritmo HS256 con subject, issuer, id y tiempo de
     * vida especificado.
     * 
     * @param id       - Indentificador único para tu token.
     * @param subject  - A quién hace referencia el token.
     * @param issuer   - Quién creo y firmó este token.
     * @param lifeTime - Tiempo de vida desde la creación en token (en
     *                 milisegundos).
     * @return - String del token generado y firmado.
     */
    public String generateToken(String id, String subject, String issuer, Long lifeTime) {

        // Definimos el algoritmo de encriptación
        // NOTA: Según el algoritmo, se usan más o menos carácteres u otros
        // parámetros para generar el token!
        // Más información:
        // https://datatracker.ietf.org/doc/html/draft-ietf-jose-json-web-algorithms-31
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;

        // La fecha en la que se crea en milisegundos
        long nowInMiliseconds = System.currentTimeMillis();

        // La fecha de creación en tipo Date
        Date now = new Date(nowInMiliseconds);

        // Recuperamos los bytes de la SECRET KEY
        byte[] BytesSecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);

        // Codificamos una llave para firmar los tokens con los bytes de la
        // SECRET KEY y el tipo de algoritmo de encriptación
        Key signKey = new SecretKeySpec(BytesSecretBytes, algorithm.getJcaName());

        // Empezamos a construir nuestro token
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signKey);

        // Sumamos los milisegundos de tiempo de vida a los milisegundos de su
        // fecha de creación.
        long lifeTimeMiliseconds = nowInMiliseconds + lifeTime;

        // Obtenemos el la fecha y hora de expiración el token en
        // formato Date
        Date expireDate = new Date(lifeTimeMiliseconds);

        // Añadimos su expiiración al constructor
        builder.setExpiration(expireDate);

        // Cerramos el constructor y regresamos el token con todos los datos y firmado
        return builder.compact();
    }

    /**
     * Valida el token dado y regresa un claim, con el cuál podemos acceder a sus
     * propiedades por medio de sus métodos
     * 
     * @param token - String del token a validar
     * @return - Claim ó un Exception en caso de no tener la firma correcta, o el
     *         toke haya expirado
     */
    public Boolean validate(String token) {
        try {

            Jwts.parserBuilder() // Abrimos el contructor para decodificar el token
                    .setSigningKey(SECRET_KEY) // Asignamod la SECRET KEY para validar la firma
                    .build() // Cerramos el constructor
                    .parseClaimsJws(token) // Pasamos nuestro token
                    .getBody(); // Tratamos de obtener su contenido

            return true;

        } catch (JwtException e) {

            return false;

        }

    }

    public String readPrivilegies(String token){
        return Jwts.parserBuilder()
                            .setSigningKey(SECRET_KEY)
                            .build()
                            .parseClaimsJws(token)
                            .getBody()
                            .getSubject();
    }


    public Long readId(String token){
        return Long.parseLong(Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getId());
    }

}
