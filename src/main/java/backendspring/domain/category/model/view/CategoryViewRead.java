package backendspring.domain.category.model.view;

import backendspring.domain.subcategory.model.entity.SubCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryViewRead {

    private Long id;

    private String name;

}
