package quantrivanphong.report.issuescomment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.report.issuescomment.bussiness.IssuesCommentBussiness;
import quantrivanphong.dto.IssuesCommentDTO;

import java.util.List;

@RestController
public class IssuesCommentControllers {
    @Autowired
    private IssuesCommentBussiness issuesCommentBussiness;

    @GetMapping(value = "/Comment/{IssuesId}")
    public ResponseEntity getComment(@PathVariable("IssuesId") Integer issuesId){
        List<IssuesCommentDTO> listComment = issuesCommentBussiness.getListComment(issuesId);
        return ResponseEntity.ok(listComment);
    }
    @PostMapping(value = "/tao-comment")
    public ResponseEntity saveComment(@RequestBody IssuesCommentDTO issuesCommentDTO){
        WrapperResult wrapperResult = issuesCommentBussiness.createComment(issuesCommentDTO);
        return ResponseEntity.ok(wrapperResult);
    }
}
