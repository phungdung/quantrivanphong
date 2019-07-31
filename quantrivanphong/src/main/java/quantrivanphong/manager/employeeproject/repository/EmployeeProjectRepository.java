package quantrivanphong.manager.employeeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quantrivanphong.models.EmployeeProjectModels;

import java.util.List;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProjectModels,Integer> {
    List<EmployeeProjectModels> findByProjectId(Integer projectId);
    EmployeeProjectModels findEprojectById(Integer eProjectId);
}
