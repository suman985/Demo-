package io.registration_practice1.demo.RegistrationDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

public class RegistrationDto {
    @NotNull
    @Size(min = 2, message = "Name must be at least 2 characters long.")
    private String name;

    @Email(message = "Email should be valid.")
    private String email;

    @Size(min = 10, max = 10, message = "Mobile number must be exactly 10 digits.")
    private String mobile;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
