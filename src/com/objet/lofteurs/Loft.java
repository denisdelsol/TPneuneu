package com.objet.lofteurs;

import java.awt.Graphics;

import com.objet.lofteurs.neuneus.Neuneu;

/**
 * Classe correspondant au Loft
 * @author Denis
 *
 */
public class Loft implements ObjetDessinable {

	private final int w;
	private final int h;
	private final ZoneGraphique zone;

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

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				// TODO Créer une case
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

	public void add(Neuneu neuneu) {

	}

	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
