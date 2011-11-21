package com.objet.lofteurs;

import com.objet.lofteurs.neuneus.Cannibale;
import com.objet.lofteurs.neuneus.Erratique;
import com.objet.lofteurs.neuneus.Lapin;
import com.objet.lofteurs.neuneus.Neuneu;
import com.objet.lofteurs.neuneus.Vorace;

/**
 * 
 * @author Denis Bastien
 * 
 */
public class Saison1 {

	public static final int nombreLofteurs = 10;
	public static final float proportionErratique = 0.3f;
	public static final float proportionVorace = .5f;
	public static final float proportionCannibale = 0.2f;
	public static final int energieDefault = 100;
	public static final int energieReproduction = 25;
	public static final int energieMort = 0;
	public static final int longueurLoft = 30;
	public static final int largeurLoft = 25;
	public static final int tailleCase = 10;
	public static final int tailleNeuneu = 10;
	public static final int tailleNourriture = 5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}

	public void primeTime() {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		Loft loft = new Loft(largeurLoft, longueurLoft, zone);
		loft.remplissageAleatoire(0.1f);
		zone.ajouterObjet(loft);
		
		for (int i = 0; i < nombreLofteurs; i++) {
			double x = Math.random();
			if (x < proportionVorace) {
				Neuneu vorace = new Vorace(loft.getCase(
						(int) (Math.random() * (loft.getW() - 1)),
						(int) (Math.random() * (loft.getH() - 1))), loft);

			} else {
				x -= proportionVorace;
				if (x < proportionErratique) {
					Neuneu erratique = new Erratique(loft.getCase(
							(int) (Math.random() * (loft.getW() - 1)),
							(int) (Math.random() * (loft.getH() - 1))), loft);
				} else {
					x -= proportionErratique;
					if (x < proportionCannibale) {
						Neuneu cannibale = new Cannibale(loft.getCase(
								(int) (Math.random() * (loft.getW() - 1)),
								(int) (Math.random() * (loft.getH() - 1))),
								loft);
					}
				}
			}
		}

		loft.go();
	}

}
