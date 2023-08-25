package vietnam.com.football_system.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vietnam.com.football_system.config.UserAuthenticationProvider;
import vietnam.com.football_system.dto.CredentialsDto;
import vietnam.com.football_system.dto.SignUpDto;
import vietnam.com.football_system.dto.UserDto;
import vietnam.com.football_system.entity.Role;
import vietnam.com.football_system.service.UserService;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto){
        log.info("Điểm cuối đăng nhập bằng tên người dùng: {}", credentialsDto.username());
        UserDto userDto = userService.login(credentialsDto);
        userDto.setPassword(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user){
        log.info("Register endpoint hit with username: {}", user.username());
        UserDto createdUser = userService.register(user);
        createdUser.setPassword(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}
