package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
	public Animal findById(Integer id);
}
