package quantrivanphong.access.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import quantrivanphong.models.EmployeeModels;

import java.util.List;

public interface RegisterRepository extends JpaRepository<EmployeeModels,Integer> {
    @Query(value = "SELECT email_address from employee where email_address =?1",nativeQuery = true)
    String findEmailByEmail(String email);

    @Query(value = "select username from employee where username =:username",nativeQuery = true)
    List<String> findUserNameByUserName(String username);
}
