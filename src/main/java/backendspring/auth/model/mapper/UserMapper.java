package backendspring.auth.model.mapper;

import backendspring.auth.model.entity.User;
import backendspring.auth.model.view.UserViewCreate;
import backendspring.auth.model.view.UserViewRead;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserViewRead toViewRead(User entity);

    User fromViewCreate(UserViewCreate view);

    User fromViewCreate(@MappingTarget User entity, UserViewCreate view);

}
