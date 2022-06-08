package com.imcd.evaluation.jwt.provider;

import com.imcd.evaluation.code.ErrorCode;
import com.imcd.evaluation.code.Role;
import com.imcd.evaluation.exception.JwtRuntimeException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.Optional;

import static com.imcd.evaluation.code.ErrorCode.*;

@Slf4j
@Component
public class JwtAuthProvider {
    @Value("${my.secretKey}")
    private String secretKey;
    private Key key;
    @Setter
    private String token;


    //토큰 만료시간 1분
    private final static long tokenExpiredTime = 60;

    @PostConstruct
    protected void init() {
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public Optional<String> createJwtAuthToken(String userId, Role role) {
        final ZonedDateTime now = ZonedDateTime.now();
        var token = Jwts.builder()
                .setSubject("access_token")
                .claim("userId", userId)
                .claim("role", role)
                .signWith(key, SignatureAlgorithm.HS256)
                .setIssuedAt(Date.from(now.toInstant()))
                .setExpiration(Date.from(now.toInstant().plusSeconds(tokenExpiredTime)))
                .compact();

        return Optional.ofNullable(token);
    }

    public boolean validate() {
        return getData() != null;
    }

    public Claims getData() {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (SecurityException e) {
            throw new JwtRuntimeException(INVALID_JWT_SIGNATURE);
        } catch (MalformedJwtException e) {
            throw new JwtRuntimeException(MALFORMED_JWT_TOKEN);
        } catch (ExpiredJwtException e) {
            throw new JwtRuntimeException(EXPIRED_JWT_TOKEN);
        } catch (UnsupportedJwtException e) {
            throw new JwtRuntimeException(UNSUPPORTED_JWT_TOKEN);
        } catch (IllegalArgumentException e) {
            throw new JwtRuntimeException(INVALID_JWT_COMPACT);
        }
    }
}
