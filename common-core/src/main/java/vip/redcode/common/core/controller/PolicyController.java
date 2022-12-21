package vip.redcode.common.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vip.redcode.common.core.model.Policy;
import vip.redcode.common.core.service.PolicyService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/policy")
public class PolicyController {

    private PolicyService service;

    @GetMapping
    public ResponseEntity<List<Policy>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Policy> save(@RequestBody Policy policy) {
        return service.save(policy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> putSave(@PathVariable UUID id, @RequestBody Policy policy) {
        return service.putSave(id, policy);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Policy> patchSave(@PathVariable UUID id, @RequestBody Policy policy) {
        return service.patchSave(id, policy);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Policy> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
