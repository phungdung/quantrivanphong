package quantrivanphong.access.register.bussiness;

import quantrivanphong.dto.EmployeeDTO;
import quantrivanphong.common.HttpStatus.WrapperResult;

public interface RegisterBussiness {
    WrapperResult saveEmployee(EmployeeDTO employeeDTO);
}
