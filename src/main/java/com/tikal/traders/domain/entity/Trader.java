package com.tikal.traders.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "traders")
public class Trader {

	@Id
	@GeneratedValue
	private Integer id;

	@NaturalId
	private String name;

	@NotNull
	private String city;

	public Trader() {
	}

	public Trader(final String name, final String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}
	
	

	public Integer getId() {
		return id;
	}

	

	public void setName(final String name) {
		this.name = name;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Trader [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	

}
