package quantrivanphong.access.register.bussiness;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quantrivanphong.dto.EmployeeDTO;
import quantrivanphong.access.register.repository.RegisterRepository;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.models.EmployeeModels;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterBussinessImpl implements RegisterBussiness{
    private Logger logger = Logger.getLogger(RegisterBussinessImpl.class);
    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public WrapperResult saveEmployee(EmployeeDTO employeeDTO) {
        String views ="";
        int status =113;
        if(checkEmail(employeeDTO.getEmailAddress())){
            views="Email đã được đăng ký";
        }else if(checkUserName(employeeDTO.getUsername())){
            views ="UserName đã được sử dụng";
        }else {
            try{
                EmployeeModels employeeModels = registerRepository.save(convertoModels(employeeDTO));
                if(employeeModels!=null){
                    views ="chúc mừng bạn đã đăng ký thành công! ";
                    status = 200;
                }else {
                    views="đăng ký không thành công!";
                }
            }catch (Exception e){
                logger.info("Lỗi đăng ký: "+e.getMessage());
            }
        }
        return new WrapperResult(status,views);
    }

//Check email và username đã tồn tại chưa

    public boolean checkEmail(String email){
        if(registerRepository.findEmailByEmail(email)!=null){
            return true;
        }
        return false;
    }
    public boolean checkUserName(String username){
//        kiểm tra username đã tồn tại chưa
        if(registerRepository.findEmailByEmail(username)!=null){
            return true;
        }
        return false;
    }

//    chuyển DTO sang Model và ngược lại
    public EmployeeDTO convertoDTO(EmployeeModels employeeModels){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employeeModels,employeeDTO);
        return employeeDTO;
    }
    public EmployeeModels convertoModels(EmployeeDTO employeeDTO){
        EmployeeModels employeeModels = new EmployeeModels();
        BeanUtils.copyProperties(employeeDTO,employeeModels);
        return employeeModels;
    }
    public List<EmployeeDTO> convertoDTO(List<EmployeeModels> lstModels){
        List<EmployeeDTO> lstDto = new ArrayList<EmployeeDTO>();
        for (EmployeeModels models:lstModels) {
            lstDto.add(convertoDTO(models));
        }
        return lstDto;
    }
}
