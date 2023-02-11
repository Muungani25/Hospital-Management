package com.hms.system.hms.persistence;

import com.hms.system.hms.domain.ERole;
import com.hms.system.hms.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Optional<Role> findByName(ERole role);
}
