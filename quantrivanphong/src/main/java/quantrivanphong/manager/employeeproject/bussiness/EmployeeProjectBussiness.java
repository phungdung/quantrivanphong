package quantrivanphong.manager.employeeproject.bussiness;

import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.EmployeeProjectDTO;

import java.util.List;

public interface EmployeeProjectBussiness {
    //    chi tiết nhóm dự án
    List<EmployeeProjectDTO> getGroupByProjectId(Integer projectId);

    //    thêm thành viên vào nhóm dự án
    WrapperResult saveEmployeeProject(EmployeeProjectDTO dto);

    //    sửa thông tin nhóm dự án, các thành viên out nhóm
    WrapperResult updateEmployeeProject(EmployeeProjectDTO dto);

    // thành viên out dự án
    WrapperResult deleteEmployeeProject(Integer id);

    WrapperResult updateEmployeeOutGroup(EmployeeProjectDTO dto);

    EmployeeProjectDTO findEmployeeProjectById(Integer id);
}
