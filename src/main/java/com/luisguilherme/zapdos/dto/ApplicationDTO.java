package com.luisguilherme.zapdos.dto;

import java.util.Objects;

import com.luisguilherme.zapdos.entities.Application;

public class ApplicationDTO {

	private Long id;
	private String note;
	private String year;

	private ModelDTO model;

	private PartDTO part;

	public ApplicationDTO() {

	}

	public ApplicationDTO(Long id, String note, String year, ModelDTO model, PartDTO part) {
		this.id = id;
		this.note = note;
		this.year = year;
		this.model = model;
		this.part = part;
	}

	public ApplicationDTO(Application entity) {
		id = entity.getId();
		note = entity.getNote();
		year = entity.getYear();
		model = new ModelDTO(entity.getModel());
		part = new PartDTO(entity.getPart());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ModelDTO getModel() {
		return model;
	}

	public void setModel(ModelDTO model) {
		this.model = model;
	}

	public PartDTO getPart() {
		return part;
	}

	public void setPart(PartDTO part) {
		this.part = part;
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
		ApplicationDTO other = (ApplicationDTO) obj;
		return Objects.equals(id, other.id);
	}

}
