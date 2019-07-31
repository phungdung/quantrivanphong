package quantrivanphong.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class ProjectModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;


    //    tên project
    @Column(name = "name", nullable = false)
    private String name;
    //mô tả ngắn
    @Column(name = "descriptions")
    private String descriptions;
    //ngày bắt đầu của dự án
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    //ngày kết thúc dự án
    @Column(name = "end_date")
    private Timestamp endDate;
    //trạng thái
    @Column(name = "status",nullable = false)
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmployeeProjectModels> eprojectList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IssuesModels> issuesList  = new ArrayList<>();
}
