package vietnam.com.football_system.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FeedbackDTO {
    private Long id;
    private UserDto fromUser;
    private UserDto toUser;
    private int rating;
    private String comment;
    private LocalDateTime feedbackDate;
}
