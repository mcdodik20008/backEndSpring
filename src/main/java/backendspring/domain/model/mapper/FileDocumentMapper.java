package backendspring.domain.model.mapper;

import backendspring.domain.model.entity.FileDocument;
import backendspring.domain.model.view.FileDocumentShort;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileDocumentMapper {
    FileDocumentMapper INSTANCE = Mappers.getMapper(FileDocumentMapper.class);

    FileDocument toEntity(FileDocumentShort view);

    FileDocumentShort toShort(FileDocument entity);
}
