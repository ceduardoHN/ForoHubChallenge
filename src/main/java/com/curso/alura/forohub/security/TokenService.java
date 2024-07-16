package com.curso.alura.forohub.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.curso.alura.forohub.models.User;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private static final String SECRET_KEY = "E2s4T6u8V0w1X3yd5Z7a9B1c3D5e7F9u";

    public String generarTokenPrueba(){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.create()
                    .withIssuer("ForoHub")
                    .withSubject("mago")
                    .sign(algorithm);
        }
        catch(JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String generarToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.create()
                    .withIssuer("ForoHub")
                    .withSubject(user.getUserName())
                    .withClaim("idUser", user.getIdUser())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
