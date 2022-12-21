package vip.redcode.common.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.common.core.model.Address;
import vip.redcode.common.core.model.AddressToPeople;
import vip.redcode.common.core.model.People;
import vip.redcode.common.core.repository.AddressToPeopleRepository;
import vip.redcode.common.core.service.AddressToPeopleService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AddressToPeopleServiceImpl implements AddressToPeopleService {

    private AddressToPeopleRepository repository;

    @Override
    public ResponseEntity<List<AddressToPeople>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<AddressToPeople> findById(UUID id) {
        return repository.findById(id)
                .map(addressToPeople -> {
                    return ResponseEntity.ok().body(addressToPeople);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<AddressToPeople> save(AddressToPeople addressToPeople) {
        AddressToPeople addressToPeopleSave = repository.save(addressToPeople);
        return ResponseEntity.ok().body(addressToPeopleSave);
    }

    @Override
    public ResponseEntity<AddressToPeople> putSave(UUID id, AddressToPeople addressToPeople) {
        return repository.findById(id)
                .map(addressToPeopleSave -> {
                    addressToPeopleSave.setId(id);
                    addressToPeopleSave.setPeople(addressToPeople.getPeople());
                    addressToPeopleSave.setAddress(addressToPeople.getAddress());
                    addressToPeopleSave.setAddressType(addressToPeople.getAddressType());
                    return ResponseEntity.ok().body(repository.save(addressToPeopleSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<AddressToPeople> patchSave(UUID id, AddressToPeople addressToPeople) {
        return repository.findById(id)
                .map(addressToPeopleSave -> {
                    if (addressToPeople.getPeople() != null) {
                        People people = new People();
                        if (addressToPeople.getPeople().getFirstName() != null) people.setFirstName(addressToPeople.getPeople().getFirstName());
                        if (addressToPeople.getPeople().getLastName() != null) people.setLastName(addressToPeople.getPeople().getLastName());
                        if (addressToPeople.getPeople().getMiddleName() != null) people.setMiddleName(addressToPeople.getPeople().getMiddleName());
                        if (addressToPeople.getPeople().getBirthDate() != null) people.setBirthDate(addressToPeople.getPeople().getBirthDate());
                        if (addressToPeople.getPeople().getGender() != null) people.setGender(addressToPeople.getPeople().getGender());
                        if (addressToPeople.getPeople().getHeight() != null) people.setHeight(addressToPeople.getPeople().getHeight());
                        if (addressToPeople.getPeople().getWeight() != null) people.setWeight(addressToPeople.getPeople().getWeight());
                        if (addressToPeople.getPeople().getClothSize() != null) people.setClothSize(addressToPeople.getPeople().getClothSize());
                        if (addressToPeople.getPeople().getFootSize() != null) people.setFootSize(addressToPeople.getPeople().getFootSize());
                        if (addressToPeople.getPeople().getAdded() != null) people.setAdded(addressToPeople.getPeople().getAdded());
                        if (addressToPeople.getPeople().getInn() != null) people.setInn(addressToPeople.getPeople().getInn());
                        if (addressToPeople.getPeople().getPassport() != null) people.setPassport(addressToPeople.getPeople().getPassport());
                        if (addressToPeople.getPeople().getPolicy() != null) people.setPolicy(addressToPeople.getPeople().getPolicy());
                        if (addressToPeople.getPeople().getSnils() != null) people.setSnils(addressToPeople.getPeople().getSnils());
                        if (!addressToPeople.getPeople().getAddressToPeople().isEmpty()) {
                            List<AddressToPeople> addresses = new ArrayList<>(addressToPeople.getPeople().getAddressToPeople());
                            people.setAddressToPeople(addresses);
                        }
                        addressToPeopleSave.setPeople(people);
                    }
                    if (addressToPeople.getAddress() != null) {
                        Address address = new Address();
                        if (!addressToPeople.getAddress().getAddressToPeople().isEmpty()) {
                            List<AddressToPeople> addresses = new ArrayList<>(addressToPeople.getAddress().getAddressToPeople());
                            address.setAddressToPeople(addresses);
                        }
                        if (addressToPeople.getAddress().getCountry() != null) address.setCountry(addressToPeople.getAddress().getCountry());
                        if (addressToPeople.getAddress().getRegion() != null) address.setRegion(addressToPeople.getAddress().getRegion());
                        if (addressToPeople.getAddress().getLocality() != null) address.setLocality(addressToPeople.getAddress().getLocality());
                        if (addressToPeople.getAddress().getCity() != null) address.setCity(addressToPeople.getAddress().getCity());
                        if (addressToPeople.getAddress().getNeighborhood() != null) address.setNeighborhood(addressToPeople.getAddress().getNeighborhood());
                        if (addressToPeople.getAddress().getStreet() != null) address.setStreet(addressToPeople.getAddress().getStreet());
                        if (addressToPeople.getAddress().getHouse() != null) address.setHouse(addressToPeople.getAddress().getHouse());
                        if (addressToPeople.getAddress().getStructure() != null) address.setStructure(addressToPeople.getAddress().getStructure());
                        if (addressToPeople.getAddress().getEntrance() != null) address.setEntrance(addressToPeople.getAddress().getEntrance());
                        if (addressToPeople.getAddress().getFloor() != null) address.setFloor(addressToPeople.getAddress().getFloor());
                        if (addressToPeople.getAddress().getFlat() != null) address.setFlat(addressToPeople.getAddress().getFlat());
                        addressToPeopleSave.setAddress(address);
                    }
                    if (addressToPeople.getAddressType() != null) addressToPeopleSave.setAddressType(addressToPeople.getAddressType());
                    return ResponseEntity.ok().body(repository.save(addressToPeopleSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<AddressToPeople> deleteById(UUID id) {
        return repository.findById(id)
                .map(addressToPeople -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(addressToPeople);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
