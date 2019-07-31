package quantrivanphong.manager.employee.bussiness;

import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeBussiness {
    List<EmployeeDTO> getAllEmployee();
    WrapperResult updateEmployee(EmployeeDTO employeeDTO);
    WrapperResult deleteEmployee(EmployeeDTO EmployeeDTO);
    EmployeeDTO findEmployeeByUserName(EmployeeDTO EmployeeDTO);
}
