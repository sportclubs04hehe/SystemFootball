package vietnam.com.football_system.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductReviewDTO {
    private Long id;
    private UserDto reviewer;
    private ProductDTO product;
    private int rating;
    private String comment;
    private LocalDateTime reviewDate;
}
