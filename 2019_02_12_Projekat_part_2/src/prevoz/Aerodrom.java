package prevoz;

import java.util.ArrayList;

import merljivi.Merljivi;
import merljivi.Osoba;

public class Aerodrom 
{
	String naziv;
	private Avion avioni[];
	
	public Aerodrom(String naziv, int kapacitet)
	{
		this.naziv = naziv;
		this.avioni = new Avion[kapacitet];
	}

	private int FindAvion(String oznaka)
	{
		int i = 0;
		while(i < this.avioni.length && !this.avioni[i].oznaka.equals(oznaka))
			i++;
		
		if(i < this.avioni.length)
			return i;
		else 
			return -1; // nema aviona za datu oznaku 
	}
	
	public void Polece(String oznaka)
	{		
		int ind = this.FindAvion(oznaka);
		
		if(ind != -1)
		{
			// nasli...polece
			System.out.println(this.avioni[ind]);
			this.avioni[ind] = null;
		}
		else
			System.out.println("Greska: ne postoji avion sa datom oznakom");
	}
	
	public void Slece(Avion avion)
	{
		int i = 0;
		while(i < this.avioni.length && this.avioni[i] != null)
			i++;
		
		if(i < this.avioni.length)
			this.avioni[i] = avion;
		else
			System.out.println("Greska: Aerodrom je pun!");
	}
	
	public void DodajObjekat(Merljivi m, String oznaka_aviona)
	{
		int ind = this.FindAvion(oznaka_aviona);
		
		if(ind != -1)
			this.avioni[ind].Dodaj(m);
		else
			System.out.println("Greska: Avion sa zadatom oznakom ne postoji!");
	}

	public ArrayList<Osoba> SpisakOsoba()
	{
		ArrayList<Osoba> spisak = new ArrayList<>();
		
		for(Avion avion : this.avioni)
			if(avion instanceof PutnickiAvion)
			{
				for(Merljivi m : avion.m_objekti)
					if(m instanceof Osoba)
						spisak.add((Osoba)m);
			}
		
		return spisak;
	}
	
	public double UkupnaTezina()
	{
		double s = 0;
		
		for(Avion avion : this.avioni)
			if(avion != null)
				s += avion.GetTezina();
		
		return s;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		
		for(Avion avion : this.avioni)
		{
			if(avion != null)
			{
				if(avion instanceof PutnickiAvion)
					s += "P ";
				else if(avion instanceof TeretniAvion)
					s += "T ";
				
				s += avion.GetOpis() + System.lineSeparator();
			}
		}
		
		return s;
	}
}

