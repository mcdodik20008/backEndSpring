package backendspring.infrasructure.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Fields {

    String filed;

    Operators operator;

    String value;

    String logic;

    List<Fields> childFields;
}
