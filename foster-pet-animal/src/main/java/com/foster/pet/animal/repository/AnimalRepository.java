package com.foster.pet.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foster.pet.animal.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

	List<Animal> findByName(String name);
}
