package com.a100.librarymanagement.repository;

import com.a100.librarymanagement.entity.User;
import com.a100.librarymanagement.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);

    List<User> findByFullNameContainingIgnoreCase(String fullName);

    boolean existsByEmail(String email);

}