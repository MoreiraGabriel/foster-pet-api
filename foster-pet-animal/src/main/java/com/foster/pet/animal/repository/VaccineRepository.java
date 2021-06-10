package com.foster.pet.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foster.pet.animal.entity.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

	List<Vaccine> findByName(String name);
}
