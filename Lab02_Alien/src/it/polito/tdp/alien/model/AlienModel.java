package it.polito.tdp.alien.model;

import java.util.TreeMap;

public class AlienModel {
	
	private TreeMap<String, String> dizionario;

	public AlienModel () {
		dizionario = new TreeMap<>();
		
	}

	public void addToMap(String[] words) {
		dizionario.put(words[0], words[1]);
	}

	public TreeMap<String, String> getDizionario() {
		return dizionario;
	}

	public void setDizionario(TreeMap<String, String> dizionario) {
		this.dizionario = dizionario;
	}

	public String searchWord(String[] words) {
		
		return dizionario.get(words[0]);
	}

	public void reset() {
		dizionario.clear();		
	}
	
	
}
