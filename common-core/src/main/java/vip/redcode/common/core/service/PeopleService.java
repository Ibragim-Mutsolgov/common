package vip.redcode.common.core.service;

import org.springframework.http.ResponseEntity;
import vip.redcode.common.core.model.People;

import java.util.List;
import java.util.UUID;

public interface PeopleService {

    ResponseEntity<List<People>> findAll();

    ResponseEntity<People> findById(UUID id);

    ResponseEntity<People> findByInn(Long inn);

    ResponseEntity<List<People>> findByPassport(Long passportSeries, Long passportNumber);

    ResponseEntity<List<People>> findByPolicy(String policy);

    ResponseEntity<List<People>> findBySnils(String snilsNumber);

    ResponseEntity<People> save(People people);

    ResponseEntity<People> putSave(UUID id, People people);

    ResponseEntity<People> patchSave(UUID id, People people);

    ResponseEntity<People> deleteById(UUID id);
}
