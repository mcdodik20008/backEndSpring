package backendspring.domain.auth.model.mapper;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.model.view.UserViewCreate;
import backendspring.domain.auth.model.view.UserViewRead;
import backendspring.domain.auth.model.view.UserViewUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserViewRead toViewRead(User entity);

    User fromViewCreate(UserViewCreate view);

    User fromViewUpdate(@MappingTarget User entity, UserViewUpdate view);

    User fromViewUpdate(UserViewCreate view);

}
