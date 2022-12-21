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
import org.springframework.web.bind.annotation.CrossOrigin;
import vip.redcode.common.core.model.People;
import vip.redcode.common.core.service.PeopleService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/people")
@CrossOrigin("http://localhost:59081")
public class PeopleController {

    private PeopleService service;

    @GetMapping
    public ResponseEntity<List<People>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/inn/{inn}")
    public ResponseEntity<People> findByInn(@PathVariable Long inn) {
        return service.findByInn(inn);
    }

    @GetMapping("/passport/{passportSeries}/{passportNumber}")
    public ResponseEntity<List<People>> findByPassport(@PathVariable Long passportSeries,
                                                       @PathVariable Long passportNumber) {
        return service.findByPassport(passportSeries, passportNumber);
    }

    @GetMapping("/policy/{policy}")
    public ResponseEntity<List<People>> findByPolicy(@PathVariable String policy) {
        return service.findByPolicy(policy);
    }

    @GetMapping("/snils/{snilsNumber}")
    public ResponseEntity<List<People>> findBySnils(@PathVariable String snilsNumber) {
        return service.findBySnils(snilsNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<People> save(@RequestBody People people) {
        return service.save(people);
    }

    @PutMapping("/{id}")
    public ResponseEntity<People> putSave(@PathVariable UUID id, @RequestBody People people) {
        return service.putSave(id, people);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<People> patchSave(@PathVariable UUID id, @RequestBody People people) {
        return service.patchSave(id, people);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<People> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
