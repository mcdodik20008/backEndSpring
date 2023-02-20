package backendspring.infrasructure.abstractclass.controller;

import backendspring.infrasructure.abstractclass.model.entity.AbstractFile;
import backendspring.infrasructure.abstractclass.service.AbstractFileService;
import backendspring.infrasructure.filter.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/abstracttest", produces = "application/json")
public class AbstractFileController {
    private final AbstractFileService service;

    @GetMapping
    public Page<AbstractFile> getPage(Filter filter, Pageable pageable) {
        return service.getPage(filter, pageable);
    }
}

