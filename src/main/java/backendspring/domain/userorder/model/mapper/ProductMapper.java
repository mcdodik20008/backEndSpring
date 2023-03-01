package backendspring.domain.userorder.model.mapper;

import backendspring.domain.userorder.model.entity.UserOrder;
import backendspring.domain.userorder.model.view.UserOrderViewCreate;
import backendspring.domain.userorder.model.view.UserOrderViewRead;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    UserOrderViewRead toViewRead(UserOrder entity);

    UserOrder fromViewCreate(UserOrderViewCreate view);

    UserOrder fromViewCreate(@MappingTarget UserOrder entity, UserOrderViewCreate view);

}
