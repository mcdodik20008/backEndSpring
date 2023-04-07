package backendspring.domain.category.model.entity;

import backendspring.domain.subcategory.model.entity.SubCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subcategories")
    @OneToMany(mappedBy = "id")
    private List<SubCategory> subCategories;

}
