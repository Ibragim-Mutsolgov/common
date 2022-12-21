package vip.redcode.common.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.common.core.model.Snils;
import vip.redcode.common.core.repository.SnilsRepository;
import vip.redcode.common.core.service.SnilsService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class SnilsServiceImpl implements SnilsService {

    private SnilsRepository repository;

    @Override
    public ResponseEntity<List<Snils>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Snils> findById(UUID id) {
        return repository.findById(id)
                .map(snils -> ResponseEntity.ok().body(snils))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Snils> save(Snils snils) {
        Snils snilsSave = repository.save(snils);
        return ResponseEntity.ok().body(snilsSave);
    }

    @Override
    public ResponseEntity<Snils> putSave(UUID id, Snils snils) {
        return repository.findById(id)
                .map(snilsSave -> {
                    snilsSave.setId(snils.getId());
                    snilsSave.setSnilsNumber(snils.getSnilsNumber());
                    return ResponseEntity.ok().body(repository.save(snilsSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Snils> patchSave(UUID id, Snils snils) {
        return repository.findById(id)
                .map(snilsSave -> {
                    if (snils.getSnilsNumber() != null) snilsSave.setSnilsNumber(snils.getSnilsNumber());
                    return ResponseEntity.ok().body(repository.save(snilsSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Snils> deleteById(UUID id) {
        return repository.findById(id)
                .map(snils -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(snils);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
