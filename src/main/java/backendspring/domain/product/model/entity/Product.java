package backendspring.domain.product.model.entity;

import backendspring.domain.category.model.entity.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@Entity(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "TEXT", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_product_category"))
    private Category category;

    @Column(name = "controlled")
    private Boolean controlled;

    @Column(name = "price")
    private Double price;

    @PrePersist
    public void prePersist()
    {
        BigDecimal bdPrice = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
        price = bdPrice.doubleValue();
    }

}
