package com.johann.swampAPI.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.johann.swampAPI.domain.Agendamento;
import com.johann.swampAPI.repository.AgendamentoRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private AgendamentoRepository AgendamentoRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

		
		AgendamentoRepository.deleteAll();
		
		Agendamento maria = new Agendamento(null, "Maria Brown", "21/09/2024", "15:52", "descricao");
		Agendamento alex = new Agendamento(null, "Alex Green", "23/09/2024", "15:52", "descricao");
		Agendamento bob = new Agendamento(null, "Bob Grey", "25/09/2024", "13:30", "descricao");

		
		AgendamentoRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
