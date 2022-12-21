package vip.redcode.common.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.common.core.model.Passport;
import vip.redcode.common.core.model.People;
import vip.redcode.common.core.model.Policy;
import vip.redcode.common.core.model.Snils;
import vip.redcode.common.core.model.AddressToPeople;
import vip.redcode.common.core.repository.PassportRepository;
import vip.redcode.common.core.repository.PeopleRepository;
import vip.redcode.common.core.repository.PolicyRepository;
import vip.redcode.common.core.repository.SnilsRepository;
import vip.redcode.common.core.service.PeopleService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private PeopleRepository repository;

    private SnilsRepository snilsRepository;

    private PolicyRepository policyRepository;

    private PassportRepository passportRepository;

    @Override
    public ResponseEntity<List<People>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<People> findById(UUID id) {
        return repository.findById(id)
                .map(people -> ResponseEntity.ok().body(people))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<People> findByInn(Long inn) {
        return ResponseEntity.ok().body(repository.findByInn(inn));
    }

    @Override
    public ResponseEntity<List<People>> findByPassport(Long passportSeries, Long passportNumber) {
        List<People> peopleList = new ArrayList<>();
        for (Passport pass: passportRepository.findByPassportSeriesAndPassportNumber(passportSeries, passportNumber)) {
            peopleList.add(repository.findByPassport(pass));
        }
        return ResponseEntity.ok().body(peopleList);
    }

    @Override
    public ResponseEntity<List<People>> findByPolicy(String policy) {
        List<People> peopleList = new ArrayList<>();
        for (Policy pol: policyRepository.findByPolicy(policy)) {
            peopleList.add(repository.findByPolicy(pol));
        }
        return ResponseEntity.ok().body(peopleList);
    }

    @Override
    public ResponseEntity<List<People>> findBySnils(String snilsNumber) {
        List<People> peopleList = new ArrayList<>();
        for (Snils snils: snilsRepository.findBySnilsNumber(snilsNumber)) {
            peopleList.add(repository.findBySnils(snils));
        }
        return ResponseEntity.ok().body(peopleList);
    }

    @Override
    public ResponseEntity<People> save(People people) {
        People peopleSave = repository.save(people);
        return ResponseEntity.ok().body(peopleSave);
    }

    @Override
    public ResponseEntity<People> putSave(UUID id, People people) {
        return repository.findById(id)
                .map(peopleSave -> {
                    peopleSave.setId(id);
                    peopleSave.setFirstName(people.getFirstName());
                    peopleSave.setLastName(people.getLastName());
                    peopleSave.setMiddleName(people.getMiddleName());
                    peopleSave.setBirthDate(people.getBirthDate());
                    peopleSave.setGender(people.getGender());
                    peopleSave.setHeight(people.getHeight());
                    peopleSave.setWeight(people.getWeight());
                    peopleSave.setClothSize(people.getClothSize());
                    peopleSave.setFootSize(people.getFootSize());
                    peopleSave.setAdded(people.getAdded());
                    peopleSave.setInn(people.getInn());
                    peopleSave.setPassport(people.getPassport());
                    peopleSave.setPolicy(people.getPolicy());
                    peopleSave.setSnils(people.getSnils());
                    peopleSave.setAddressToPeople(people.getAddressToPeople());
                    return ResponseEntity.ok().body(repository.save(peopleSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<People> patchSave(UUID id, People people) {
        return repository.findById(id)
                .map(peopleSave -> {
                    if (people.getFirstName() != null) peopleSave.setFirstName(people.getFirstName());
                    if (people.getLastName() != null) peopleSave.setLastName(people.getLastName());
                    if (people.getMiddleName() != null) peopleSave.setMiddleName(people.getMiddleName());
                    if (people.getBirthDate() != null) peopleSave.setBirthDate(people.getBirthDate());
                    if (people.getGender() != 0) peopleSave.setGender(people.getGender());
                    if (people.getHeight() != null) peopleSave.setHeight(people.getHeight());
                    if (people.getWeight() != null) peopleSave.setWeight(people.getWeight());
                    if (people.getFootSize() != null) peopleSave.setFootSize(people.getFootSize());
                    if (people.getClothSize() != null) peopleSave.setClothSize(people.getClothSize());
                    if (people.getAdded() != null) peopleSave.setAdded(people.getAdded());
                    if (people.getInn() != null) peopleSave.setInn(people.getInn());
                    if (people.getPassport() != null) peopleSave.setPassport(people.getPassport());
                    if (people.getPolicy() != null) peopleSave.setPolicy(people.getPolicy());
                    if (people.getSnils() != null) peopleSave.setSnils(people.getSnils());
                    if (people.getAddressToPeople() != null) {
                        List<AddressToPeople> list = new ArrayList<>(people.getAddressToPeople());
                        peopleSave.setAddressToPeople(list);
                    }
                    return ResponseEntity.ok().body(repository.save(peopleSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<People> deleteById(UUID id) {
        return repository.findById(id)
                .map(people -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(people);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
