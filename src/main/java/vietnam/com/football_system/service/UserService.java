package vietnam.com.football_system.service;

import vietnam.com.football_system.dto.CredentialsDto;
import vietnam.com.football_system.dto.SignUpDto;
import vietnam.com.football_system.dto.UserDto;

public interface UserService {
    UserDto login(CredentialsDto credentialsDto);

    UserDto register(SignUpDto signUpDto);

    UserDto findByLogin(String login);
}
