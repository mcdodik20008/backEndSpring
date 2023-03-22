package backendspring.domain.point.controller;

import backendspring.domain.point.model.entity.DeliveryPoint;
import backendspring.domain.point.model.view.DeliveryPointViewCreate;
import backendspring.domain.point.service.DeliveryPointService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "/delivery-point", produces = "application/json")
public class DeliveryPointController {

    DeliveryPointService service;


    @GetMapping
    public Page<DeliveryPoint> getPage(Pageable pageable) throws NoSuchFieldException {
        return service.getCategories(pageable);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public DeliveryPoint getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public DeliveryPoint create(@RequestBody DeliveryPointViewCreate view) {
        Long id = service.create(view);
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public DeliveryPoint update(@PathVariable Long id, @RequestBody DeliveryPointViewCreate view) {
        service.update(id, view);
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}