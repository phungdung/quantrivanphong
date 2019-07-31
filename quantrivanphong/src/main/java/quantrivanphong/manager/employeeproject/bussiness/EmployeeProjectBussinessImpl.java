package quantrivanphong.manager.employeeproject.bussiness;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.manager.employee.repository.EmployeeRepository;
import quantrivanphong.dto.EmployeeProjectDTO;
import quantrivanphong.manager.employeeproject.ProjectGroupUtils;
import quantrivanphong.manager.employeeproject.repository.EmployeeProjectRepository;
import quantrivanphong.manager.project.repository.ProjectRepository;
import quantrivanphong.models.EmployeeModels;
import quantrivanphong.models.EmployeeProjectModels;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeProjectBussinessImpl implements EmployeeProjectBussiness {
    private Logger logger = Logger.getLogger(EmployeeProjectBussinessImpl.class);

    @Autowired
    private EmployeeProjectRepository projectGroupRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectGroupUtils utils;

    @Autowired
    private EmployeeRepository employeeProject;

    @Override
    public List<EmployeeProjectDTO> getGroupByProjectId(Integer projectId) {
        logger.info("getGroupByProjectId");
        List<EmployeeProjectModels> lstModels = projectGroupRepository.findByProjectId(projectId);
        List<EmployeeProjectDTO> lstDTO = utils.getListDTO(lstModels);
        return lstDTO;
    }

    public boolean checkEmployeeInGroupProject(EmployeeProjectDTO dto) {
            if (dto.getProjectId()!=null) {
                List<EmployeeProjectModels> lst = projectGroupRepository.findByProjectId(dto.getProjectId());
                for (EmployeeProjectModels eproject : lst) {
                    if (eproject.getEmployee().getUsername().equals(dto.getUserName())) {
                        return true;
                    }
                }
            }
        return false;
    }

    @Override
    public WrapperResult saveEmployeeProject(EmployeeProjectDTO dto) {
        String views = "";
        int status = 113;
        logger.info("saveEmployeeProject");
        EmployeeModels employee = employeeProject.findByUsername(dto.getUserName());
        if (employee == null) {
            views = "Nhân viên không tồn tại !";
        } else if (!checkEmployeeInGroupProject(dto)) {
            try {
                dto.setStatus(1);
                dto.setUserId(employee.getId());
                dto.setJoinDate(new Timestamp(System.currentTimeMillis()));
                EmployeeProjectModels eproject = projectGroupRepository.save(utils.Model(dto));
                if (eproject != null) {
                    views = "thêm thành công nhân viên vào nhóm dự án";
                    status = 200;
                } else {
                    views = "thêm không thành công!";
                }
            } catch (Exception e) {
                logger.info("Lỗi " + e.getMessage());
            }
        } else {
            status = 113;
            views = "thành viên đã tồn tại";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public WrapperResult updateEmployeeProject(EmployeeProjectDTO dto) {
        String views = "";
        int status = 113;
        logger.info("updateEmployeeProject");

        EmployeeProjectModels eproject = projectGroupRepository.findEprojectById(dto.getId());
        if (eproject != null) {
            eproject.setPosition(dto.getPosition());
            EmployeeProjectModels updateProjectGroup = projectGroupRepository.save(eproject);
            if (updateProjectGroup != null) {
                views = "cập nhật chức vụ thành viên thành công";
                status = 200;
            }
        } else {
            views = "đối tượng không tồn tại";
        }

        return new WrapperResult(status, views);
    }

    @Override
    public EmployeeProjectDTO findEmployeeProjectById(Integer id) {
        try {
            EmployeeProjectDTO projectGroupDTO = utils.DTO(projectGroupRepository.findEprojectById(id));
            if (projectGroupDTO != null) {
                return projectGroupDTO;
            }
        } catch (Exception e) {
            logger.info("Lỗi update EProject " + e.getMessage());
        }
        return null;
    }

    @Override
    public WrapperResult deleteEmployeeProject(Integer id) {
        String views = "";
        int status = 113;
        logger.info("deleteEmployeeProject");
        if (projectGroupRepository.findEprojectById(id) != null) {
            projectGroupRepository.deleteById(id);
            views = "Bạn đã cho thoát ra khỏi nhóm";
            status = 200;
        } else {
            views = "Thành viên không tồn tại trong nhóm";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public WrapperResult updateEmployeeOutGroup(EmployeeProjectDTO dto) {
        String views = "";
        int status = 113;
        logger.info("updateEmployeeOutGroup");
        EmployeeProjectModels eproject = projectGroupRepository.findEprojectById(dto.getId());
        if (eproject != null) {
            eproject.setStatus(2);
            eproject.setOutDate(new Timestamp(System.currentTimeMillis()));
            EmployeeProjectModels updateProjectGroup = projectGroupRepository.save(eproject);
            if (updateProjectGroup != null) {
                views = "thành viên đã out nhóm";
                status = 200;
            }
        } else {
            views = "đối tượng không tồn tại";
        }
        return new WrapperResult(status, views);
    }
}
