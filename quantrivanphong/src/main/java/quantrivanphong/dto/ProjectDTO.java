package quantrivanphong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Integer id;
    //    tên project
    private String name;
    //mô tả ngắn
    private String descriptions;
    //ngày bắt đầu của dự án
    private Timestamp startDate;
    //ngày kết thúc dự án
    private Timestamp endDate;
    //trạng thái thêm vào dataBase
    private Integer status;
//    danh sách id
    private Integer[] ids;
}
