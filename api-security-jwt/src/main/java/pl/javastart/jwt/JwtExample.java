package pl.javastart.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.PlainJWT;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

class JwtExample {
    public static void main(String[] args) throws JOSEException {
        PlainJWT plainJwt = createJwt();
        System.out.println(plainJwt.serialize());
    }

    static PlainJWT createJwt() {
        LocalDateTime now = LocalDateTime.now();
        Date nowDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime nowPlus1Hour = now.plusHours(1);
        Date expirationDate = Date.from(nowPlus1Hour.atZone(ZoneId.systemDefault()).toInstant());
        JWTClaimsSet claimSet = new JWTClaimsSet.Builder()
                .subject("john@javastart.pl")
                .issueTime(nowDate)
                .expirationTime(expirationDate)
                .claim("role", "USER")
                .build();
        return new PlainJWT(claimSet);
    }
}
