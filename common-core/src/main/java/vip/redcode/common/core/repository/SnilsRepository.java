package vip.redcode.common.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.redcode.common.core.model.Snils;

import java.util.List;
import java.util.UUID;

@Repository
public interface SnilsRepository extends JpaRepository<Snils, UUID> {

    List<Snils> findBySnilsNumber(String snilsNumber);
}
