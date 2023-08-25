package vietnam.com.football_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class ChatGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String thirdPartyChatId;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToMany(mappedBy = "chatGroups")
    private Set<User> participants;

    public ChatGroup(String thirdPartyChatId, Team team, Set<User> participants) {
        this.thirdPartyChatId = thirdPartyChatId;
        this.team = team;
        this.participants = participants;
    }
}