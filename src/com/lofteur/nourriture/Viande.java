package com.lofteur.nourriture;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;

public class Viande extends Nourriture {

	/**
	 * Constructeur de Viande.
	 * @param quantite
	 */
	public Viande(int quantite, Case caseCourrante) {
		super(quantite, caseCourrante);
	}

	@Override
	public int estMange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dessinerObjet(Graphics g) {
		super.dessinerObjet(g, Color.red);
	}
	
}
