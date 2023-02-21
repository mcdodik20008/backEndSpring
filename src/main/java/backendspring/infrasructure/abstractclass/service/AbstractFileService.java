package backendspring.infrasructure.abstractclass.service;

import backendspring.infrasructure.abstractclass.model.entity.AbstractFile;
import backendspring.infrasructure.filter.Filter;
import backendspring.infrasructure.filter.FilterToBooleanExpressionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AbstractFileService<T extends JpaRepository> {

    private T repository;

    private final FilterToBooleanExpressionMapper mapper;

    public Page<AbstractFile> getPage(Filter filter, Pageable pageable) {
        return repository.findAll(pageable);
    }

}
