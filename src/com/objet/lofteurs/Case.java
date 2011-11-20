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
	 * Obtient la valeur de x.
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Obtient la valeur de y.
	 * @return
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Obtient une liste de nourriture présents sur la case.
	 * 
	 * @return Map<Integer, Nourriture>
	 */
	public Map<Integer, Nourriture> getNourriture() {
		return this.listeNourriture;
	}

	/**
	 * Obtient une liste de neuneus présents sur la case.
	 * 
	 * @return Map<Integer, Neuneu>
	 */
	public Map<Integer, Neuneu> getNeuneu() {
		return this.listeNeuneus;
	}

	/**
	 * Ajoute un neuneu à la case
	 * 
	 * @param neuneu
	 */
	public void addNeuneu(Neuneu neuneu) {
		listeNeuneus.put(listeNeuneus.size(), neuneu);
	}

	/**
	 * Ajoute un élément de nourriture à la case.
	 * 
	 * @param nourriture
	 */
	public void addNourriture(Nourriture nourriture) {
		listeNourriture.put(listeNourriture.size(), nourriture);
	}

	/**
	 * Enlève un neuneu d'une case.
	 * 
	 * @param neuneu
	 */
	public void removeNeuneu(Neuneu neuneu) {
		int key = -1, i = 0;
		while (key < 0 && i < listeNeuneus.size()) {
			if (listeNeuneus.get(i) == neuneu) {
				key = i;
			}
			i++;
		}
		if (key >= 0) {
			listeNeuneus.remove(key);
		}
	}
}
