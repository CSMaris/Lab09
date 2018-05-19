package it.polito.tdp.borders.model;

public class Border {
	private int State1cod;
	private int State2cod;
	private int year;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + State1cod;
		result = prime * result + State2cod;
		return result;
	}

	public Border(int state1cod, int state2cod, int year) {
		super();
		State1cod = state1cod;
		State2cod = state2cod;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Border other = (Border) obj;
		if (State1cod != other.State1cod)
			return false;
		if (State2cod != other.State2cod)
			return false;
		return true;
	}

	public int getState1cod() {
		return State1cod;
	}

	public int getState2cod() {
		return State2cod;
	}

	public int getYear() {
		return year;
	}

	

}
