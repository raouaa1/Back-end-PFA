package pi.tn.vett.DTO;

import pi.tn.vett.Entities.UserEnum;

public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private UserEnum role;  // Use UserEnum

    public UserDTO(String name, String email, String password, String phone, UserEnum role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserEnum getRole() {
        return role;
    }

    public void setRole(UserEnum role) {
        this.role = role;
    }
}
