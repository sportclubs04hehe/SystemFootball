package vietnam.com.football_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @Size(max = 500)
    private String description;

    @NotNull
    @Size(max = 255)
    private String category;  // e.g., shoes, socks, balls, etc.

    @Size(max = 255)
    private String brand;

    @Size(max = 255)
    private String imageUrl;  // URL to product image

    @Size(max = 100)
    private String size;  // e.g., S, M, L, XL or number-based size for shoes

    @NotNull
    private boolean isInStock;

    public Product(String name, BigDecimal price, String description, String category, String brand, String imageUrl, String size, boolean isInStock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.imageUrl = imageUrl;
        this.size = size;
        this.isInStock = isInStock;
    }
}
