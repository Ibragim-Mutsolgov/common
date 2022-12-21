package vip.redcode.common.core.service;

import org.springframework.http.ResponseEntity;
import vip.redcode.common.core.model.AddressToPeople;

import java.util.List;
import java.util.UUID;

public interface AddressToPeopleService {

    ResponseEntity<List<AddressToPeople>> findAll();

    ResponseEntity<AddressToPeople> findById(UUID id);

    ResponseEntity<AddressToPeople> save(AddressToPeople addressToPeople);

    ResponseEntity<AddressToPeople> putSave(UUID id, AddressToPeople addressToPeople);

    ResponseEntity<AddressToPeople> patchSave(UUID id, AddressToPeople addressToPeople);

    ResponseEntity<AddressToPeople> deleteById(UUID id);
}
