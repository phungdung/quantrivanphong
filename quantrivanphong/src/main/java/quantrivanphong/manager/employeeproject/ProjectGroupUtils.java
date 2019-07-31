package quantrivanphong.manager.employeeproject;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quantrivanphong.dto.EmployeeDTO;
import quantrivanphong.manager.employee.repository.EmployeeRepository;
import quantrivanphong.dto.ProjectDTO;
import quantrivanphong.dto.EmployeeProjectDTO;
import quantrivanphong.manager.project.repository.ProjectRepository;
import quantrivanphong.models.EmployeeModels;
import quantrivanphong.models.EmployeeProjectModels;
import quantrivanphong.models.ProjectModels;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectGroupUtils {
    private static Logger logger = Logger.getLogger(ProjectGroupUtils.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;


    public EmployeeProjectModels Model(EmployeeProjectDTO dto){
        EmployeeProjectModels model = new EmployeeProjectModels();
        model.setId(dto.getId());
        model.setJoinDate(dto.getJoinDate());
        model.setOutDate(dto.getOutDate());
        model.setPosition(dto.getPosition());
        model.setStatus(dto.getStatus());
        try{
            EmployeeModels findEmployee = employeeRepository.findEmployeeById(dto.getUserId());
            if(findEmployee!=null){
               model.setEmployee(findEmployee);
            }
        }catch (Exception e){
            logger.info("(Lỗi không tìm thấy Employee) "+e.getMessage());
        }
        try{
            ProjectModels project = projectRepository.findProjectById(dto.getProjectId());
            if(project!=null){
                model.setProject(project);
            }
        }catch (Exception e){
            logger.info("(Lỗi không tìm thấy Project) "+e.getMessage());
        }
        return model;
    }

    public  EmployeeProjectDTO DTO(EmployeeProjectModels models) {
        EmployeeProjectDTO dto = new EmployeeProjectDTO();
        dto.setId(models.getId());
//        set project
        ProjectDTO projectDTO = new ProjectDTO();
        BeanUtils.copyProperties(models.getProject(),projectDTO);
        dto.setProjectDTO(projectDTO);
//        set employee
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(models.getEmployee().getId());
        employeeDTO.setUsername(models.getEmployee().getUsername());
        employeeDTO.setFirstName(models.getEmployee().getFirstName());
        employeeDTO.setEmailAddress(models.getEmployee().getEmailAddress());
        dto.setEmployeeDTO(employeeDTO);

        dto.setJoinDate(models.getJoinDate());
        dto.setOutDate(models.getOutDate());
        dto.setPosition(models.getPosition());
        return dto;
    }
    public  List<EmployeeProjectDTO> getListDTO(List<EmployeeProjectModels> lstModel){
        if(!lstModel.isEmpty()||lstModel.size()!=0){
            List<EmployeeProjectDTO> lstDTO = new ArrayList<EmployeeProjectDTO>();
            for (EmployeeProjectModels eproject:lstModel) {
                lstDTO.add(DTO(eproject));
            }
            return lstDTO;
        }
        return null;
    }
}
