package vietnam.com.football_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.*;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username không được để trống!")
    @Column(unique = true, length = 100)
    private String username;
    @NotNull(message = "First Name không được để trống")
    @Column(length = 100)
    private String firstName;
    @NotNull(message = "lastName không được để trống")
    @Column(length = 100)
    private String lastName;
    @Column(length = 100)
    @NotBlank(message = "password không được để trống")
    private String password;

    @NotBlank(message = "phoneNumber không được để trống")
    @Column(length = 20)
    private String phoneNumber;

    @Email(message = "Email không đúng định dạng")
    @NotNull
    @Column(length = 80)
    private String email;

    @Min(value = 1,message = "Tuổi không được bé hơn 1")
    @Max(value = 128, message = "Tuổi không được lớn hơn 128")
    private Integer age;

    @Column(length = 80)
    private String skillLevel;

    private Float rating;

    @Column(length = 100)
    private String position;

    @Column(length = 255)
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Role role;

    @OneToMany(mappedBy = "leader", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Team> teamsLed; // có thể lãnh đạo nhiều đội

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_teams",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> teamsJoined; // có thể tham gia nhiều đội

    @ManyToMany
    @JoinTable(
            name = "chat_participants",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id")
    )
    private Set<ChatGroup> chatGroups;

    public User(String username,String firstName, String lastName, String password, String phoneNumber, String email, Integer age, String skillLevel, Float rating, String position, String profileImage, Set<Team> teamsLed, Set<Team> teamsJoined, Set<ChatGroup> chatGroups) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.skillLevel = skillLevel;
        this.rating = rating;
        this.position = position;
        this.profileImage = profileImage;
        this.teamsLed = teamsLed;
        this.teamsJoined = teamsJoined;
        this.chatGroups = chatGroups;
    }
}
