package com.luisguilherme.zapdos.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.luisguilherme.zapdos.entities.Part;
import com.luisguilherme.zapdos.entities.Subgroup;

public class SubgroupDTO {

	private Long id;
	private String name;

	private GroupDTO group;

	private List<PartDTO> parts = new ArrayList<>();

	public SubgroupDTO() {

	}

	public SubgroupDTO(Long id, String name, GroupDTO group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public SubgroupDTO(Subgroup entity) {
		id = entity.getId();
		name = entity.getName();
		group = new GroupDTO(entity.getGroup());
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

	public GroupDTO getGroup() {
		return group;
	}

	public void setGroup(GroupDTO group) {
		this.group = group;
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
		SubgroupDTO other = (SubgroupDTO) obj;
		return Objects.equals(id, other.id);
	}

}
