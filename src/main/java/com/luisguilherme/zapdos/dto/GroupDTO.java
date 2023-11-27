package com.luisguilherme.zapdos.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.luisguilherme.zapdos.entities.Group;
import com.luisguilherme.zapdos.entities.Subgroup;

public class GroupDTO {

	private Long id;
	private String name;

	private List<SubgroupDTO> subgroups = new ArrayList<>();

	public GroupDTO() {

	}

	public GroupDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public GroupDTO(Group entity) {
		id = entity.getId();
		name = entity.getName();
		for (Subgroup s : entity.getSubgroup()) {
			subgroups.add(new SubgroupDTO(s));
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

	public List<SubgroupDTO> getSubgroups() {
		return subgroups;
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
		GroupDTO other = (GroupDTO) obj;
		return Objects.equals(id, other.id);
	}

}
