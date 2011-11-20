package com.objet.lofteurs.neuneus;

import com.lofteur.nourriture.Nourriture;
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
		this.caseCourrante.addNeuneu(this);
		this.loft = loft;
		this.loft.add(this);
		
	}

	public abstract Case seDeplacer();

	public void manger() {
		final int nbNourriture = caseCourrante.getNourriture().size();
		final int indexNourriture = (int)(Math.random()*nbNourriture);
		
		final Nourriture nourriture = caseCourrante.getNourriture().get(indexNourriture);
		final int quantiteEnergie = nourriture.estMange();
		
		if ((energie + quantiteEnergie) < Saison1.energieDefault){
			energie = energie + quantiteEnergie;
		}
		else{
			energie = Saison1.energieDefault;
		}
	}

	public void sereproduire() {
		// TODO
	}
	
	public int estMange(){
		//TODO
		return (Integer) null;
	}

}
