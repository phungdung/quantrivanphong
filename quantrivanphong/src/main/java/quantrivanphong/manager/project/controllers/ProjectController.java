package quantrivanphong.manager.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quantrivanphong.common.SystemConstants;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.manager.project.bussiness.ProjectBussiness;
import quantrivanphong.dto.ProjectDTO;

@RestController
public class ProjectController {


    @Autowired
    private ProjectBussiness projectBussiness;

    @GetMapping(value = "/danh-sach-du-an")
    public ResponseEntity getAllProject(){
        return ResponseEntity.ok(projectBussiness.findAllProject());
    }
    @GetMapping(value = "/danh-sach-du-an/{page}/{pageSize}")
    public ResponseEntity getPageProject(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return ResponseEntity.ok(projectBussiness.getPageProject(page,pageSize));
    }
    @GetMapping(value = "/chi-tiet-du-an/{id}",produces = SystemConstants.TYPE_JSON)
    public ResponseEntity findProjectId(@PathVariable Integer id){
        ProjectDTO projectDTO = projectBussiness.findByProjectId(id);
        return ResponseEntity.ok(projectDTO);
    }
    @PostMapping(value = "/them-du-an",consumes = SystemConstants.TYPE_JSON)
    public ResponseEntity saveProject(@RequestBody ProjectDTO projectDTO){
        WrapperResult wrapperResult = projectBussiness.saveProject(projectDTO);
        return ResponseEntity.ok(wrapperResult);
    }
    @PutMapping(value = "/sua-du-an",consumes = SystemConstants.TYPE_JSON)
    public ResponseEntity updateProject(@RequestBody ProjectDTO projectDTO){
        WrapperResult wrapperResult = projectBussiness.updateProject(projectDTO);
        return ResponseEntity.ok(wrapperResult);
    }
    @DeleteMapping(value = "/xoa-du-an",consumes = SystemConstants.TYPE_JSON)
    public ResponseEntity deleteProjectById(@RequestBody ProjectDTO projectDTO){
            WrapperResult wrapperResult = projectBussiness.deleteProjectById(projectDTO.getId());
        return ResponseEntity.ok(wrapperResult);
    }
}
