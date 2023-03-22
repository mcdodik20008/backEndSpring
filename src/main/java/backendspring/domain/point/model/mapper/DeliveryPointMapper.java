package backendspring.domain.point.model.mapper;

import backendspring.domain.point.model.entity.DeliveryPoint;
import backendspring.domain.point.model.view.DeliveryPointViewCreate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryPointMapper {

    DeliveryPointMapper INSTANCE = Mappers.getMapper(DeliveryPointMapper.class);

    DeliveryPoint fromViewCreate(DeliveryPointViewCreate view);

    DeliveryPoint fromViewCreate(@MappingTarget DeliveryPoint entity, DeliveryPointViewCreate view);

}
