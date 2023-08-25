package vietnam.com.football_system.dto;

import java.time.LocalDateTime;

public class NotificationDTO {
    private Long id;
    private UserDto recipient;
    private String message;
    private LocalDateTime sentAt;
}
