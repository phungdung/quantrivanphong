package quantrivanphong.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issues_comment")
public class IssuesCommentModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    //nội dung
    @Column(name = "content")
    private String contentIssuse;

    @Column(name = "usercreate")
    private String userCreate;

    @Column(name = "createdate")
    private Timestamp createDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private IssuesModels issues;
}
