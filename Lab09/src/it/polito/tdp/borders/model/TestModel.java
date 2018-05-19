package it.polito.tdp.borders.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		System.out.println("TestModel -- TODO");
		
		System.out.println("Creo il grafo relativo al 2000");
		System.out.println(model.creaGrafo(2000)+"\n");
		List<Country> allCountries=model.getCountries();
		//System.out.println(allCountries.get(5));
	    List<Country> result1=model.trovaViciniIterativo(allCountries.get(5));
	    List<Country> result2=model.trovaViciniRicorsivo(allCountries.get(5));
	    List<Country> result3=model.trovaViciniConMetodiDiVisita(allCountries.get(5));
	    
	   
	    
	
		
	}

}
