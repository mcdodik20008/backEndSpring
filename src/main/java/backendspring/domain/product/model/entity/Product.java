package backendspring.domain.product.model.entity;

import backendspring.domain.category.model.entity.Category;
import backendspring.domain.subcategory.model.entity.SubCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "subcategory_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product_subcategory"))
    private SubCategory subCategory;

    @Column(name = "controlled")
    private Boolean controlled;

    @Min(0)
    @Column(name = "price")
    private Double price;

    @PrePersist
    public void prePersist()
    {
        BigDecimal bdPrice = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
        price = bdPrice.doubleValue();
    }

}
