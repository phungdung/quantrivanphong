//package quantrivanphong.security;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Date;
//
//public class SecurityConstants {
//    @Autowired
//    private static UserDetailsServiceImpl userDetailsService;
//
//    public static final String Member = "Member";
//    public static final String TeamLead = "TeamLead";
//    public static final String Manager = "Manager";
//    public static final String HR = "HR";
//
//    public static final long EXPIRATION_TIME = 860000;
//    public static final String TOKEN_PREFIX ="Bearer ";
//    public static final String HEADER_STRING ="Authorization";
//    public static final String TOKEN_SECRET ="jf9i4jgu83nfl10";
//
//
//    public static String getToken(String userName){
//        String token = Jwts.builder()
//                .setSubject(userName).setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
//                .compact();
//        return token;
//    }
//}
