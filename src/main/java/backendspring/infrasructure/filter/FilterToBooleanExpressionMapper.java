package backendspring.infrasructure.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public class FilterToBooleanExpressionMapper<T> {

    private PathBuilder<Long> entityPath;

    private Class<Long> tClass;

    public FilterToBooleanExpressionMapper(/*Class<T> tClass*/) {
        this.tClass = Long.class;
        entityPath = new PathBuilder<>(tClass, tClass.getName().toLowerCase());
    }

    public BooleanExpression toBooleanExpression(Filter filter) throws NoSuchFieldException {
        return toBooleanExpression(filter.getObjectFields());
    }

    private BooleanExpression toBooleanExpression(List<Fields> objectFields) throws NoSuchFieldException {
        BooleanExpression exp = entityPath.isNull();
//        for (var fieldInf : objectFields) {
//            Class fieldType = null;
//            Field field = null;
//            String[] names = fieldInf.filed.split("\\.");
//            try {
//                field = tClass.getField(names[0]);
//            } catch (Exception ex){
//                throw new NoSuchFieldException("не найдено поле: " + names[0]);
//            }
//
//            fieldType = field.getType();
//        }

//        for (:objectFields) {
//
//        }
        return null;
    }

    private Class<T> typeOfT;

    @SuppressWarnings("unchecked")
    private void data() {
        tClass = (Class<Long>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }
}
