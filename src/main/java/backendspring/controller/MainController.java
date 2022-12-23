package backendspring.controller;

import backendspring.model.entity.FileDocument;
import backendspring.repository.FileDocumentRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/main", produces = "application/json")
public class MainController{

    private final FileDocumentRepository fileDocumentRepository;

    public MainController(FileDocumentRepository fileDocumentRepository) {
        this.fileDocumentRepository = fileDocumentRepository;
    }

    @GetMapping
    public Page<FileDocument> getFileDocuments(Page page){
        return null;
    }

    @GetMapping("/{id}")
    public FileDocument getFileDocument(@PathVariable int id){
        var fd = new FileDocument();
        fd.setName("апчихба");
        fd.setFilePath("C://апчихба");
        fd.setFileType("txt");
        fileDocumentRepository.save(fd);
        return fd;
    }

    @PostMapping("/{id}")
    public FileDocument postFileDocument(@PathVariable int id){
        return null;
    }

    @PutMapping("/{id}")
    public FileDocument putDoc(@PathVariable int id){
        return null;
    }
}