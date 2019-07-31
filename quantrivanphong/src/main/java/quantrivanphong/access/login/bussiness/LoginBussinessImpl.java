package quantrivanphong.access.login.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quantrivanphong.access.login.repository.LoginRepository;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.LoginDTO;
import quantrivanphong.models.EmployeeModels;

import javax.servlet.http.HttpSession;

@Service
public class LoginBussinessImpl implements LoginBussiness {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public WrapperResult checkLogin(LoginDTO loginDTO, HttpSession session) {
        String views = null;
        int status = 113;
        EmployeeModels login = loginRepository.findEmployeeModelsByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword());
        if(login!=null){
            status = 200;
            views = "chúc mừng bạn đã đăng nhập thành công !";
        }else{
            views = "tên đăng nhập không tồn tại !";
        }
        return new WrapperResult(status,views);
    }
}
