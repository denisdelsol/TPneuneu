package com.objet.lofteurs.neuneus;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Mangeable;
import com.objet.lofteurs.Saison1;

public abstract class Neuneu implements Mangeable {
	protected final String name;
	protected int energie = Saison1.energieDefault;
	protected final Loft loft;
	protected Case caseCourrante;

	public Neuneu(String name, Case caseDepart, Loft loft) {
		this.name = name;
		this.caseCourrante = caseDepart;
		this.loft = loft;
	}

	public abstract Case seDeplacer();

	public void manger() {
		// TODO
	}

	public void sereproduire() {
		// TODO
	}

}
