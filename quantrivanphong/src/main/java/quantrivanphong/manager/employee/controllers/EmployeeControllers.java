package quantrivanphong.manager.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.EmployeeDTO;
import quantrivanphong.manager.employee.bussiness.EmployeeBussiness;
import javax.validation.Valid;

@RestController
public class EmployeeControllers {

    @Autowired
    private EmployeeBussiness employeeBussiness;

    @RequestMapping(value = "/danh-sach-nhan-vien",method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployee(){
        return ResponseEntity.ok(employeeBussiness.getAllEmployee());
    }
    @PutMapping(value = "/cap-nhat-thong-tin-nhan-vien")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        ResponseEntity responseEntity = new  ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.BAD_REQUEST);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        }
        return new  ResponseEntity<WrapperResult>(employeeBussiness.updateEmployee(employeeDTO),HttpStatus.OK) ;
    }
    @DeleteMapping(value = "/xoa-thong-tin-nhan-vien")
    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<WrapperResult>(employeeBussiness.deleteEmployee(employeeDTO),HttpStatus.OK);
    }
}
