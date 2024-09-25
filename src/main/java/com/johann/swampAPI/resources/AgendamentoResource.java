package com.johann.swampAPI.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.johann.swampAPI.domain.Agendamento;
import com.johann.swampAPI.dto.AgendamentoDTO;
import com.johann.swampAPI.services.AgendamentoService;


@RestController
@RequestMapping(value="/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService service;
	
	
	@GetMapping
	public ResponseEntity<List<AgendamentoDTO>>  findAll() {
		List<Agendamento> list = service.findAll();
		List<AgendamentoDTO> listDto = list.stream().map(x -> new AgendamentoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<AgendamentoDTO>  findById(@PathVariable String id) {
		Agendamento obj = service.findById(id);
		return ResponseEntity.ok().body(new AgendamentoDTO(obj));
	}
	
	@PostMapping()
	public ResponseEntity<Void>  insert(@RequestBody AgendamentoDTO objDto) {
		Agendamento obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}		
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void>  delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void>  update(@RequestBody AgendamentoDTO objDto, @PathVariable String id) {
		Agendamento obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}		
	
}
