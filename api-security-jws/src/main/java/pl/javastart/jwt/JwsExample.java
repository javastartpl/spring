package pl.javastart.jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;

import java.text.ParseException;
import java.util.UUID;

class JwsExample {
    public static void main(String[] args) throws JOSEException, ParseException {
        String payloadContent = "Dowolny komunikat, który chcemy podpisać";
        String privateKey = UUID.randomUUID().toString();
        System.out.printf("Private key: %s%n", privateKey);
        JWSObject simpleJws = createSimpleJws(payloadContent, privateKey);
        String serializedJws = simpleJws.serialize();
        System.out.printf("Serialized Jws: %n%s%n", serializedJws);
        System.out.println("Verifying signature...");
        boolean verified = verifySimpleJws(serializedJws, privateKey);
        if (verified) {
            System.out.println("Valid Signature");
        } else {
            System.out.println("Invalid Signature");
        }
    }

    static JWSObject createSimpleJws(String payloadContent, String privateKey) throws JOSEException {
        JWSAlgorithm algorithm = JWSAlgorithm.HS256;
        JWSHeader header = new JWSHeader(algorithm);
        Payload payload = new Payload(payloadContent);
        JWSSigner jwsSigner = new MACSigner(privateKey);
        JWSObject jwsObject = new JWSObject(header, payload);
        jwsObject.sign(jwsSigner);
        return jwsObject;
    }

    static boolean verifySimpleJws(String jws, String privateKey) throws JOSEException, ParseException {
        JWSVerifier jwsVerifier = new MACVerifier(privateKey);
        JWSObject jwsObject = JWSObject.parse(jws);
        return jwsObject.verify(jwsVerifier);
    }
}
