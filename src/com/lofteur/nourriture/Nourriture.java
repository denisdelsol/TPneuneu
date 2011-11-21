package com.lofteur.nourriture;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Mangeable;
import com.objet.lofteurs.ObjetDessinable;
import com.objet.lofteurs.Saison1;

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
		this.caseCourrante.addNourriture(this);
	}
	
	/**
	 * Dessine un élément nourriture
	 * 
	 * @param g
	 * @param color
	 */
	public void dessinerObjet(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(this.caseCourrante.getX()*Saison1.tailleCase+10, this.caseCourrante.getY()*Saison1.tailleCase+10, Saison1.tailleNourriture, Saison1.tailleNourriture);
	}
}
