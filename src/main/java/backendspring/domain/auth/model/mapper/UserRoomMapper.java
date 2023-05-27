package backendspring.domain.auth.model.mapper;

import backendspring.domain.auth.model.entity.UserRoom;
import backendspring.domain.auth.model.view.UserRoomViewCreate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRoomMapper {

    UserRoomMapper INSTANCE = Mappers.getMapper(UserRoomMapper.class);

    UserRoom fromViewCreate(UserRoomViewCreate view);

}
