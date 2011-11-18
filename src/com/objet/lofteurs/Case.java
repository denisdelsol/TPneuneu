package com.objet.lofteurs;

import java.util.HashMap;
import java.util.Map;

import com.lofteur.nourriture.Nourriture;
import com.objet.lofteurs.neuneus.Neuneu;

/**
 * Classe représentant une case du loft.
 * 
 * @author Denis
 */
public class Case {

	private final int x;
	private final int y;
	private Map<Integer, Nourriture> listeNourriture; 
	private Map<Integer, Neuneu> listeNeuneus;
	
	/**
	 * Instancie une nouvelle instance de la classe Case.
	 * 
	 * @param x
	 * @param y
	 */
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Obtient une liste de nourriture présents sur la case.
	 * @return Map<Integer, Nourriture>
	 */
	public Map<Integer, Nourriture> getNourriture(){
		return this.listeNourriture;
	}
	
	/**
	 * Obtient une liste de neuneus présents sur la case.
	 * @return
	 */
	public Map<Integer, Neuneu> getNeuneu(){
		return this.listeNeuneus;
	}
	
	/**
	 * 
	 * @param neuneu
	 */
	public void addNeuneu(Neuneu neuneu){
		
	}
	
}
