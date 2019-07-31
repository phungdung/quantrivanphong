//package quantrivanphong.security;
//
//import io.jsonwebtoken.Jwts;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class AuthorizationFilter extends BasicAuthenticationFilter {
//
//    private Logger logger = Logger.getLogger(AuthorizationFilter.class);
//
//    public AuthorizationFilter(AuthenticationManager authManager) {
//        super(authManager);
//    }
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response, FilterChain chain)
//                                    throws IOException, ServletException {
//        String header = request.getHeader(SecurityConstants.HEADER_STRING);
//        if(header==null||!header.startsWith(SecurityConstants.TOKEN_PREFIX)){
//            chain.doFilter(request,response);
//            return;
//        }
//        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        chain.doFilter(request,response);
//    }
//
//
//
//    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
//        String token = request.getHeader(SecurityConstants.HEADER_STRING);
//        if(token!=null){
//            token = token.replace(SecurityConstants.TOKEN_PREFIX,"");
//            String user = getUsername(token);
//            if(user!=null){
//                try{
////                UserDetails userDetails = userDetailsService.loadUserByUsername(user);
////                return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//                return new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
//                }catch (Exception e){
//                    logger.info("Lỗi "+e.getMessage());
//                }
//            }
//        }
//        return null;
//    }
//    public String getUsername(String token) {
//        return Jwts.parser()
//                .setSigningKey(SecurityConstants.TOKEN_SECRET)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//}
