package com.lofteur.nourriture;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;

public class Alcool extends Nourriture {

	public Alcool(int quantite, Case caseCourante, Loft loft) {
		super(quantite, caseCourante, loft);
	}

	@Override
	public void dessinerObjet(Graphics g) {
		super.dessinerObjet(g, Color.blue);
	}

}
