package vietnam.com.football_system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vietnam.com.football_system.dto.SignUpDto;
import vietnam.com.football_system.dto.UserDto;
import vietnam.com.football_system.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}

