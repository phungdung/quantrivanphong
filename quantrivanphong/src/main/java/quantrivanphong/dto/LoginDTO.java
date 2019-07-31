package quantrivanphong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotEmpty(message = "tài khoản không được để trống !")
    private String username;
    @NotEmpty(message = "mật khẩu không được để trống !")
    private String password;
}
