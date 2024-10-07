package com.logistic_warehouse.utils.enu.helpers;

import com.logistic_warehouse.domain.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTService {

    private final String SECRET_KEY = "bWljbGF2ZXN1cGVyc2VjcmV0YWVzbXV5c2VndXJhcGFyYXF1ZW5hZGllbGFhZHZpbmU=";

    public SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateJWT(Map<String, Object> claims, UserEntity user) {
        return Jwts.builder()
                .setClaims(claims)  // Cambiado de claims() a setClaims()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 100 * 60 * 60 * 24))
                .signWith(getKey())
                .compact();
    }


    public String getToken(UserEntity user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole().name());

        return generateJWT(claims, user);
    }

    public Claims getALlClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();


    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getALlClaims(token);
        return claimsResolver.apply(claims);
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

//    public Date getDateExpirationFromToken(String token) {
//        return getClaim(token,Claims::getExpiration);
//    }

//    public Boolean isTokenExpired(String token) {
//        return getDateExpirationFromToken(token).before(new Date());
//    }

//    public Boolean isTokenValid(String token, UserDetails userDetails) {
//        String username = getUsernameFromToken(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    public Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//    }
}
