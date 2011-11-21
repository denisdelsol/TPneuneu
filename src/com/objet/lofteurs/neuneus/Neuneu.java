package com.objet.lofteurs.neuneus;

import java.awt.Color;
import java.awt.Graphics;

import com.lofteur.nourriture.Nourriture;
import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Mangeable;
import com.objet.lofteurs.ObjetDessinable;
import com.objet.lofteurs.Saison1;

/**
 * Represente un Neuneu quelconque
 * 
 * @author bastien
 * 
 */
public abstract class Neuneu implements Mangeable, ObjetDessinable {
	/**
	 * Represnete l'energie du Neuneu
	 */
	protected int energie = Saison1.energieDefault;
	/**
	 * Represente le loft dans lequel evolue le neuneu
	 */
	protected final Loft loft;
	/**
	 * Represente la case sur laquelle se trouve le Neuneu a un moment donne
	 */
	protected Case caseCourrante;

	/**
	 * Constructeur d'un Neuneu
	 * 
	 * @param name
	 *            - Le nom du Neuneu
	 * @param caseDepart
	 *            - La case de départ du Neuneu
	 * @param loft
	 *            - Le loft dans lequel se trouve le Neuneu
	 */
	public Neuneu(Case caseDepart, Loft loft) {
		this.caseCourrante = caseDepart;
		this.caseCourrante.addNeuneu(this);
		this.loft = loft;
		this.loft.add(this);
	}

	/**
	 * Permet d'enchainer seDeplacer(), manger() et seReproduire()
	 */
	public abstract void enchainerAction();
	
	/**
	 * Permet au Neuneu de se deplacer dans le loft
	 * 
	 */
	public abstract void seDeplacer();

	/**
	 * Permet au Neuneu de se reproduire
	 * 
	 */
	public abstract void seReproduire();

	/**
	 * Permet de savoir si le Neuneu est mort
	 * 
	 * @return Vrai si le Neuneu est mort, Faux sinon
	 */
	public boolean estMort() {
		if (this.energie == Saison1.energieMort) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Permet au Neuneu de manger, ceci lui fait gagner de l'energie
	 */
	public void manger() {
		final int nbNourriture = caseCourrante.getNourriture().size();

		if (nbNourriture != 0) {
			final int indexNourriture = (int) (Math.random() * (nbNourriture - 1));
			final Nourriture nourriture = caseCourrante.getNourriture().get(
					indexNourriture);
			final int quantiteEnergie = nourriture.estMange();

			if ((this.energie + quantiteEnergie) < Saison1.energieDefault) {
				this.energie = this.energie + quantiteEnergie;
			} else {
				this.energie = Saison1.energieDefault;
			}
		}
	}

	/**
	 * Permet au Neuneu de copuler, ceci lui fait perdre de l'energie
	 */
	public boolean copuler() {
		final int nbNeuneu = caseCourrante.getNeuneu().size();

		if (nbNeuneu > 1) {
			if ((this.energie - Saison1.energieReproduction) <= Saison1.energieMort) {
				this.energie = Saison1.energieMort;
				return false;
			}

			else {
				this.energie = this.energie - Saison1.energieReproduction;
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Permet au Neuneu d'être mange
	 * 
	 * @return La quantite d'energie cede par le Neuneu
	 */
	public int estMange() {
		final int quantiteNourriture = (int) (Math.random() * this.energie);
		this.energie = Saison1.energieMort;
		this.mourir();
		return quantiteNourriture;
	}

	/**
	 * Permet de trouver la case la plus proche avec un Neuneu dessus
	 * 
	 * @return La case trouver ou null si aucune case trouvée
	 */
	protected Case trouverPlusProcheNeuneu() {
		final int coordX = this.caseCourrante.getX();
		final int coordY = this.caseCourrante.getY();
		final int i = 1;

		for (int x = -i; x <= i; x++) {
			for (int y = -i; y <= i; y++) {
				if (Math.abs(x) + Math.abs(y) != 0) {
					if (this.loft.caseExiste(coordX + x, coordY + y)) {
						if ((!this.loft.getCase(coordX + x, coordY + y)
								.getNeuneu().isEmpty())) {
							return this.loft.getCase(coordX + x, coordY + y);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Permet de trouver la case la plus proche avec de la nourriture dessus
	 * 
	 * @return La case trouver ou null si aucune case trouvée
	 */
	protected Case trouverPlusProcheNourriture() {
		final int coordX = this.caseCourrante.getX();
		final int coordY = this.caseCourrante.getY();
		final int i = 1;

		for (int x = -i; x <= i; x++) {
			for (int y = -i; y <= i; y++) {
				if (Math.abs(x) + Math.abs(y) != 0) {
					if (this.loft.caseExiste(coordX + x, coordY + y)) {
						if ((!this.loft.getCase(coordX + x, coordY + y)
								.getNourriture().isEmpty())) {
							return this.loft.getCase(coordX + x, coordY + y);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Permet de trouver la case la plus proche avec de la nourriture ou un
	 * neuneu dessus
	 * 
	 * @return La case trouver ou null si aucune case trouvée
	 */
	protected Case trouverPlusProcheNourritureNeuneu() {
		final int coordX = this.caseCourrante.getX();
		final int coordY = this.caseCourrante.getY();
		final int i = 1;

		for (int x = -i; x <= i; x++) {
			for (int y = -i; y <= i; y++) {
				if (Math.abs(x) + Math.abs(y) != 0) {
					if (this.loft.caseExiste(coordX + x, coordY + y)) {
						if ((!this.loft.getCase(coordX + x, coordY + y)
								.getNourriture().isEmpty())
								|| (!this.loft.getCase(coordX + x, coordY + y)
										.getNeuneu().isEmpty())) {
							return this.loft.getCase(coordX + x, coordY + y);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Permet de se deplacer aléatoirement
	 * 
	 * @return la Case d'arrivée
	 */
	protected Case mouvementAleatoire() {
		final int coordX = this.caseCourrante.getX();
		final int coordY = this.caseCourrante.getY();

		int newCoordX = coordX - 1 + (int) (Math.random() * 3);
		int newCoordY = coordY - 1 + (int) (Math.random() * 3);

		while ((!this.loft.caseExiste(newCoordX, newCoordY))
				|| (Math.abs(coordX - newCoordX) + Math.abs(coordY - newCoordY) == 0)) {
			newCoordX = coordX - 1 + (int) (Math.random() * 3);
			newCoordY = coordY - 1 + (int) (Math.random() * 3);
		}

		return this.loft.getCase(newCoordX, newCoordY);

	}

	/**
	 * Dessine un Neuneu
	 */
	public void dessinerObjet(Graphics g, Color color) {
		g.setColor(color);
		g.fillOval(this.caseCourrante.getX() * Saison1.tailleCase + 10,
				this.caseCourrante.getY() * Saison1.tailleCase + 10,
				Saison1.tailleNeuneu, Saison1.tailleNeuneu);
	}
	
	/**
	 * Permet au neuneu de mourir
	 */
	public void mourir(){
		this.loft.removeNeuneu(this);
		this.caseCourrante.removeNeuneu(this);
	}
}
