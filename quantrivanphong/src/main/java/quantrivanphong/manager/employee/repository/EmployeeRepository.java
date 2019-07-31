package quantrivanphong.manager.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import quantrivanphong.models.EmployeeModels;

@Transactional(rollbackFor = Exception.class)
public interface EmployeeRepository extends JpaRepository<EmployeeModels,Integer> {
    EmployeeModels findEmployeeById(Integer employeeId);
    EmployeeModels findByUsername(String username);
}
