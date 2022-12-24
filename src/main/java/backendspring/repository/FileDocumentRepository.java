package backendspring.repository;

import backendspring.model.entity.FileDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDocumentRepository extends JpaRepository<FileDocument, Long>{

}
