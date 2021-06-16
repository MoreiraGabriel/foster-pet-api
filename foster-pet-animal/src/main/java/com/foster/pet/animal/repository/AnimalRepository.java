package com.foster.pet.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foster.pet.animal.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

	List<Animal> findByName(String name);

	@Query(value = "SELECT * FROM animal a WHERE a.animal_type =:type ", nativeQuery = true)
	List<Animal> findByAnimalType(@Param("type") String type);
}
