package quantrivanphong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjectDTO {
    private int id;
    // chức vụ trong project
    private String position;
    //ngày vào dự án
    private Timestamp joinDate;
    // ngày ra dự án
    private Timestamp outDate;
    private int status;
    private Integer userId;
    private Integer projectId;
    private String userName;
    private String nameProject;
    private EmployeeDTO employeeDTO;
    private ProjectDTO projectDTO;
}
