package prevoz;

import java.util.ArrayList;
import java.util.Scanner;

import merljivi.Merljivi;

public abstract class Avion implements Merljivi 
{
	protected String oznaka;
	protected double max_tezina;
	private double tezina_prazan;
	Merljivi m_objekti[]; 
	
	public Avion(String oznaka, double tezina_prazan, double ...max_tezina)
	{
		if(oznaka.length() != 10)
		{
			System.out.println("Greska, pogresan broj karaktera za oznaku");
			
			/*if(oznaka.length() > 10)
				oznaka = oznaka.substring(0, 10);
			*/
			
			Scanner in = new Scanner(System.in);
			while(oznaka.length() != 10)
				oznaka = in.next();
			in.close();
		}
		
		this.oznaka = oznaka;
		this.tezina_prazan = tezina_prazan;
		if(max_tezina.length == 0)
			this.max_tezina = 1000;
		else
			this.max_tezina = max_tezina[0];
		
		m_objekti = new Merljivi[10];
	}
	
	public String GetOznaka()
	{
		return this.oznaka;
	}
	
	abstract public void Dodaj(Merljivi m);
	abstract public void Dodaj(Merljivi m, int i);

	public Merljivi Uzmi(int i)
	{
		Merljivi vrati = null;
		if(i < 10 && m_objekti[i] != null)
		{
			vrati = m_objekti[i];
			m_objekti[i] = null;
		}
		else
			System.out.println("Greska: Ili pogresan ideks ili ne postoji objekat sa tim indeksom");			
		
		return vrati;
	}
	
	
	@Override
	public double GetTezina() 
	{
		double s = this.tezina_prazan;
		for(Merljivi m : this.m_objekti)
			if(m != null)
				s += m.GetTezina();
		
		return s;
	}

	@Override
	public String GetOpis() 
	{
		return this.oznaka + "(" + this.GetTezina() + ")";
	}

	@Override
	public String toString()
	{
		return this.GetOpis();
	}
}
