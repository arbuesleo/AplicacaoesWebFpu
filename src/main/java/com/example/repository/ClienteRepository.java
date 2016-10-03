package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
