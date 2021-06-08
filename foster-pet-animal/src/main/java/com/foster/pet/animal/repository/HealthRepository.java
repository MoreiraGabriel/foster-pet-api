package com.foster.pet.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foster.pet.animal.entity.Health;

@Repository
public interface HealthRepository extends JpaRepository<Health, Long> {

}
