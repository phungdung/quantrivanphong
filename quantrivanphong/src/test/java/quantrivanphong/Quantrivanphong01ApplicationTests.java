package quantrivanphong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import quantrivanphong.access.register.bussiness.RegisterBussiness;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Quantrivanphong01ApplicationTests {
    @Autowired
    private RegisterBussiness registerBussiness;
    @Test
    public void contextLoads() {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setUsername("phungdung");
//        employeeDTO.setPassword("123456");
//        employeeDTO.setEmail("phungdungcnc1995@gmail.com");
//        WrapperResult wrapperResult = registerBussiness.saveEmployee(employeeDTO);
    }

}
