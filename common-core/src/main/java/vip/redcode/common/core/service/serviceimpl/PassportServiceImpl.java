package vip.redcode.common.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.common.core.model.Passport;
import vip.redcode.common.core.repository.PassportRepository;
import vip.redcode.common.core.service.PassportService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PassportServiceImpl implements PassportService {

    private PassportRepository repository;

    @Override
    public ResponseEntity<List<Passport>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Passport> findById(UUID id) {
        return repository.findById(id)
                .map(passport -> ResponseEntity.ok().body(passport))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Passport> save(Passport passport) {
        Passport passportSave = repository.save(passport);
        return ResponseEntity.ok().body(passportSave);
    }

    @Override
    public ResponseEntity<Passport> putSave(UUID id, Passport passport) {
        return repository.findById(id)
                .map(passportSave -> {
                    passportSave.setId(id);
                    passportSave.setDate(passport.getDate());
                    passportSave.setGender(passport.getGender());
                    passportSave.setPlaceBirth(passport.getPlaceBirth());
                    passportSave.setPassportSeries(passport.getPassportSeries());
                    passportSave.setPassportNumber(passport.getPassportNumber());
                    passportSave.setPassportIssue(passport.getPassportIssue());
                    passportSave.setDateIssue(passport.getDateIssue());
                    passportSave.setDepartmentCode(passport.getDepartmentCode());
                    return ResponseEntity.ok().body(repository.save(passportSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Passport> patchSave(UUID id, Passport passport) {
        return repository.findById(id)
                .map(passportSave -> {
                    if (passport.getDate() != null) passportSave.setDate(passport.getDate());
                    if (passport.getGender() != 0) passportSave.setGender(passport.getGender());
                    if (passport.getPlaceBirth() != null) passportSave.setPlaceBirth(passport.getPlaceBirth());
                    if (passport.getPassportSeries() != null) passportSave.setPassportSeries(passport.getPassportSeries());
                    if (passport.getPassportNumber() != null) passportSave.setPassportNumber(passport.getPassportNumber());
                    if (passport.getPassportIssue() != null) passportSave.setPassportIssue(passport.getPassportIssue());
                    if (passport.getDateIssue() != null) passportSave.setDateIssue(passport.getDateIssue());
                    if (passport.getDepartmentCode() != null) passportSave.setDepartmentCode(passport.getDepartmentCode());
                    return ResponseEntity.ok().body(repository.save(passportSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Passport> deleteById(UUID id) {
        return repository.findById(id)
                .map(passport -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(passport);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
