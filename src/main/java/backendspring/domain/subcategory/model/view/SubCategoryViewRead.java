package backendspring.domain.subcategory.model.view;

import backendspring.infrasructure.view.ReferenceView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryViewRead {

    private Long id;

    private String name;

    private ReferenceView parentCategory;

}
