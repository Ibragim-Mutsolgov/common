package vip.redcode.common.core.service;

import org.springframework.http.ResponseEntity;
import vip.redcode.common.core.model.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    ResponseEntity<List<Address>> findAll();

    ResponseEntity<Address> findById(UUID id);

    ResponseEntity<Address> save(Address address);

    ResponseEntity<Address> putSave(UUID id, Address address);

    ResponseEntity<Address> patchSave(UUID id, Address address);

    ResponseEntity<Address> deleteById(UUID id);
}
