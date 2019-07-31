package quantrivanphong.manager.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quantrivanphong.models.ProjectModels;

public interface ProjectRepository extends JpaRepository<ProjectModels,Integer> {
    ProjectModels findProjectById(Integer id);
    ProjectModels findProjectByName(String nameProject);
    ProjectModels findByName(String nameProject);
    
}
