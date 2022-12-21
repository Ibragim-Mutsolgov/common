package vip.redcode.common.core.service;

import org.springframework.http.ResponseEntity;
import vip.redcode.common.core.model.Passport;

import java.util.List;
import java.util.UUID;

public interface PassportService {

    ResponseEntity<List<Passport>> findAll();

    ResponseEntity<Passport> findById(UUID id);

    ResponseEntity<Passport> save(Passport passport);

    ResponseEntity<Passport> putSave(UUID id, Passport passport);

    ResponseEntity<Passport> patchSave(UUID id, Passport passport);

    ResponseEntity<Passport> deleteById(UUID id);
}
