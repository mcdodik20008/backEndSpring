package backendspring.domain.subcategory.service;

import backendspring.domain.subcategory.model.entity.SubCategory;
import backendspring.domain.subcategory.model.mapper.SubCategoryMapper;
import backendspring.domain.subcategory.model.view.SubCategoryViewCreate;
import backendspring.domain.subcategory.model.view.SubCategoryViewRead;
import backendspring.domain.subcategory.repository.SubCategoryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubCategoryService {

    SubCategoryRepository repository;

    SubCategoryMapper mapper = SubCategoryMapper.INSTANCE;

    public Page<SubCategoryViewRead> getCategories(BooleanExpression expression, Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toViewRead);
    }

    public SubCategoryViewRead getOne(Long id) {
        return mapper.toViewRead(getObject(id));
    }

    public Long create(SubCategoryViewCreate view) {
        var entity = mapper.fromViewCreate(view);
        return repository.save(entity).getId();
    }

    public void update(Long id, SubCategoryViewCreate view) {
        var entity = getObject(id);
        mapper.fromViewCreate(entity, view);
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private SubCategory getObject(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Не найдена категория с идентификатором " + id));
    }
}
