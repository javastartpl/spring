package pl.javastart.jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

class SignedJwtExample {
    public static void main(String[] args) throws JOSEException, ParseException {
        String privateKey = UUID.randomUUID().toString();
        System.out.printf("Private key: %s%n", privateKey);
        JWTClaimsSet payload = createPayload();
        SignedJWT signedJwt = createSignedJwt(payload, privateKey);
        String serializedJwt = signedJwt.serialize();
        System.out.printf("Serialized JWT: %n%s%n", serializedJwt);
        System.out.println("Verifying signature...");
        boolean verified = verifySignedJwt(serializedJwt, privateKey);
        if (verified) {
            System.out.println("Valid Signature");
        } else {
            System.out.println("Invalid Signature");
        }
    }

    static JWTClaimsSet createPayload() {
        LocalDateTime nowPlus1Hour = LocalDateTime.now().plusHours(1);
        Date expirationDate = Date.from(nowPlus1Hour.atZone(ZoneId.systemDefault()).toInstant());
        return new JWTClaimsSet.Builder()
                .subject("john@javastart.pl")
                .expirationTime(expirationDate)
                .claim("role", "USER")
                .build();
    }

    static SignedJWT createSignedJwt(JWTClaimsSet jwtPayload, String privateKey) throws JOSEException {
        JWSAlgorithm algorithm = JWSAlgorithm.HS256;
        JWSHeader header = new JWSHeader(algorithm);
        JWSSigner jwsSigner = new MACSigner(privateKey);
        SignedJWT signedJWT = new SignedJWT(header, jwtPayload);
        signedJWT.sign(jwsSigner);
        return signedJWT;
    }

    static boolean verifySignedJwt(String compactJwt, String privateKey) throws ParseException, JOSEException {
        SignedJWT signedJwt = SignedJWT.parse(compactJwt);
        JWSVerifier jwsVerifier = new MACVerifier(privateKey);
        return signedJwt.verify(jwsVerifier);
    }
}
