package vietnam.com.football_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/** đại diện cho một môn thể thao*/
@Data
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private User leader;

    @Size(max = 500)
    private String locationLink;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "teamsJoined")
    private Set<User> members;

    @OneToOne(mappedBy = "team")
    private ChatGroup chatGroup;

    public Team(String name, User leader, String locationLink, Set<User> members, ChatGroup chatGroup) {
        this.name = name;
        this.leader = leader;
        this.locationLink = locationLink;
        this.members = members;
        this.chatGroup = chatGroup;
    }
}
