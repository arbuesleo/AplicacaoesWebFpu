package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Candidato;

public interface CanditatoRepository extends CrudRepository<Candidato, Integer> {
	public  Candidato findByNumero(Integer numero);
	public  Candidato findById(Integer id);
	public  List<Candidato> findAllByOrderByVotosDesc();
}
