package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import it.polito.tdp.borders.db.BordersDAO;


public class Model {
	private Map<Integer, Country> mappaC;
	private BordersDAO dao;
	private Graph<Country, DefaultEdge> graph;

	public Model() {
		dao=new BordersDAO();
		mappaC=dao.loadAllCountries();
	}
	
	public String creaGrafo(int year) {
		graph=new SimpleGraph<> (DefaultEdge.class);
		Graphs.addAllVertices(graph, mappaC.values());
		addEdges(year);
		
		return stampa();
		
	}

	private String stampa() {
		StringBuilder sb=new StringBuilder();
		sb.append("Elenco degli stati: \n");
		for(Country c:mappaC.values())
		sb.append(c.getName()+" num stati confinanti: "+Graphs.neighborListOf(graph, c).size()+"\n");	
		
		sb.append(" \n Numero componenti connesse: ");
		
		ConnectivityInspector<Country, DefaultEdge> ci = new ConnectivityInspector<>(graph);
		sb.append(ci.connectedSets().size());
		
		return sb.toString();
		
	}

	private void addEdges(int year) {
		List<Border> borders=dao.getCountryPairs(year);
		for(Border b:borders) 
			graph.addEdge(mappaC.get(b.getState1cod()), mappaC.get(b.getState2cod()));	
		
	}
	
	public List<Country> getCountries()
	{
		List<Country> countries=new ArrayList<Country>(mappaC.values());
		return countries;
	}
	
	public List<Country> trovaViciniIterativo(Country c)
	{
		
		ConnectivityInspector<Country, DefaultEdge> ci = new ConnectivityInspector<>(graph);
		List<Set<Country>> listSets=ci.connectedSets();
		for(Set<Country> s:listSets) {
			if(s.contains(c)) {
				List<Country> result=new ArrayList<>();
				for(Country cy:s) {
					result.add(cy);
				}
				return result;
			}
			
		}
		return null;
	}
	
	public List<Country> trovaViciniConMetodiDiVisita(Country c){
		GraphIterator<Country,DefaultEdge> graphI=new BreadthFirstIterator<>(graph, c);
		List<Country> result=new ArrayList<>();
		
		while(graphI.hasNext()) {
			result.add(graphI.next());
		}
		
		
		return result;
	}
	
	private List<Country> soluzione;
	public List<Country> trovaViciniRicorsivo(Country c){
		soluzione=new ArrayList<>();
		List<Country> countries=new ArrayList<Country>(mappaC.values());
		recursive(c);
		
		return soluzione;
	}

	private void recursive(Country c) {
		List<Country> vicini=new ArrayList<>(Graphs.neighborListOf(graph, c));
		for(Country country:vicini) {
			if(!soluzione.contains(country)) {
			soluzione.add(country);
			recursive(country);
			}
		}
	}
	 

}
