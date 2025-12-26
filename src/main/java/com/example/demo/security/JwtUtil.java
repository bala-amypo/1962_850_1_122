// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import java.nio.charset.StandardCharsets;
// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtUtil {

//     private static final String SECRET =
//             "mySuperSecretKey12345678901234567890123456789012";

//     private static final long EXPIRATION_MILLIS = 86400000L;

//     private final Key key;

//     public JwtUtil() {
//         this.key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
//     }

//     public String generateToken(Long userId, String email, String role) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             extractAllClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String extractEmail(String token) {
//         return extractAllClaims(token).getSubject();
//     }

//     public String extractRole(String token) {
//         return extractAllClaims(token).get("role", String.class);
//     }

//     public Long extractUserId(String token) {
//         return extractAllClaims(token).get("userId", Long.class);
//     }

//     private Claims extractAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }






// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import javax.crypto.SecretKey;
// import java.util.Date;

// @Component
// public class JwtUtil {

//     private final SecretKey key;
//     private final long expirationMillis;

//     public JwtUtil(@Value("${jwt.secret}") String secretKey, 
//                    @Value("${jwt.expiration}") long expirationMillis) {
//         this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
//         this.expirationMillis = expirationMillis;
//     }

//     public String generateToken(String email, String role, Long userId) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("role", role)
//                 .claim("userId", userId)
//                 .claim("email", email)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
//                 .signWith(key)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }

//     public String extractEmail(String token) {
//         return getClaims(token).get("email", String.class);
//     }

//     public String extractRole(String token) {
//         return getClaims(token).get("role", String.class);
//     }

//     public Long extractUserId(String token) {
//         return getClaims(token).get("userId", Long.class);
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     } }
// 
package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "mySecretKeyMySecretKeyMySecretKeyMySecretKey";
    private final long EXPIRATION_MILLIS = 86400000;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Version for Long (satisfies test line 46)
    public String generateToken(Long userId, String email, String role) {
        return buildToken(String.valueOf(userId), email, role);
    }

    // Version for String (satisfies test line 416/417 logic)
    public String generateToken(String email, String role, Long userId) {
        return buildToken(String.valueOf(userId), email, role);
    }

    private String buildToken(String userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Boolean validateToken(String token) {
        try { return !isTokenExpired(token); } catch (Exception e) { return false; }
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // Returns Long (satisfies test line 52)
    public Long extractUserId(String token) {
        Object userId = extractAllClaims(token).get("userId");
        return Long.valueOf(String.valueOf(userId));
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}