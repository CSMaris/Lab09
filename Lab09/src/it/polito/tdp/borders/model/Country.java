package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;

public class Country {
	private String name;
	private String abb;
	private int code;
	
	
	
	public Country(String name, String abb, int code) {
		this.name = name;
		this.abb = abb;
		this.code = code;
		
	}

	@Override
	public String toString() {
		return name;
	}

	
	public String getName() {
		return name;
	}

	public String getAbb() {
		return abb;
	}

	public int getCode() {
		return code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (code != other.code)
			return false;
		return true;
	}
	
	
	
	
	

}
