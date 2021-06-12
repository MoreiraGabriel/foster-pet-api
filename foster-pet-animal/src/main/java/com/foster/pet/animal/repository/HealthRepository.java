package com.foster.pet.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foster.pet.animal.entity.Health;

@Repository
public interface HealthRepository extends JpaRepository<Health, Long> {

	List<Health> findByAnimal_Name(String name);
}
