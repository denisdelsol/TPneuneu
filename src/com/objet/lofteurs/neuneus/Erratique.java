package com.objet.lofteurs.neuneus;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Saison1;

/**
 * Represente un Neuneu de type Erratique (se deplace aleatoirement)
 * 
 * @author bastien
 * 
 */
public class Erratique extends Neuneu {

	/**
	 * Constructeur d'un Erratique
	 * 
	 * @param caseCourrante
	 *            - Case de depart de l'Erratique
	 * @param loft
	 *            - Loft dans lequel evolue l'Erratique
	 */
	public Erratique(Case caseCourrante, Loft loft) {
		super(caseCourrante, loft);
	}

	@Override
	public void seDeplacer() {
		final int coordX = (int)(Math.random()*(Saison1.largeurLoft-1));
		final int coordY = (int)(Math.random()*(Saison1.longueurLoft-1));
		
		this.caseCourrante.removeNeuneu(this);
		this.caseCourrante = this.loft.getCase(coordX, coordY);
		this.caseCourrante.addNeuneu(this);
		return ;
	}

	@Override
	public void seReproduire() {
		super.copuler();
		if (this.energie != Saison1.energieMort) {
			this.loft.add(new Erratique(this.caseCourrante, this.loft));
		}
	}

}
