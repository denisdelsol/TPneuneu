package com.lofteur.nourriture;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;

public class Alcool extends Nourriture {

	public Alcool(int quantite, Case caseCourante) {
		super(quantite, caseCourante);
	}

	@Override
	public void dessinerObjet(Graphics g) {
		super.dessinerObjet(g, Color.blue);
	}

	@Override
	public int estMange() {
		// TODO Auto-generated method stub
		return 0;
	}

}
