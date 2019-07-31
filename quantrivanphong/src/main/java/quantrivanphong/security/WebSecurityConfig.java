//package quantrivanphong.security;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//// xác định lớp WebSecurityConfig của ta là một lớp dùng để cấu hình.
//@Configuration
////tích hợp Spring Security với Spring MVC.
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //     interface UserDetailsService để cấu hình
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    //
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    //
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
////        các trang không yêu cầu login
//        http
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .antMatchers(HttpMethod.POST, "/register/dang-ky-tai-khoan").permitAll()
//                .antMatchers(HttpMethod.GET, "/homepage/**").permitAll()
////        các trang yêu cầu login
//                .antMatchers("/api/EmployeeTimekeeping/**").hasAnyRole(SecurityConstants.Member, SecurityConstants.Manager, SecurityConstants.TeamLead, SecurityConstants.HR)
//                .antMatchers(HttpMethod.GET, "/api/quan-ly/danh-sach-xin-phep").hasRole(SecurityConstants.TeamLead)
//                .antMatchers("/api/quan-ly/**").hasAnyRole(SecurityConstants.Manager, SecurityConstants.HR)
//                .anyRequest().authenticated()
//                .and().addFilter(getAuthenticationFilter())
//                .addFilter(new AuthorizationFilter(authenticationManager()));
//    }
////    đổi tên cổng login
//    public AuthenticationFilter getAuthenticationFilter() throws Exception{
//        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
//        filter.setFilterProcessesUrl("/quan-tri-van-phong/login");
//        return filter;
//    }
//}
//
