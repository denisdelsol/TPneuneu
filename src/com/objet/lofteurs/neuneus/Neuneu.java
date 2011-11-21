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
	public void copuler() {
		final int nbNeuneu = caseCourrante.getNeuneu().size();

		if (nbNeuneu != 0) {
			if ((this.energie - Saison1.energieReproduction) <= Saison1.energieMort) {
				this.energie = Saison1.energieMort;
			}

			else {
				this.energie = this.energie - Saison1.energieReproduction;
			}
		}
	}

	/**
	 * Permet au Neuneu d'être mange
	 * 
	 * @return La quantite d'energie cede par le Neuneu
	 */
	public int estMange() {
		final int quantiteNourriture = (int) (Math.random() * this.energie);
		this.energie = Saison1.energieMort;
		return quantiteNourriture;
	}

	/**
	 * Permet de trouver la case la plus proche avec un Neuneu dessus
	 * 
	 * @return La case trouver ou null si aucune case trouvée
	 */
	protected Case trouverPlusProcheNeuneu() {
		boolean neuneuTrouve = false;
		final int coordX = this.caseCourrante.getX();
		final int coordY = this.caseCourrante.getY();
		int i = 0;

		while (!neuneuTrouve) {
			for (int x = -i; x <= i; x++) {
				for (int y = -i; y <= i; y++) {
					if (this.loft.caseExiste(x, y)) {
						if (!this.loft.getCase(x, y).getNeuneu().isEmpty()) {
							return this.loft.getCase(x, y);
						}
					}
				}
			}
			i++;
			if (i > Math.max(Math.max((Saison1.largeurLoft - coordX), coordX),
					Math.max((Saison1.longueurLoft - coordY), coordY))) {
				return null;
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
		boolean nourritureTrouve = false;
		final int coordX = this.caseCourrante.getX();
		final int coordY = this.caseCourrante.getY();
		int i = 0;

		while (!nourritureTrouve) {
			for (int x = -i; x <= i; x++) {
				for (int y = -i; y <= i; y++) {
					if (this.loft.caseExiste(x, y)) {
						if (!this.loft.getCase(x, y).getNourriture().isEmpty()) {
							return this.loft.getCase(x, y);
						}
					}
				}
			}
			i++;
			if (i > Math.max(Math.max((Saison1.largeurLoft - coordX), coordX),
					Math.max((Saison1.longueurLoft - coordY), coordY))) {
				return null;
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
		boolean nourritureTrouve = false;
		final int coordX = this.caseCourrante.getX();
		final int coordY = this.caseCourrante.getY();
		int i = 0;

		while (!nourritureTrouve) {
			for (int x = -i; x <= i; x++) {
				for (int y = -i; y <= i; y++) {
					if (this.loft.caseExiste(x, y)) {
						if ((!this.loft.getCase(x, y).getNourriture().isEmpty())
								|| (!this.loft.getCase(x, y).getNeuneu()
										.isEmpty())) {
							return this.loft.getCase(x, y);
						}
					}
				}
			}
			i++;
			if (i > Math.max(Math.max((Saison1.largeurLoft - coordX), coordX),
					Math.max((Saison1.longueurLoft - coordY), coordY))) {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * Dessine un Neuneu
	 */
	public void dessinerObjet(Graphics g, Color color) {
		g.setColor(color);
		g.fillOval(this.caseCourrante.getX()*Saison1.tailleCase+10, this.caseCourrante.getY()*Saison1.tailleCase+10, Saison1.tailleNeuneu, Saison1.tailleNeuneu);
	}
}
