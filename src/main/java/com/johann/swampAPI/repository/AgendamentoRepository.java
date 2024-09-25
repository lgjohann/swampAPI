package com.johann.swampAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.johann.swampAPI.domain.Agendamento;

@Repository
public interface AgendamentoRepository extends MongoRepository<Agendamento, String>{

}
