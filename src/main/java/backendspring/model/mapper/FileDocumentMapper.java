package backendspring.model.mapper;

import backendspring.model.entity.FileDocument;
import backendspring.model.view.FileDocumentShort;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileDocumentMapper {
    FileDocumentMapper INSTANCE = Mappers.getMapper(FileDocumentMapper.class);

    FileDocument toEntity(FileDocumentShort view);

    FileDocumentShort toShort(FileDocument entity);
}
