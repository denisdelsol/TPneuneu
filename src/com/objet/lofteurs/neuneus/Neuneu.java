package com.objet.lofteurs.neuneus;

import com.lofteur.nourriture.Nourriture;
import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Mangeable;
import com.objet.lofteurs.Saison1;

/**
 * Represente un Neuneu quelconque
 * 
 * @author bastien
 *
 */
public abstract class Neuneu implements Mangeable {
	/**
	 * Represente le nom du Neuneu
	 */
	protected final String name;
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
	 * @param name - Le nom du Neuneu
	 * @param caseDepart - La case de départ du Neuneu
	 * @param loft - Le loft dans lequel se trouve le Neuneu
	 */
	public Neuneu(String name, Case caseDepart, Loft loft) {
		this.name = name;
		this.caseCourrante = caseDepart;
		this.caseCourrante.addNeuneu(this);
		this.loft = loft;
		this.loft.add(this);

	}

	/**
	 * Permet au Neuneu de se deplacer dans le loft
	 * 
	 * @return La case d'arrivee du Neuneu
	 */
	public abstract Case seDeplacer();

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
			final int indexNourriture = (int) (Math.random() * nbNourriture);
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
	 * Permet au Neuneu de se reproduire, ceci lui fait perdre de l'energie
	 */
	public void seReproduire() {
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
	
	

}
