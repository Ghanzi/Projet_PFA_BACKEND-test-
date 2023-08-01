package com.gestion.stage1.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

@Component
public class JwtTokenVerifier {

    @Value("${publicKey}")
    public String publicKey;

    public boolean isTokenValid(String token) {
        try {
            if (token != null) {
                buildJWTVerifier().verify(token.replace("Bearer ", ""));
                // if the token is valid, no exception will be thrown
                return true;
            } else {
                // Handle the case when the token is null
                return false;
            }
        } catch (JWTVerificationException e) {
            // if the JWT token is invalid
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            // If any other exception occurs
            e.printStackTrace();
            return false;
        }
    }


    private JWTVerifier buildJWTVerifier() throws CertificateException {
        var algo = Algorithm.RSA256(getRSAPublicKey());
        return JWT.require(algo).build();
    }

    private RSAPublicKey getRSAPublicKey() throws CertificateException {
        var decode = Base64.getMimeDecoder().decode(publicKey);
        var certificate = CertificateFactory.getInstance("X.509")
                .generateCertificate(new ByteArrayInputStream(decode));
        return (RSAPublicKey) certificate.getPublicKey();
    }
}
