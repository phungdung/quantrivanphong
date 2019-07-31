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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issues")
public class IssuesModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    // tiêu đề liên quan
    @Column(name = "title")
    private String title;
    //nội dung
    @Column(name = "content")
    private String actionCode;
    // trạng thái vấn đề đó trong project
    @Column(name = "status")
    private int status;

    @Column(name = "startdate")
    private Timestamp startDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProjectModels project;

    @JsonIgnore
    @OneToMany(mappedBy = "issues", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IssuesCommentModels> issuesCommentList  = new ArrayList<IssuesCommentModels>();
}
