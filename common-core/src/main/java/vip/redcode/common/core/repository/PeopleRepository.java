package vip.redcode.common.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.redcode.common.core.model.Passport;
import vip.redcode.common.core.model.People;
import vip.redcode.common.core.model.Policy;
import vip.redcode.common.core.model.Snils;

import java.util.UUID;

@Repository
public interface PeopleRepository extends JpaRepository<People, UUID> {

    People findByInn(Long inn);

    People findByPassport(Passport passport);

    People findByPolicy(Policy policy);

    People findBySnils(Snils snils);
}
