package com.objet.lofteurs;

import java.awt.Graphics;

import com.objet.lofteurs.neuneus.Neuneu;

/**
 * Classe correspondant au Loft
 * 
 * @author Denis
 * 
 */
public class Loft implements ObjetDessinable {

	private final int w;
	private final int h;
	private final ZoneGraphique zone;
	private Case[][] listeCases;

	/**
	 * 
	 * @param w
	 *            largeur du loft
	 * @param h
	 *            longueur du loft
	 * @param zone
	 */
	public Loft(final int w, final int h, ZoneGraphique zone) {
		this.w = w;
		this.h = h;
		this.zone = zone;
		this.listeCases = new Case[h][w];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				this.listeCases[i][j] = new Case(i, j);
			}
		}
	}

	/**
	 * Lance l'émission !
	 */
	public void go() {
		// TODO
	}

	/**
	 * Remplit le loft en nourriture
	 * 
	 * @param nombre
	 */
	public void remplissageAleatoire(float nombre) {
		// TODO
	}

	/**
	 * Ajoute un neuneu au loft aléatoirement.
	 * 
	 * @param neuneu
	 */
	public void add(Neuneu neuneu) {
		int positionX = (int) (Math.random() * w);
		int positionY = (int) (Math.random() * h);

		add(neuneu, positionX, positionY);
	}

	/**
	 * Ajoute un neuneu au loft dans une case particulière.
	 * 
	 * @param neuneu
	 * @param positionX
	 * @param positionY
	 */
	public void add(Neuneu neuneu, int positionX, int positionY) {
		listeCases[positionX][positionY].addNeuneu(neuneu);
	}

	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub

	}
}
