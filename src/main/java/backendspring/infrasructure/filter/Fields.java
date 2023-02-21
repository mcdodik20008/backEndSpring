package backendspring.infrasructure.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Fields {

    String field;

    Operators operator;

    String value;

    List<Fields> childFields;
}
