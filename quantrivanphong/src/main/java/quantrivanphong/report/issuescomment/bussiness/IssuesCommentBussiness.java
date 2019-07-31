package quantrivanphong.report.issuescomment.bussiness;

import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.IssuesCommentDTO;

import java.util.List;

public interface IssuesCommentBussiness {
//    danh sách comment của issues
    List<IssuesCommentDTO> getListComment(Integer issuesId);
    WrapperResult createComment(IssuesCommentDTO dto);
    WrapperResult updateComment(IssuesCommentDTO dto);
    WrapperResult deleteComment(IssuesCommentDTO dto);
    IssuesCommentDTO findIssuesCommentById(Integer id);
}
