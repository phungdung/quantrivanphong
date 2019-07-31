package quantrivanphong.manager.employee.bussiness;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.EmployeeDTO;
import quantrivanphong.manager.employee.repository.EmployeeRepository;
import quantrivanphong.models.EmployeeModels;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeBussinessImpl implements EmployeeBussiness {
    Logger logger = Logger.getLogger(EmployeeBussinessImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return lstDTO(employeeRepository.findAll());
    }

    @Override
    public WrapperResult updateEmployee(EmployeeDTO employeeDTO) {
        logger.info("Sửa thông tin nhân viên");
        String views = null;
        int status = 113;
        try {
            if (employeeDTO.getId() != null) {
                EmployeeModels employeeModels = employeeRepository.findEmployeeById(employeeDTO.getId());
                if (employeeModels != null) {
                    if (employeeModels.getPassword().equals(employeeDTO.getPassword())) {
                        EmployeeModels updateEmployee = employeeRepository.save(dtoParseModels(employeeDTO));
                        if (updateEmployee != null) {
                            status = 200;
                            views = "sửa thành công nhân viên !";
                        }
                    } else {
                        views = "mật khẩu không chính xác";
                    }
                }
            } else {
                views = "nhân viên không tồn tại!";
            }
        } catch (Exception e) {
            logger.info("Lỗi update nhân viên" + e.getMessage());
            views = "Lỗi update";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public WrapperResult deleteEmployee(EmployeeDTO employeeDTO) {
        logger.info("Xóa thông tin nhân viên");
        String views = null;
        int status = 113;
        try {
            if (employeeDTO.getId() != null) {
                if (employeeRepository.findEmployeeById(employeeDTO.getId()) != null) {
                    employeeRepository.deleteById(employeeDTO.getId());
                    status = 200;
                    views = "xóa thành công nhân viên";
                }
            } else {
                views = "nhân viên không tồn tại";
            }
        } catch (Exception e) {
            logger.info("lỗi xóa " + e.getMessage());
            views = "có răng buộc";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public EmployeeDTO findEmployeeByUserName(EmployeeDTO employeeDTO) {
        return modelsParseDTO(employeeRepository.findByUsername(employeeDTO.getUsername()));
    }

    public EmployeeDTO modelsParseDTO(EmployeeModels employeeModels) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employeeModels, employeeDTO);
        employeeDTO.setPassword(null);
        return employeeDTO;
    }

    public List<EmployeeDTO> lstDTO(List<EmployeeModels> lstModels) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
        for (EmployeeModels employeeModels : lstModels) {
            employeeDTOList.add(modelsParseDTO(employeeModels));
        }
        return employeeDTOList;
    }

    public EmployeeModels dtoParseModels(EmployeeDTO employeeDTO) {
        EmployeeModels employeeModels = new EmployeeModels();
        employeeModels.setId(employeeDTO.getId());
        employeeModels.setUsername(employeeDTO.getUsername());
        employeeModels.setEmailAddress(employeeDTO.getEmailAddress());
        employeeModels.setFirstName(employeeDTO.getFirstName());
        employeeModels.setPassword(employeeDTO.getPassword());
        employeeModels.setPicture(employeeDTO.getPicture());
        return employeeModels;
    }

}
