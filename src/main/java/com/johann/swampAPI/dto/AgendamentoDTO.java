package com.johann.swampAPI.dto;

import java.io.Serializable;

import com.johann.swampAPI.domain.Agendamento;

public class AgendamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String date;
	private String hour;
	private String descricao;
	
	public AgendamentoDTO() {
	}
	
	public AgendamentoDTO(Agendamento obj) {
		id = obj.getId();
		name = obj.getName();
		date = obj.getDate();
		hour = obj.getHour();
		descricao = obj.getDescricao();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	
	
	
}
