package quantrivanphong.report.issues.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.models.IssuesModels;
import quantrivanphong.report.issues.bussiness.IssueBussiness;
import quantrivanphong.dto.IssueDTO;

@RestController
public class IssueController {
    @Autowired
    private IssueBussiness issueBussiness;

    @GetMapping(value = "/danh-sach-issues")
    public ResponseEntity getAllIssue(){
        return ResponseEntity.ok(issueBussiness.getAllIssue());
    }
    @GetMapping(value = "/chi-tiet-issues/{id}")
    public ResponseEntity getIssueById(@PathVariable("id")Integer id){
        IssuesModels issues = issueBussiness.findIssueById(id);
        if(issues!=null){
            return ResponseEntity.ok(issues);
        }
        return ResponseEntity.ok("Issues không tồn tại");
    }
    @PostMapping(value = "/them-issues")
    public ResponseEntity saveIssue(@RequestBody IssueDTO issueDTO){
        WrapperResult wrapperResult = issueBussiness.saveIssue(issueDTO);
        return ResponseEntity.ok(wrapperResult);
    }
    @PutMapping(value = "/sua-issues")
    public ResponseEntity editIssue(@RequestBody IssueDTO issueDTO){
        WrapperResult wrapperResult = issueBussiness.updateIssue(issueDTO);
        return ResponseEntity.ok(wrapperResult);
    }
    @DeleteMapping(value = "/xoa-issues")
    public ResponseEntity deleteIssue(@RequestBody IssueDTO issueDTO){
        WrapperResult wrapperResult = issueBussiness.deleteIssue(issueDTO);
        return ResponseEntity.ok(wrapperResult);
    }
}
