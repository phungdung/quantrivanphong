package quantrivanphong.access.register.controllers;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quantrivanphong.access.register.bussiness.RegisterBussiness;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.EmployeeDTO;

import javax.validation.Valid;

@RestController
public class RegisterControllers {

    @Autowired
    private RegisterBussiness registerBussiness;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        ResponseEntity responseEntity = new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.BAD_REQUEST);
        if(responseEntity.getStatusCode()==HttpStatus.OK){
            return responseEntity;
        }
        return new ResponseEntity<WrapperResult>(registerBussiness.saveEmployee(employeeDTO),HttpStatus.OK);
    }
}
