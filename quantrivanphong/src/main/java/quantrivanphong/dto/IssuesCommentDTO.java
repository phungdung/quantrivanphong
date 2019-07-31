package quantrivanphong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quantrivanphong.dto.IssueDTO;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuesCommentDTO {
    private Integer id;
    private String contentIssuse;
    private String userCreate;
    private Timestamp createDate;
    private Integer issueId;
    private IssueDTO issue;
}
