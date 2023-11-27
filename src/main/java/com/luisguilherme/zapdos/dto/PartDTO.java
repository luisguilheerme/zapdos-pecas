package com.luisguilherme.zapdos.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.luisguilherme.zapdos.entities.Application;
import com.luisguilherme.zapdos.entities.Brand;
import com.luisguilherme.zapdos.entities.Part;
import com.luisguilherme.zapdos.entities.Subgroup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PartDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	@Size(min = 3, max = 120, message = "O nome deve ter de 3 a 120 caracteres" )
	private String descricao;
	private String code;
	private String originalCode;
	private Long similarity;

	private Brand brand;

	private Subgroup subgroup;

	private List<ApplicationDTO> applications = new ArrayList<>();

	public PartDTO() {

	}

	public PartDTO(Long id, String descricao, String code, String originalCode, Long similarity, Brand brand,
			Subgroup subgroup) {
		this.id = id;
		this.descricao = descricao;
		this.code = code;
		this.originalCode = originalCode;
		this.similarity = similarity;
		this.brand = brand;
		this.subgroup = subgroup;
	}

	public PartDTO(Part entity) {
		id = entity.getId();
		descricao = entity.getDescricao();
		code = entity.getCode();
		originalCode = entity.getOriginalCode();
		similarity = entity.getSimilarity();
		brand = entity.getBrand();
		subgroup = entity.getSubgroup();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOriginalCode() {
		return originalCode;
	}

	public void setOriginalCode(String originalCode) {
		this.originalCode = originalCode;
	}

	public Long getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Long similarity) {
		this.similarity = similarity;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Subgroup getSubgroup() {
		return subgroup;
	}

	public void setSubgroup(Subgroup subgroup) {
		this.subgroup = subgroup;
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
		PartDTO other = (PartDTO) obj;
		return Objects.equals(id, other.id);
	}

}
