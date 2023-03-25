package backendspring.domain.subcategory.model.view;

import backendspring.domain.category.model.view.CategoryViewRead;
import backendspring.infrasructure.view.ReferenceView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryViewRead {

    private Long id;

    private String name;

    private CategoryViewRead parentCategory;

}
