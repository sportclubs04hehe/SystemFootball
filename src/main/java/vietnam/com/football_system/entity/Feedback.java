package vietnam.com.football_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    @Size(max = 500)
    private String comment;

    @NotNull
    private LocalDateTime feedbackDate;

    public Feedback(User fromUser, User toUser, int rating, String comment, LocalDateTime feedbackDate) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.rating = rating;
        this.comment = comment;
        this.feedbackDate = feedbackDate;
    }
}
