package quantrivanphong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quantrivanphong.dto.ProjectDTO;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {
    private Integer id;
    private String title;
    private String actionCode;
    private Timestamp startDate;
    private int status;
    private Integer projectId;
    private ProjectDTO projectDTO;
}
