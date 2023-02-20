package backendspring.infrasructure.abstractclass.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
public abstract class AbstractFile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "file_path", unique = true)
    public String filePath;

    @Column(name = "name")
    public String name;

    @Column(name = "mime_type")
    public String mimeType;

    @Column(name = "file_extension")
    public String fileExtension;

    @Column(name = "file_size")
    public Long size;

    @Column(name = "upload_date")
    public LocalDate date;
}
