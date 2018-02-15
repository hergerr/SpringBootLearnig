package pl.com.frankiewicz.security;


import javax.persistence.UniqueConstraint;

public class UserDTO {

    private String email;
    private String uuid;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
