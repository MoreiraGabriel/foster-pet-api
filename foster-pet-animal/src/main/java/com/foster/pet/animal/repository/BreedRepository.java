package com.foster.pet.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foster.pet.animal.entity.Breed;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long>{

	List<Breed> findByName(String name);
}
