package vietnam.com.football_system.dto;

import lombok.Data;

import java.util.Set;

@Data
public class TeamDTO {
    private Long id;
    private String name;
    private UserDto leader;
    private String locationLink;
    private Set<UserDto> members;
}
