package backendspring.infrasructure.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;

@Component
public class FilterToBooleanExpressionMapper {

    public <T> BooleanExpression toBooleanExpression(Filter filter, Class<T> tClass){
        return null;
    }

}
