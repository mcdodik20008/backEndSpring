package backendspring.domain.subcategory.model.view;

import backendspring.infrasructure.view.ReferenceView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryViewCreate {

    private String name;

    private ReferenceView parentCategory;

}
