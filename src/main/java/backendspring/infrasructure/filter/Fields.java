package backendspring.infrasructure.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fields {

    String field;

    Operators operator;

    String value;

    String logic;

}
