package backendspring.infrasructure.filter;

import backendspring.domain.model.entity.FileDocument;

public @interface FilterParam {

    Class<FileDocument> cls();

}
