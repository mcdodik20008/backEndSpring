package backendspring.infrasructure.abstractclass.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractFileView {
    private long id;
    private String name;
    private String fileType;
}
