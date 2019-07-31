package quantrivanphong.access.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import quantrivanphong.dto.EmployeeDTO;
import quantrivanphong.models.EmployeeModels;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface LoginRepository extends JpaRepository<EmployeeModels,Integer> {
    EmployeeModels findEmployeeModelsByUsernameAndPassword(String username,String password);
}
