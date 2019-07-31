package quantrivanphong.manager.employeeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.manager.employeeproject.bussiness.EmployeeProjectBussiness;
import quantrivanphong.dto.EmployeeProjectDTO;

@RestController
public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectBussiness employeeProjectBussiness;

    //    thông tin của 1 nhóm dư án theo id của dự án
//    Team lead,Hr
    @GetMapping(value = "/thong-tin-du-an/{id}")
    public ResponseEntity getOneProjectGroup(@PathVariable("id") Integer projectId) {
        return ResponseEntity.ok(employeeProjectBussiness.getGroupByProjectId(projectId));
    }


    @GetMapping(value = "/chi-tiet-thanh-vien-du-an/{id}")
    public ResponseEntity getOneEmployeeProject(@PathVariable("id") Integer employeeProjectId) {
        return ResponseEntity.ok(employeeProjectBussiness.findEmployeeProjectById(employeeProjectId));
    }

    //    thêm thành viên vào dự án
//    hr,manager, teamlead thêm thành viên
    @PostMapping(value = "/them-thanh-vien")
    public ResponseEntity addMemberProject(@RequestBody EmployeeProjectDTO projectGroupDTO) {
        WrapperResult wrapperResult = employeeProjectBussiness.saveEmployeeProject(projectGroupDTO);
        return ResponseEntity.ok(wrapperResult);
    }

    //    cập nhật thông tin thành viên
//    manager cập nhật chức vụ cho nhân viên vào xét duyệt vào dự án
    @PutMapping(value = "/cap-nhat-chuc-vu-thanh-vien")
    public ResponseEntity updatePositionProject(@RequestBody EmployeeProjectDTO projectGroupDTO) {
        WrapperResult wrapperResult = employeeProjectBussiness.updateEmployeeProject(projectGroupDTO);
        return ResponseEntity.ok(wrapperResult);
    }
    @PutMapping(value = "/thanh-vien-out-nhom")
    public ResponseEntity updateMemberOutProject(@RequestBody EmployeeProjectDTO projectGroupDTO) {
        WrapperResult wrapperResult = employeeProjectBussiness.updateEmployeeOutGroup(projectGroupDTO);
        return ResponseEntity.ok(wrapperResult);
    }
    @DeleteMapping(value = "/xoa-thanh-vien-du-an")
    public ResponseEntity deleteMemberProject(@RequestBody EmployeeProjectDTO projectGroupDTO){
        WrapperResult wrapperResult = employeeProjectBussiness.deleteEmployeeProject(projectGroupDTO.getId());
        return ResponseEntity.ok(wrapperResult);
    }
}
