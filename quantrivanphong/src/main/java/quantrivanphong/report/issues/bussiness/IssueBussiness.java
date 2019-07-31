package quantrivanphong.report.issues.bussiness;

import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.models.IssuesModels;
import quantrivanphong.dto.IssueDTO;

import java.util.List;

public interface IssueBussiness {
    List<IssuesModels> getAllIssue();
    WrapperResult saveIssue(IssueDTO issueDTO);
    WrapperResult updateIssue(IssueDTO issueDTO);
    WrapperResult deleteIssue(IssueDTO issueDTO);
    IssuesModels findIssueById(Integer id);
}
