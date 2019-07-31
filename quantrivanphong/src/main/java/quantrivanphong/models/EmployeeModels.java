package quantrivanphong.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "username", length = 128, nullable = false, unique = true)
    private String username;
    @Column(name = "password", length = 128)
    private String password;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "picture")
    private String picture;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "phone")
    private String phoneNumber;
//    @Column(name = "checked", nullable = false)
//    private boolean checked;
    @Column(name = "status", nullable = false)
    private boolean status;
    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmployeeRoleModels> employeeRoleList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmployeeProjectModels> eprojectList = new ArrayList<>();
}
