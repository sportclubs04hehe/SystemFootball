package vietnam.com.football_system.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ChatGroupDTO {
    private Long id;
    private String thirdPartyChatId;
    private TeamDTO team;
    private Set<UserDto> participants;
}
