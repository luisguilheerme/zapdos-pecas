package com.luisguilherme.zapdos.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.luisguilherme.zapdos.entities.Make;
import com.luisguilherme.zapdos.entities.Model;

import jakarta.validation.constraints.NotBlank;

public class MakeDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;

	private List<ModelDTO> models = new ArrayList<>();

	public MakeDTO() {

	}

	public MakeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public MakeDTO(Make entity) {
		id = entity.getId();
		name = entity.getName();
		for (Model m : entity.getModels()) {
			models.add(new ModelDTO(m));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ModelDTO> getModels() {
		return models;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MakeDTO other = (MakeDTO) obj;
		return Objects.equals(id, other.id);
	}

}
