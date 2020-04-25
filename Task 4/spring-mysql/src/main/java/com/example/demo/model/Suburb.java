package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Suburbs")
@NoArgsConstructor
@AllArgsConstructor
public class Suburb {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int postcode;
	private String locality;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPostcode() {
		return postcode;
	}

	public String getLocality() {
		return locality;
	}
	
	@Override
	  public String toString() {
	    return "Id: "+ getId() + "Name: "+ getName() + "Postcode: "+ getPostcode() + "Locality: "+ getLocality();
	  }

}
