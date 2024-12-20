package com.airline.airline.repositories;

import com.airline.airline.entities.ERole;
import com.airline.airline.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
