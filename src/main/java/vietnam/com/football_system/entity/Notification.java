package vietnam.com.football_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User recipient;

    @NotBlank
    private String message;

    private LocalDateTime sentAt;

    public Notification(User recipient, String message, LocalDateTime sentAt) {
        this.recipient = recipient;
        this.message = message;
        this.sentAt = sentAt;
    }
}
