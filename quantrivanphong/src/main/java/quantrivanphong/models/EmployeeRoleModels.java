package quantrivanphong.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_role")
public class EmployeeRoleModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "licensed", nullable = false)
    private boolean licensed;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmployeeModels employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private RoleModels role;
}
