package vietnam.com.football_system.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchDTO {
    private Long id;
    private TeamDTO team1;
    private TeamDTO team2;
    private int scoreTeam1;
    private int scoreTeam2;
    private LocalDateTime matchDate;
    private String googleMapsLink;
    private String status;
}
