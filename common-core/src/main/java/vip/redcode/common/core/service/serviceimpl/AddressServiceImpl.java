package vip.redcode.common.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.common.core.model.Address;
import vip.redcode.common.core.model.AddressToPeople;
import vip.redcode.common.core.repository.AddressRepository;
import vip.redcode.common.core.service.AddressService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    @Override
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Address> findById(UUID id) {
        return repository.findById(id)
                .map(address -> ResponseEntity.ok().body(address))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Address> save(Address address) {
        Address addressSave = repository.save(address);
        return ResponseEntity.ok().body(addressSave);
    }

    @Override
    public ResponseEntity<Address> putSave(UUID id, Address address) {
        return repository.findById(id)
                .map(addressSave -> {
                    addressSave.setId(id);
                    addressSave.setAddressToPeople(address.getAddressToPeople());
                    addressSave.setCountry(address.getCountry());
                    addressSave.setRegion(address.getRegion());
                    addressSave.setLocality(address.getLocality());
                    addressSave.setCity(address.getCity());
                    addressSave.setNeighborhood(address.getNeighborhood());
                    addressSave.setStreet(address.getStreet());
                    addressSave.setHouse(address.getHouse());
                    addressSave.setStructure(address.getStructure());
                    addressSave.setEntrance(address.getEntrance());
                    addressSave.setFloor(address.getFloor());
                    addressSave.setFlat(address.getFlat());
                    return ResponseEntity.ok().body(repository.save(addressSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Address> patchSave(UUID id, Address address) {
        return repository.findById(id)
                .map(addressSave -> {
                    if (!address.getAddressToPeople().isEmpty()) {
                        List<AddressToPeople> addressList = new ArrayList<>(address.getAddressToPeople());
                        addressSave.setAddressToPeople(addressList);
                    }
                    if (address.getCountry() != null) addressSave.setCountry(address.getCountry());
                    if (address.getRegion() != null) addressSave.setRegion(address.getRegion());
                    if (address.getLocality() != null) addressSave.setLocality(address.getLocality());
                    if (address.getCity() != null) addressSave.setCity(address.getCity());
                    if (address.getNeighborhood() != null) addressSave.setNeighborhood(address.getNeighborhood());
                    if (address.getStreet() != null) addressSave.setStreet(address.getStreet());
                    if (address.getHouse() != null) addressSave.setHouse(address.getHouse());
                    if (address.getStructure() != null) addressSave.setStructure(address.getStructure());
                    if (address.getEntrance() != null) addressSave.setEntrance(address.getEntrance());
                    if (address.getFloor() != null) addressSave.setFloor(address.getFloor());
                    if (address.getFlat() != null) addressSave.setFlat(address.getFlat());
                    return ResponseEntity.ok().body(repository.save(addressSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Address> deleteById(UUID id) {
        return repository.findById(id)
                .map(address -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(address);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
