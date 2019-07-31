package quantrivanphong.access.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quantrivanphong.access.login.bussiness.LoginBussiness;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.LoginDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class LoginControllers {

    @Autowired
    private LoginBussiness loginBussiness;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity Login(@Valid @RequestBody LoginDTO loginDTO, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity<LoginDTO>(loginDTO, HttpStatus.OK);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            WrapperResult wrapperResult = loginBussiness.checkLogin(loginDTO, session);
            return ResponseEntity.ok(wrapperResult);
        }
        return ResponseEntity.ok(responseEntity);
    }
}
