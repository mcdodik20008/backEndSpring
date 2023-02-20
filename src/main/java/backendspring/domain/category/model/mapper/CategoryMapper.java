package backendspring.domain.category.model.mapper;

import backendspring.domain.category.model.entity.Category;
import backendspring.domain.category.model.view.CategoryShort;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryShort view);

    CategoryShort toShort(Category entity);
}
