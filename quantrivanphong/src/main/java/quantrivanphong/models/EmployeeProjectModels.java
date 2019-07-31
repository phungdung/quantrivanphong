package quantrivanphong.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_project")
public class EmployeeProjectModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    // chức vụ trong project
    @Column(name = "position", nullable = false)
    private String position;
    //ngày vào dự án
    @Column(name = "join_date",nullable =false)
    private Timestamp joinDate;
    // ngày ra dự án
    @Column(name = "out_date",nullable = true)
    private Timestamp outDate;

    @Column(name = "status",nullable = false)
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmployeeModels employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectModels project;

}
