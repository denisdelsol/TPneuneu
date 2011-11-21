package com.objet.lofteurs.neuneus;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;

/**
 * Represente un Neuneu de type Erratique (se deplace aleatoirement)
 * 
 * @author bastien
 * 
 */
public class Erratique extends Neuneu {

	/**
	 * Constructeur d'un Erratique
	 * 
	 * @param caseCourrante
	 *            - Case de depart de l'Erratique
	 * @param loft
	 *            - Loft dans lequel evolue l'Erratique
	 */
	public Erratique(Case caseCourrante, Loft loft) {
		super(caseCourrante, loft);
	}

	@Override
	public void seDeplacer() {
		this.caseCourrante.removeNeuneu(this);
		this.caseCourrante = this.mouvementAleatoire();
		this.caseCourrante.addNeuneu(this);
		return;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void seReproduire() {
		if (super.copuler()) {
			Erratique erratique = new Erratique(this.caseCourrante, this.loft);
		}
	}

	@Override
	public void dessinerObjet(Graphics g) {
		super.dessinerObjet(g, Color.blue);
	}

	@Override
	public void enchainerAction() {
		this.seDeplacer();
		this.manger();
		this.seReproduire();
		if (this.estMort()) {
			this.mourir();
		}
	}

}
