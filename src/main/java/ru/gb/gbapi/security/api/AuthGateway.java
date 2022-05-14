package ru.gb.gbapi.security.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapi.security.AuthenticationUserDto;
import ru.gb.gbapi.security.UserDto;

import java.util.List;

public interface AuthGateway {

    @PostMapping("/login")
    ResponseEntity<AuthenticationUserDto> login(@RequestBody AuthenticationUserDto authenticationUserDto);
}
