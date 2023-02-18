package backendspring.domain.repository;

import backendspring.domain.model.entity.FileDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FileDocumentRepository extends JpaRepository<FileDocument, Long>, QuerydslPredicateExecutor<FileDocument> {

}
