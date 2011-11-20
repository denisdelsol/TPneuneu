package com.lofteur.nourriture;

import com.objet.lofteurs.Mangeable;
import com.objet.lofteurs.ObjetDessinable;

/**
 * Classe abstraite permettant de gérer la nourriture.
 * @author Denis
 *
 */
public abstract class Nourriture implements ObjetDessinable, Mangeable {

	int quantite;

	public Nourriture(int quantite){
		this.quantite = quantite;
	}
}
