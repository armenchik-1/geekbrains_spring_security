package com.example.geekbrains_spring_security.repositories;

import com.example.geekbrains_spring_security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
