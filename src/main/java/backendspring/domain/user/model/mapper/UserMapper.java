package backendspring.domain.user.model.mapper;

import backendspring.domain.user.model.entity.User;
import backendspring.domain.user.model.view.UserViewRead;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserViewRead toViewRead(User entity);

    User fromViewCreate(UserViewRead view);

    User fromViewCreate(@MappingTarget User entity, UserViewRead view);

}
