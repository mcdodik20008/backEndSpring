package backendspring.domain.test.mapper;

import backendspring.domain.test.entity.Test;
import backendspring.domain.test.model.view.CategoryViewCreate;
import backendspring.domain.test.model.view.CategoryViewRead;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface TestMapper {


    CategoryViewRead toViewRead(Test entity);

    Test fromViewCreate(CategoryViewCreate view);

    Test fromViewCreate(@MappingTarget Test entity, CategoryViewCreate view);

}
