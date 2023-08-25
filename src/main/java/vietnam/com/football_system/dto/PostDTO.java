package vietnam.com.football_system.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDTO {
    private Long id;
    private UserDto user;
    private String content;
    private LocalDateTime postDate;
}
