package backendspring.domain.product.model.mapper;

import backendspring.domain.product.model.entity.Product;
import backendspring.domain.product.model.view.ProductViewCreate;
import backendspring.domain.product.model.view.ProductViewRead;
import backendspring.domain.product.model.view.ProductViewUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductViewRead toViewRead(Product entity);

    Product fromViewCreate(ProductViewCreate view);

    Product fromViewCreate(@MappingTarget Product entity, ProductViewCreate view);

    Product fromViewUpdate(@MappingTarget Product entity, ProductViewUpdate view);
}
