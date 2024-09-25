package com.johann.swampAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johann.swampAPI.domain.Agendamento;
import com.johann.swampAPI.dto.AgendamentoDTO;
import com.johann.swampAPI.repository.AgendamentoRepository;
import com.johann.swampAPI.services.exception.ObjectNotFoundException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repo;
	
	public List<Agendamento> findAll() {
		return repo.findAll();
	}
	
	public Agendamento findById(String id) {
		Optional<Agendamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public Agendamento insert(Agendamento obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Agendamento update(Agendamento obj) {
		Agendamento newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Agendamento newObj, Agendamento obj) {
		newObj.setName(obj.getName());
		newObj.setDate(obj.getDate());
		newObj.setHour(obj.getHour());
		newObj.setDescricao(obj.getDescricao());
		
		
		
	}

	public Agendamento fromDTO(AgendamentoDTO objDto) {
		return new Agendamento(objDto.getId(), objDto.getName(), objDto.getDate(), objDto.getHour(), objDto.getHour());
	}
}
