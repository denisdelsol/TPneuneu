package com.lofteur.nourriture;

import com.objet.lofteurs.Mangeable;

/**
 * Classe abstraite permettant de g�rer la nourriture.
 * @author Denis
 *
 */
public abstract class Nourriture implements Mangeable {

	int quantite;

	public Nourriture(int quantite){
		this.quantite = quantite;
	}
}
