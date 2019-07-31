package quantrivanphong.report.issues.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quantrivanphong.models.IssuesModels;

public interface IssueRepository extends JpaRepository<IssuesModels, Integer> {
    IssuesModels findIssuesById(Integer id);
}
