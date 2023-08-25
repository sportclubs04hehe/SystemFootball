package vietnam.com.football_system.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String category;
    private String brand;
    private String imageUrl;
    private String size;
    private boolean isInStock;
}
