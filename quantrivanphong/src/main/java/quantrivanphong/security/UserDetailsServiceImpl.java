//package quantrivanphong.security;
//import EmployeeRepositorys;
//import EmployeeRoleRepository;
//import EmployeeRepository;
//import EmployeeRole;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//
//    private static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);
//
//    @Autowired
//    private EmployeeRepositorys employeeRepositorys;
//
//    @Autowired
//    private EmployeeRoleRepository employeeRoleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
//        EmployeeRepository userModels = employeeRepositorys.findEmployeeByUsername(user);
//        if (userModels == null) {
//            logger.info("User not found!" + user);
//            throw new UsernameNotFoundException("User " + user + " was not found in the database");
//        }
//        List<String> lstRole = findRoleNameByUserId(userModels.getId());
//
//        List<GrantedAuthority> lstGrant = new ArrayList<GrantedAuthority>();
//        if (!lstRole.isEmpty() && lstRole.size() != 0) {
//            for (String role : lstRole) {
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                lstGrant.add(authority);
//            }
//        }
//        UserDetails userDetails = (UserDetails) new User(userModels.getUsername(), encrytePassword(userModels.getPassword()), lstGrant);
//        return userDetails;
//    }
////    Tìm kiếm Danh sách Role theo userId
//    public List<String> findRoleNameByUserId(Integer userId) {
//        List<String> lst = new ArrayList<String>();
//        List<EmployeeRole> lstUR = employeeRoleRepository.findByEmployeeId(userId);
//        for (EmployeeRole employeeRole:lstUR) {
//            lst.add(employeeRole.getRole().getRoleCode());
//        }
//        return lst;
//    }
//    public String encrytePassword(String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.encode(password);
//    }
//}
