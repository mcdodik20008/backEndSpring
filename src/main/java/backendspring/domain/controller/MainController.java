package backendspring.domain.controller;

import backendspring.domain.model.entity.FileDocument;
import backendspring.domain.model.entity.QFileDocument;
import backendspring.domain.model.mapper.FileDocumentMapper;
import backendspring.domain.model.view.FileDocumentShort;
import backendspring.domain.repository.FileDocumentRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/main", produces = "application/json")
public class MainController {

    private final FileDocumentRepository fileDocumentRepository;

    @GetMapping
    public List<FileDocument> getFileDocuments(
//            @FilterParam(cls = FileDocument.class) BooleanExpression filter,
//            Pageable pageable
    ) {
        var q = QFileDocument.fileDocument.id.eq(1L).or(QFileDocument.fileDocument.id.eq(2L));
        var xx = fileDocumentRepository.findAll(q);
        return Lists.newArrayList(xx);
    }

    @GetMapping("/{id}")
    public FileDocumentShort getFileDocument(@PathVariable Long id) throws Exception {
        return FileDocumentMapper.INSTANCE.toShort(fileDocumentRepository.findById(id)
                .orElseThrow(() -> new Exception("Дамой бро")));
    }

    @PostMapping()
    public FileDocument postFileDocument(@RequestBody FileDocumentShort view) {
        var fd = FileDocumentMapper.INSTANCE.toEntity(view);
        fd.setId(null);
        fd.setFileType("txt");
        fileDocumentRepository.save(fd);
        return fd;
    }

    @PutMapping("/{id}")
    public FileDocumentShort putDoc(
            @PathVariable Long id,
            @RequestBody FileDocumentShort view
    ) throws Exception {
        var entity = fileDocumentRepository.findById(id).orElseThrow(() -> new Exception("Дамой бро"));
        entity.setName(view.getName());
        entity.setFileType(view.getFileType());
        fileDocumentRepository.save(entity);
        return FileDocumentMapper.INSTANCE.toShort(entity);
    }
}