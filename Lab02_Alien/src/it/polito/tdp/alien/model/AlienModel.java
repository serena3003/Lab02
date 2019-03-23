package it.polito.tdp.alien.model;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
	
	public boolean testoValido(String s) {
		
		//String[] words = s.split(" ");

		//testo la lunghezza dell'array
    	//if(words.length>2) {
    	//	return -1;
    	//}
    	//else {
    		Pattern p=Pattern.compile("[a-zA-Z]*|[a-zA-Z]* [a-zA-Z]*");
        	Matcher m = p.matcher(s);
        	if(!m.matches()) {
        		return false;
        	}
        	else return true;//words.length;
    	//}
	}
	
	public String AnalisiTesto(String[] words) {
		if(words.length == 1) {
	    	return this.searchWord(words);
		} else {
			this.addToMap(words);
			return words[0];
		}
	}
}
