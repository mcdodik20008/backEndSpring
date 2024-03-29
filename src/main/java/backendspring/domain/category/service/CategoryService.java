package backendspring.domain.category.service;

import backendspring.domain.category.model.entity.Category;
import backendspring.domain.category.model.mapper.CategoryMapper;
import backendspring.domain.category.model.view.CategoryViewCreate;
import backendspring.domain.category.model.view.CategoryViewRead;
import backendspring.domain.category.repository.CategoryRepository;
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
public class CategoryService {

    CategoryRepository repository;

    CategoryMapper mapper = CategoryMapper.INSTANCE;

    public Page<CategoryViewRead> getCategories(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toViewRead);
    }

    public CategoryViewRead getOne(Long id) {
        return mapper.toViewRead(getObject(id));
    }

    public Long create(CategoryViewCreate view) {
        var entity = mapper.fromViewCreate(view);
        return repository.save(entity).getId();
    }

    public void update(Long id, CategoryViewCreate view) {
        var entity = mapper.fromViewCreate(getObject(id), view);
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private Category getObject(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Не найдена категория с идентификатором " + id));
    }
}
