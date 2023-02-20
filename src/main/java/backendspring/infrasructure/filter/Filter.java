package backendspring.infrasructure.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Filter {

    String className;

    List<Fields> objectFields;

}
