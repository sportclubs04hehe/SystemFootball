package vietnam.com.football_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "team1_id")
    private Team team1;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "team2_id")
    private Team team2;

    @PositiveOrZero
    private int scoreTeam1 = 0;

    @PositiveOrZero
    private int scoreTeam2 = 0;

    @NotNull
    private LocalDate matchDate;

    @Size(max = 1000)
    private String googleMapsLink;

    @Enumerated(EnumType.STRING)
    @NotNull
    private MatchStatus status;

    public enum MatchStatus {
        SCHEDULED,
        ONGOING,
        COMPLETED,
        CANCELED
    }

    public Match(Team team1, Team team2, int scoreTeam1, int scoreTeam2, LocalDate matchDate, String googleMapsLink, MatchStatus status) {
        this.team1 = team1;
        this.team2 = team2;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
        this.matchDate = matchDate;
        this.googleMapsLink = googleMapsLink;
        this.status = status;
    }
}

