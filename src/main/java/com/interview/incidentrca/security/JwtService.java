package com.interview.incidentrca.security;
import com.interview.incidentrca.entity.User;import io.jsonwebtoken.*;import io.jsonwebtoken.security.Keys;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Component;import java.nio.charset.StandardCharsets;import java.time.*;import java.util.Date;
@Component public class JwtService{ @Value("${app.jwt.secret}") private String secret; @Value("${app.jwt.expiration-minutes}") private long minutes;
 public String generate(User user){Instant now=Instant.now();return Jwts.builder().subject(user.getEmail()).claim("role",user.getRole().name()).issuedAt(Date.from(now)).expiration(Date.from(now.plus(Duration.ofMinutes(minutes)))).signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8))).compact();}
 public String subject(String token){return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8))).build().parseSignedClaims(token).getPayload().getSubject();}
}
