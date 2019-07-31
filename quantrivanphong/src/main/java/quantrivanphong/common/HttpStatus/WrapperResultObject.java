package quantrivanphong.common.HttpStatus;

import java.util.List;

public class WrapperResultObject {
    private int status;
    private String message;
    private List<String> lstRole;
    private String Role;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getLstRole() {
        return lstRole;
    }

    public void setLstRole(List<String> lstRole) {
        this.lstRole = lstRole;
    }

    public WrapperResultObject(int status, String message, List<String> lstRole) {
        this.status = status;
        this.message = message;
        this.lstRole = lstRole;
    }

    public WrapperResultObject(int status, String message, List<String> lstRole, String role) {
        this.status = status;
        this.message = message;
        this.lstRole = lstRole;
        Role = role;
    }
}
