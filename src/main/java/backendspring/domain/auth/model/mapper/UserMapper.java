package backendspring.domain.auth.model.mapper;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.model.view.UserNoPassword;
import backendspring.domain.category.model.entity.Category;
import backendspring.domain.subcategory.model.entity.SubCategory;
import backendspring.domain.subcategory.model.view.SubCategoryViewCreate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserNoPassword toViewRead(User entity);

    User fromViewCreate(@MappingTarget User entity, UserNoPassword view);

}
