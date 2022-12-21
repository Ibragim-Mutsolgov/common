package vip.redcode.common.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.redcode.common.core.model.Passport;

import java.util.List;
import java.util.UUID;

@Repository
public interface PassportRepository extends JpaRepository<Passport, UUID> {
    List<Passport> findByPassportSeriesAndPassportNumber(Long passportSeries, Long passportNumber);
}
