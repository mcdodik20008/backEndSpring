package backendspring.domain.userorder.model.mapper;

import backendspring.domain.userorder.model.entity.ProductOrder;
import backendspring.domain.userorder.model.view.ProductOrderViewCreate;
import backendspring.domain.userorder.model.view.ProductOrderViewRead;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductOrderMapper {

    ProductOrderMapper INSTANCE = Mappers.getMapper(ProductOrderMapper.class);

    ProductOrderViewRead toViewRead(ProductOrder entity);

    ProductOrder fromViewCreate(ProductOrderViewCreate view);

    ProductOrder fromViewCreate(@MappingTarget ProductOrder entity, ProductOrderViewCreate view);

}
