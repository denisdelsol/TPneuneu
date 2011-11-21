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
		// TODO Auto-generated constructor stub
	}

	@Override
	public int estMange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dessinerObjet(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.caseCourrante.getX()*10+10, this.caseCourrante.getY()*10+10, 5, 5);
	}
	
}
