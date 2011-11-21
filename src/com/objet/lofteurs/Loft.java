package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import com.lofteur.nourriture.Nourriture;
import com.lofteur.nourriture.Viande;
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
	private ArrayList<Neuneu> listeNeuneu;
//	private final int nombreDeTours = 100;

	/**
	 * Cree un loft avec le nombre de cases necessaires.
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
		this.listeCases = new Case[w][h];
		listeNeuneu = new ArrayList<Neuneu>();

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				this.listeCases[i][j] = new Case(i, j);
			}
		}
	}

	/**
	 * Obtient w.
	 * 
	 * @return
	 */
	public int getW() {
		return w;
	}

	/**
	 * Obtient h.
	 * 
	 * @return
	 */
	public int getH() {
		return h;
	}

	/**
	 * Lance l'emission !
	 */
	public void go() {

		while(this.listeNeuneu.size() > 1) {
				final int indexNeuneu = (int)(Math.random() * (listeNeuneu.size()));
				listeNeuneu.get(indexNeuneu).enchainerAction();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				zone.repaint();
		}
		
		zone.dispose();
	}

	/**
	 * Remplit le loft en nourriture
	 * 
	 * @param nombre
	 */
	public void remplissageAleatoire(float repartition) {
		for (int nombre = 0; nombre < (int) (repartition * h * w); nombre++) {
			zone.ajouterObjet(new Viande(10, this.listeCases[(int) (Math
					.random() * w)][(int) (Math.random() * h)], this));
		}
	}

	/**
	 * Ajoute un neuneu a la liste des neuneus du loft.
	 * 
	 * @param neuneu
	 */
	public void add(Neuneu neuneu) {
		listeNeuneu.add(neuneu);
		zone.ajouterObjet(neuneu);
	}

	/**
	 * Supprime un neuneu de la liste des neuneus du loft
	 * 
	 * @param neuneu
	 */
	public void removeNeuneu(Neuneu neuneu) {
		listeNeuneu.remove(neuneu);
		zone.enleverObjet(neuneu);
	}
	
	/**
	 * Supprime une nourriture de la liste des objets dessinables
	 * 
	 * @param neuneu
	 */
	public void removeNourriture(Nourriture nourriture) {
		zone.enleverObjet(nourriture);
	}

	@Override
	public void dessinerObjet(Graphics g) {
		// Le loft est d�limite par un rectangle
		g.setColor(Color.black);
		g.drawRect(10, 10, w * Saison1.tailleCase, h * Saison1.tailleCase);
	}

	/**
	 * Renvoie la liste des neuneus du loft
	 * 
	 * @return ArrayList<Neuneu>
	 */
	public ArrayList<Neuneu> getListeNeuneus() {
		return listeNeuneu;
	}

	/**
	 * Permet de recuperer une case du loft
	 * 
	 * @param coordX
	 *            - coordonnee selon X de la case
	 * @param coordY
	 *            - coordonnee selon Y de la case
	 * @return La case du loft demandee
	 */
	public Case getCase(int coordX, int coordY) {
		return this.listeCases[coordX][coordY];
	}

	/**
	 * Permet de savoir si une case existe dans le loft
	 * 
	 * @param coordX
	 *            - la coordonnée selon x
	 * @param coordY
	 *            - la coordonnée selon y
	 * @return vrai si la case existe, faux sinon
	 */
	public boolean caseExiste(int coordX, int coordY) {
		if (0 <= coordX && coordX < this.w && 0 <= coordY && coordY < this.h) {
			return true;
		}
		return false;
	}
}
