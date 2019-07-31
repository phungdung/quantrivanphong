package quantrivanphong.report.issuescomment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quantrivanphong.models.IssuesCommentModels;

import java.util.List;

public interface IssuesCommentRepository extends JpaRepository<IssuesCommentModels,Integer> {
    List<IssuesCommentModels> findIssuesCommentByIssuesId(Integer issuesId);
    IssuesCommentModels findIssuesCommentById(Integer id);
}
