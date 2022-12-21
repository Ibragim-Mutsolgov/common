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
import vip.redcode.common.core.model.Passport;
import vip.redcode.common.core.service.PassportService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/passport")
public class PassportController {

    private PassportService service;

    @GetMapping
    public ResponseEntity<List<Passport>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Passport> save(@RequestBody Passport passport) {
        return service.save(passport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passport> putSave(@PathVariable UUID id, @RequestBody Passport passport) {
        return service.putSave(id, passport);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Passport> patchSave(@PathVariable UUID id, @RequestBody Passport passport) {
        return service.patchSave(id, passport);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Passport> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
