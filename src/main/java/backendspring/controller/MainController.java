package backendspring.controller;

import backendspring.model.entity.FileDocument;
import backendspring.model.mapper.FileDocumentMapper;
import backendspring.model.view.FileDocumentShort;
import backendspring.repository.FileDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/main", produces = "application/json")
public class MainController {

    private final FileDocumentRepository fileDocumentRepository;

    @GetMapping
    public Page<FileDocument> getFileDocuments() {
        return null;
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