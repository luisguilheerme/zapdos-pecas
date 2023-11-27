package com.luisguilherme.zapdos.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.luisguilherme.zapdos.entities.Brand;
import com.luisguilherme.zapdos.entities.Part;

import jakarta.validation.constraints.NotBlank;

public class BrandDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;

	private List<PartDTO> parts = new ArrayList<>();

	public BrandDTO() {

	}

	public BrandDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public BrandDTO(Brand entity) {
		id = entity.getId();
		name = entity.getName();
		for (Part p : entity.getParts()) {
			parts.add(new PartDTO(p));
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

	public List<PartDTO> getParts() {
		return parts;
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
		BrandDTO other = (BrandDTO) obj;
		return Objects.equals(id, other.id);
	}

}
