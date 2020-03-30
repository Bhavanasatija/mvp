package org.ndhb.pycare.registration.repository;

import org.ndhb.pycare.registration.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    boolean existsByEmail(String email);
}
