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
import vip.redcode.common.core.model.Address;
import vip.redcode.common.core.service.AddressService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private AddressService service;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Address> save(@RequestBody Address address) {
        return service.save(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> putSave(@PathVariable UUID id, @RequestBody Address address) {
        return service.putSave(id, address);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Address> patchSave(@PathVariable UUID id, @RequestBody Address address) {
        return service.patchSave(id, address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Address> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
