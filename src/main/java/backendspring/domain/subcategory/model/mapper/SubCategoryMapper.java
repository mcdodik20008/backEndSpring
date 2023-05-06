package backendspring.domain.subcategory.model.mapper;

import backendspring.domain.subcategory.model.entity.SubCategory;
import backendspring.domain.subcategory.model.view.SubCategoryViewCreate;
import backendspring.domain.subcategory.model.view.SubCategoryViewRead;
import backendspring.infrasructure.view.ReferenceView;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubCategoryMapper {

    SubCategoryMapper INSTANCE = Mappers.getMapper(SubCategoryMapper.class);

    SubCategoryViewRead toViewRead(SubCategory entity);

    ReferenceView toReferenceView(SubCategory entity);

    SubCategory fromViewCreate(SubCategoryViewCreate view);

    SubCategory fromViewCreate(@MappingTarget SubCategory entity, SubCategoryViewCreate view);

}
