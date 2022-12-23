package backendspring.repository;

import backendspring.model.entity.FileDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FileDocumentRepository extends JpaRepository<FileDocument, Long> {

}
