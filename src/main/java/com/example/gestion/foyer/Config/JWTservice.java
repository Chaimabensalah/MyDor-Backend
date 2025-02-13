package com.example.gestion.foyer.Config;

import com.example.gestion.foyer.Entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTservice {
    private static final String SECRE_KEY = "cxd8+rn4lIWl3XHGUsR5q8sbXk04BYKtPakDhd4CGYYVcdantBGMYCoZj5zvBlehJVBrh52vsnL5L/1B6FMhklMX2McIPv/Sz6I/e2cRQlXYlxgcymQGb8X+Fvz43rU8+/SPXsafX9qeTL8HeNlzVY4lLSKS4dcPdKE7dlWXrTWkrazKVXMqFP7Xt3bs4dIK7YKfARJyPRPEpEf+XzADf4qlmwvEwlOpsN/KnUmZXfbEEvroptPZ2rSmWaSpl0MD5gCbYcrV89Et4huEq9wSi7c5DxeRL3RNDEsK2rR6jTWcVclpDQqr1LRU/cPYRvZPuTOfIaz/AOH9JercQnqKLSM3O3hNoaBkqjMuo+haNf8";

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);

    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public <T> T extractClaims(String token, Function<Claims, T> getSubject) {
        final Claims claims = extractAllClaims(token);
        return getSubject.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigninKey())
                .build().parseClaimsJws(token).getBody();
    }

    public String generateToken(User user) {
        return generateToken(user, Map.of());
    }

    private String generateToken(User user, Map<String, Object> claims) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setId(user.getId().toString())
                .setSubject(user.getUsername().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 60 * 1000))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();


    }

    private Key getSigninKey() {
        byte[] KeyByte = Decoders.BASE64.decode(SECRE_KEY);
        return Keys.hmacShaKeyFor(KeyByte);
    }
}
