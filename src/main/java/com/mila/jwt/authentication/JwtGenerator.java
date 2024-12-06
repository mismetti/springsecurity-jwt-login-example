package com.mila.jwt.authentication;

import com.mila.jwt.user.User;
import com.mila.jwt.util.LocalDateTimeUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class JwtGenerator {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(User user){

        var now = LocalDateTime.now();

        return Jwts.builder()
                .claims()
                .subject(user.getUsername())
                .issuedAt(LocalDateTimeUtils.toDate(now))
                .expiration(LocalDateTimeUtils.toDate(now.plusHours(1L)))
                .and()
                .signWith(getSignKey())
                .compact();

    }

    private SecretKey getSignKey() {
        byte[] secretKeyEncoded = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeyEncoded);
    }



}
