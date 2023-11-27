package com.luisguilherme.zapdos.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.luisguilherme.zapdos.entities.Application;
import com.luisguilherme.zapdos.entities.Model;

public class ModelDTO {

	private Long id;
	private String name;

	private MakeDTO make;

	private List<ApplicationDTO> applications = new ArrayList<>();

	public ModelDTO() {

	}

	public ModelDTO(Long id, String name, MakeDTO make) {
		this.id = id;
		this.name = name;
		this.make = make;
	}

	public ModelDTO(Model entity) {
		id = entity.getId();
		name = entity.getName();
		make = new MakeDTO(entity.getMake());
		for (Application a : entity.getApplications()) {
			applications.add(new ApplicationDTO(a));
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

	public MakeDTO getMake() {
		return make;
	}

	public void setMake(MakeDTO make) {
		this.make = make;
	}

	public List<ApplicationDTO> getApplications() {
		return applications;
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
		ModelDTO other = (ModelDTO) obj;
		return Objects.equals(id, other.id);
	}

}
