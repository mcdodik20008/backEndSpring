package backendspring.domain.point.service;

import backendspring.domain.point.model.entity.DeliveryPoint;
import backendspring.domain.point.model.mapper.DeliveryPointMapper;
import backendspring.domain.point.model.view.DeliveryPointViewCreate;
import backendspring.domain.point.repository.DeliveryPointRepository;
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
public class DeliveryPointService {

    DeliveryPointRepository repository;
    DeliveryPointMapper mapper = DeliveryPointMapper.INSTANCE;

    public Page<DeliveryPoint> getCategories(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public DeliveryPoint getOne(Long id) {
        return getObject(id);
    }

    public Long create(DeliveryPointViewCreate view) {
        var entity = mapper.fromViewCreate(view);
        return repository.save(entity).getId();
    }

    public void update(Long id, DeliveryPointViewCreate view) {
        var entity = mapper.fromViewCreate( getObject(id), view);
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private DeliveryPoint getObject(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Не найдена категория с идентификатором " + id));
    }
}
