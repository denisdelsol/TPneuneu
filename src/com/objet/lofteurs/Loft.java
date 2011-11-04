package com.objet.lofteurs;

import com.objet.lofteurs.neuneus.Neuneu;

public class Loft {

	private final int w;
	private final int h;
	private final ZoneGraphique zone;
	
	/**
	 * 
	 * @param w largeur du loft
	 * @param h longueur du loft
	 * @param zone
	 */
	public Loft(int w, int h, ZoneGraphique zone)
	{
		this.w = w;
		this.h = h;
		this.zone = zone;
		
		for (int i=0; i<w;i++)
		{
			for (int j=0; j<h;j++)
			{
				//TODO Créer une case
			}
		}
	}
	
	/**
	 * Lance l'émission !
	 */
	public void go()
	{
		//TODO
	}
	
	/**
	 * Remplit le loft en nourriture
	 * @param nombre
	 */
	public void remplissageAleatoire(float nombre)
	{
		//TODO
	}
	
	public void add(Neuneu neuneu)
	{
		
	}
}
