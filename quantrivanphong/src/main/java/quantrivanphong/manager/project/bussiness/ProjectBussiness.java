package quantrivanphong.manager.project.bussiness;

import quantrivanphong.common.Page.AbstractDaoPage;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.ProjectDTO;

import java.util.List;

public interface ProjectBussiness {
    //    Danh sách dự án tất cả các dự án
    List<ProjectDTO> findAllProject();

    //    upload thông tin dự án
    WrapperResult updateProject(ProjectDTO dto);

    //    thêm dự án mới
    WrapperResult saveProject(ProjectDTO dto);

    //    tìm kiếm dự án theo id
    ProjectDTO findByProjectId(Integer id);

    //  xóa một project
    WrapperResult deleteProjectById(Integer ids);

    AbstractDaoPage<ProjectDTO> getPageProject(int page, int pageSize);

}
