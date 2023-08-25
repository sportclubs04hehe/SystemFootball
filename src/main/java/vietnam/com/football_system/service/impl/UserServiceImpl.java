package vietnam.com.football_system.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vietnam.com.football_system.dto.CredentialsDto;
import vietnam.com.football_system.dto.SignUpDto;
import vietnam.com.football_system.dto.UserDto;
import vietnam.com.football_system.entity.Role;
import vietnam.com.football_system.entity.User;
import vietnam.com.football_system.exception.AppException;
import vietnam.com.football_system.mapper.UserMapper;
import vietnam.com.football_system.repository.UserRepository;
import vietnam.com.football_system.service.UserService;

import java.nio.CharBuffer;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserMapper userMapper;
    @Override
    public UserDto login(CredentialsDto credentialsDto) {
        log.info("Đang cố gắng đăng nhập với tên người dùng: {}",credentialsDto.username());
        User user = userRepository.findUserByUsername(credentialsDto.username())
                .orElseThrow(() -> new AppException("user not found", NOT_FOUND));
        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()),user.getPassword())){
            log.info("Đăng nhập thành công với tên người dùng: {}", credentialsDto.username());
            return userMapper.toUserDto(user);
        }
        log.warn("Mật khẩu không hợp lệ cho tên người dùng: {}", credentialsDto.username());
        throw new AppException("Invalid password", BAD_REQUEST);
    }

    @Override
    public UserDto register(SignUpDto signUpDto) {
        log.info("Đang cố gắng đăng ký người dùng bằng tên người dùng: {}", signUpDto.username());
        if (signUpDto.email().contains(" ") || signUpDto.username().contains(" ") || String.valueOf(signUpDto.password()).contains(" ")){
            throw new AppException("Các trường username, email, password không được chứa dấu cách", BAD_REQUEST);
        }
        Optional<User> optionalUser = userRepository.findUserByUsername(signUpDto.username());
        if(optionalUser.isPresent()){
            throw  new AppException("login already exists", BAD_REQUEST);
        }
        User user = userMapper.signUpToUser(signUpDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.password())));
        user.setRole(Role.USER);
        User savedUser = userRepository.save(user);
        log.info("Người dùng đã đăng ký thành công với id: {}", savedUser.getId());
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public UserDto findByLogin(String login) {
        User user = userRepository.findUserByUsername(login)
                .orElseThrow(() -> new AppException("user not found", NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}
