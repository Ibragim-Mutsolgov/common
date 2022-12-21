package vip.redcode.common.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.redcode.common.core.model.AddressToPeople;

import java.util.UUID;

@Repository
public interface AddressToPeopleRepository extends JpaRepository<AddressToPeople, UUID> {
}
