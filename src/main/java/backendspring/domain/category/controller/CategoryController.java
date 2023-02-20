package backendspring.domain.category.controller;

import backendspring.domain.category.model.entity.Category;
import backendspring.domain.category.model.mapper.CategoryMapper;
import backendspring.domain.category.model.view.CategoryShort;
import backendspring.domain.category.repository.CategoryRepository;
import backendspring.infrasructure.filter.Filter;
import backendspring.infrasructure.filter.FilterToBooleanExpressionMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.Lists;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories", produces = "application/json")
public class CategoryController {

        private final CategoryRepository categoryRepository;

        private final FilterToBooleanExpressionMapper filterMapper;

        @GetMapping
        public List<Category> getCategories(Filter filter, Pageable pageable) {
            //BooleanExpression exp = filterMapper.toBooleanExpression(filter);
            Iterator<Category> categories = categoryRepository.findAll().iterator();
            return Lists.newArrayList(categories);
        }

        @GetMapping("/{id}")
        public CategoryShort getCategory(@PathVariable Long id) throws Exception {
            return CategoryMapper.INSTANCE.toShort(categoryRepository.findById(id)
                    .orElseThrow(() -> new Exception("Not found")));
        }

        @PostMapping()
        public Category postFileDocument(@RequestBody CategoryShort view) {
            var c = CategoryMapper.INSTANCE.toEntity(view);
            c.setId(null);
            c.setName(c.name);
            categoryRepository.save(c);
            return c;
        }

        @PutMapping("/{id}")
        public CategoryShort putDoc(
                @PathVariable Long id,
                @RequestBody CategoryShort view
        ) throws Exception {
            var entity = categoryRepository.findById(id).orElseThrow(() -> new Exception("Not found"));
            entity.setName(view.getName());
            categoryRepository.save(entity);
            return CategoryMapper.INSTANCE.toShort(entity);
        }
}