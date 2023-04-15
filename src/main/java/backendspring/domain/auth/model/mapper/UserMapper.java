package backendspring.domain.auth.model.mapper;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.model.view.UserNoPassword;
import backendspring.domain.category.model.mapper.CategoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    UserNoPassword toViewRead(User entity);

}
