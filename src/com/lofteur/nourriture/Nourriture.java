package com.lofteur.nourriture;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Mangeable;
import com.objet.lofteurs.ObjetDessinable;
import com.objet.lofteurs.Saison1;

/**
 * Classe abstraite permettant de g�rer la nourriture.
 * @author Denis
 *
 */
public abstract class Nourriture implements ObjetDessinable, Mangeable {

	protected int quantite;
	protected Case caseCourrante;
	protected Loft loft;

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

	public Nourriture(int quantite, Case caseCourante, Loft loft){
		this.quantite = quantite;
		this.caseCourrante = caseCourante;
		this.caseCourrante.addNourriture(this);
		this.loft=loft;
	}
	
	public int estMange() {
		final int quantiteMange = (int) (Math.random() * this.quantite);
		this.quantite = this.quantite - quantiteMange;
		if(this.quantite == 1){
			this.suppression();
		}
		return quantiteMange;
	}
	
	/**
	 * Permet de supprimer la nourriture
	 */
	protected void suppression(){
		this.caseCourrante.removeNourriture(this);
		this.loft.removeNourriture(this);
	}
	
	/**
	 * Dessine un �l�ment nourriture
	 * 
	 * @param g
	 * @param color
	 */
	public void dessinerObjet(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(this.caseCourrante.getX()*Saison1.tailleCase+10, this.caseCourrante.getY()*Saison1.tailleCase+10, Saison1.tailleNourriture, Saison1.tailleNourriture);
	}
}
