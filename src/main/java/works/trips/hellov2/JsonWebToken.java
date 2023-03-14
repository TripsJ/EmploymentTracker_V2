package works.trips.hellov2;


import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JsonWebToken {
	private static String SECRET_KEY = "randomldsldqjfqdkqslhqksjhqsxfgdeiflskfsjqlskùdj";
	
	public static String create(String username, String role, Long id) {
		Instant currentTime = Instant.now();
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Key signingKey;
		try {
			signingKey = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), signatureAlgorithm.getJcaName());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR In Key Generation";
		}
		String jws = Jwts.builder()
				  .setIssuer("EmploymentApp")
				  .setSubject("Authentication")
				  .claim("username", username)
				  .claim("role", role)
				  .claim("id", id)
				  .setIssuedAt(Date.from(currentTime))
				  .setExpiration(Date.from(currentTime.plus(5l, ChronoUnit.MINUTES)))
				  .signWith(signingKey)
				  .compact();
		return jws;
	}
	
	
	
	private static Claims decodeJWT(String jwt) {
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parserBuilder().setSigningKey(Base64.getEncoder().encodeToString(SECRET_KEY.getBytes())).build().parseClaimsJws(jwt).getBody();
	    return claims;
	}
	

	
	public static String getUsername(String token) {
		return (String) decodeJWT(token).get("username");
	}
	
	public static String getRole(String token) {
		return  (String) decodeJWT(token).get("role");	
	}
	
	public static Integer getId(String token) {
	    return (Integer) decodeJWT(token).get("id");
	}
	
	public static boolean verifyJwtSignature(String jwtString) {
	        boolean isValid = false;

	        try {
	            Jwts.parser()
	                    .setSigningKey(SECRET_KEY.getBytes())
	                    .parseClaimsJws(jwtString);
	            isValid = true;
	        } catch (JwtException e) {
	            // Handle invalid JWT signature exception
	        }

	        return isValid;
	    }





	
	
}
