package vip.redcode.common.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.common.core.model.Policy;
import vip.redcode.common.core.repository.PolicyRepository;
import vip.redcode.common.core.service.PolicyService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PolicyServiceImpl implements PolicyService {

    private PolicyRepository repository;

    @Override
    public ResponseEntity<List<Policy>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Policy> findById(UUID id) {
        return repository.findById(id)
                .map(policy -> ResponseEntity.ok().body(policy))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Policy> save(Policy policy) {
        Policy policySave = repository.save(policy);
        return ResponseEntity.ok().body(policySave);
    }

    @Override
    public ResponseEntity<Policy> putSave(UUID id, Policy policy) {
        return repository.findById(id)
                .map(policySave -> {
                    policySave.setId(policy.getId());
                    policySave.setPolicy(policy.getPolicy());
                    policySave.setTypePolicy(policy.getTypePolicy());
                    return ResponseEntity.ok().body(repository.save(policySave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Policy> patchSave(UUID id, Policy policy) {
        return repository.findById(id)
                .map(policySave -> {
                    if (policy.getPolicy() != null) policySave.setPolicy(policy.getPolicy());
                    if (policy.getTypePolicy() != null) policySave.setTypePolicy(policy.getTypePolicy());
                    return ResponseEntity.ok().body(repository.save(policySave));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Policy> deleteById(UUID id) {
        return repository.findById(id)
                .map(policy -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(policy);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
