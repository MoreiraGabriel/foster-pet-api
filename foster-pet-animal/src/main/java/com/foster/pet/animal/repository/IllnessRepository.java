package com.foster.pet.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foster.pet.animal.entity.Illness;

public interface IllnessRepository extends JpaRepository<Illness, Long> {

	List<Illness> findByName(String name);
}
