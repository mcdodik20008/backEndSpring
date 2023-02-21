package backendspring.domain.category.model.mapper;

import backendspring.domain.category.model.entity.Category;
import backendspring.domain.category.model.view.CategoryViewRead;
import backendspring.domain.category.model.view.CategoryViewCreate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryViewRead toViewRead(Category entity);

    Category fromViewCreate(CategoryViewCreate view);

    Category fromViewCreate(@MappingTarget Category entity, CategoryViewCreate view);

}
