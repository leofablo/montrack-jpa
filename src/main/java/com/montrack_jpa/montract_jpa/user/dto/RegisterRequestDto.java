package com.montrack_jpa.montract_jpa.user.dto;

import com.montrack_jpa.montract_jpa.user.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequestDto {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;

    @NotNull
    @Min(1)
    private int activeCurrency;

    @NotNull
    @Min(1)
    public User toEntity(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(name);
        user.setActiveCurrency(activeCurrency);
        return user;
    }
}
