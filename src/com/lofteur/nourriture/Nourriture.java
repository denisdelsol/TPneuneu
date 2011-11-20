package com.lofteur.nourriture;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Mangeable;
import com.objet.lofteurs.ObjetDessinable;

/**
 * Classe abstraite permettant de gérer la nourriture.
 * @author Denis
 *
 */
public abstract class Nourriture implements ObjetDessinable, Mangeable {

	protected int quantite;
	protected Case caseCourrante;

	/**
	 * Obtient la quantite de nourriture
	 * 
	 * @return
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * Obtient la case courante pour l'element
	 * 
	 * @return
	 */
	public Case getCaseCourrante() {
		return caseCourrante;
	}

	public Nourriture(int quantite, Case caseCourante){
		this.quantite = quantite;
		this.caseCourrante = caseCourante;
	}
}
