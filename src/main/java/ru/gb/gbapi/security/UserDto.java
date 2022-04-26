package ru.gb.gbapi.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @JsonIgnore
    private Long id;
    @NotBlank
    @Size(min = 3, message = "username length must be grater than 4 symbols")
    private String username;
    @NotBlank(message = "is required")
    private String password;

    @NotBlank(message = "is required")
    private String firstname;
    @NotBlank(message = "is required")
    private String lastname;
    @Email
    @NotBlank(message = "is required")
    private String email;
    @Size(min = 5, message = "phone must be grater than 4 symbols")
    @NotBlank(message = "is required")
    private String phone;
}
