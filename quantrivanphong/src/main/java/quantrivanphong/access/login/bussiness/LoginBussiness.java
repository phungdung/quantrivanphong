package quantrivanphong.access.login.bussiness;

import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.LoginDTO;

import javax.servlet.http.HttpSession;

public interface LoginBussiness {
    WrapperResult checkLogin(LoginDTO loginDTO, HttpSession session);
}
