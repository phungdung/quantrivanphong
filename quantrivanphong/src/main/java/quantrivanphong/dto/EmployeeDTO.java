package quantrivanphong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Integer id;
    //    tên đăng nhập
    @Size(min = 8, message = "tài khoản có độ dài tối thiểu 8 ký tự")
    @NotEmpty(message = "tài khoản không để trống")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Tên đăng nhập có chứa ký tự đặc biệt")
    private String username;
    //    mật khẩu truy cập
    @Size(min = 3, message = "mật khẩu có độ dài tối thiểu 3 ký tự")
    @NotEmpty(message = "mật khẩu không để trống")
    private String password;
    //    ảnh đại diện
    private String picture;
    //    họ và tên
    @NotEmpty(message = "họ và tên không để trống!")
    private String firstName;
    //    email
    @Email(message = "email không hợp lệ")
    @NotEmpty(message = "email không để trống!")
    private String emailAddress;
    //    số điện thoại
    @NotEmpty(message = "số điện thoại không để trống")
    @Pattern(regexp = "[0-9]{10}",message = "số điện thoại không hợp lệ")
    private String phoneNumber;
    //    kiểm tra tài khoản
    private boolean checked;
    //    trạng thái kích hoạt
    private int status;
}
