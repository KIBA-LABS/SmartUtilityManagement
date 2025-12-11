//package customer.smartutilitymanagement.utils;
//
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.Map;
//
//@Component
//public class JwtUtils {
//
//    private final Key key;
//    private final long accessExpirationMs;
//    private final long refreshExpirationMs;
//
//    public JwtUtils(
//            @Value("${jwt.secret}") String secret,
//            @Value("${jwt.access-expiration-ms}") long accessExpirationMs,
//            @Value("${jwt.refresh-expiration-ms}") long refreshExpirationMs) {
//
//        this.key = Keys.hmacShaKeyFor(secret.getBytes());
//        this.accessExpirationMs = accessExpirationMs;
//        this.refreshExpirationMs = refreshExpirationMs;
//    }
//
//    public String generateAccessToken(String subject, Map<String, Object> claims) {
//        return Jwts.builder()
//                .setSubject(subject)
//                .addClaims(claims)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + accessExpirationMs))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String generateRefreshToken(String subject) {
//        return Jwts.builder()
//                .setSubject(subject)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + refreshExpirationMs))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public Jws<Claims> validate(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token);
//    }
//
//    public String getSubject(String token) {
//        return validate(token).getBody().getSubject();
//    }
//}
//
