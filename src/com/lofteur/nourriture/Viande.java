package com.lofteur.nourriture;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;

public class Viande extends Nourriture {

	/**
	 * Constructeur de Viande.
	 * @param quantite
	 */
	public Viande(int quantite, Case caseCourrante, Loft loft) {
		super(quantite, caseCourrante, loft);
	}

	@Override
	public void dessinerObjet(Graphics g) {
		super.dessinerObjet(g, Color.red);
	}
	
}
