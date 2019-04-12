package tovar;

import merljivi.Merljivi;
import merljivi.Osoba;

public class Kontejner implements Merljivi 
{
	private static int id_generator = 1;
	
	private int id;
	protected double tezina; // tezina kada je prazan
	Merljivi m_objekti[];
	
	public Kontejner(double tezina, int kapacitet)
	{
		this.id = id_generator++;
		m_objekti = new Merljivi[kapacitet];
		this.tezina = tezina;
	}
	
	public void Dodati(Merljivi m)
	{
		if(!(m instanceof Paket))
		{
			System.out.println("Greska: Pogresan tip u kontejner");
			return;
		}
		
		// Varijanta 1 - mogu postojati rupe u nizu (null pa posle neki objekat)
		int i = 0;
		while(i < this.m_objekti.length && this.m_objekti[i] != null)
			i++;
		
		if(i < this.m_objekti.length)
			this.m_objekti[i] = m;
		else
			System.out.println("Greska: Kapacitet pun");
		
		/*// Varijanta 2 - da postoji promenljiva kojaodredjuje
		// koliko postoji objekata u nizu - popunjenost
		if(popunjenost < this.m_objekti.length)
			this.m_objekti[popunjenost++] = m;
		else
			System.out.println("Greska: Kapacitet pun");
		*/
		
		/*// Varijanta NIKOLA
		boolean ubacio = false;
		for(int i = 0; i < this.m_objekti.length && !ubacio; i++)
			if(this.m_objekti[i] == null)
			{
				this.m_objekti[i] = m;
				ubacio = true;
			}
		
		if(!ubacio)
			System.out.println("Greska: Kapacitet pun");
		*/
		
	}
	
	public Merljivi Izvaditi(String opis)
	{
		Merljivi vrati = null;
		
		int i = 0;
/*		while(i < this.m_objekti.length &&  
				  (this.m_objekti[i] == null || 
				  !this.m_objekti[i].GetOpis().equals(opis)))
			i++;
*/
		int br = 0;
		while(i < this.m_objekti.length && br == 0)
		{	
			if(this.m_objekti[i] != null &&
			   this.m_objekti[i].GetOpis().equals(opis))
				br = 1;
			else
				i++;
		}

		// Varijanta 1 - da ostavlja rupu u nizu...tj samo izvadi objekat
		if(i < this.m_objekti.length)
		{
			vrati = this.m_objekti[i];
			this.m_objekti[i] = null;
		}
		
		return vrati; // vraca null ako nije pronasao odgovarajuci objekat
		
		/*// Varijanta 2 - da se zna popunjenost! Samo se poslednji objekat iz niza kopira na
		// mesto onoga koji se vadi
		if(i < this.m_objekti.length)
		{
			vrati = this.m_objekti[i];
			this.m_objekti[i] = this.m_objekti[popunjenost - 1];
			this.m_objekti[popunjenost - 1] = null;
			popunjenost--;
		}
		
		return vrati;*/
	}
	
	@Override
	public double GetTezina() 
	{
		double s = this.tezina; // tezina praznog kontejnera
		
		for (Merljivi m : this.m_objekti)
			if(m != null)
				s += m.GetTezina(); // plus tezina svakog objekta
		
		return s;
	}

	@Override
	public String GetOpis() 
	{
		String s = "Kontejner " + this.id + "(" + this.GetTezina() + "):" + System.lineSeparator();
		
		for (Merljivi m : this.m_objekti)
			if(m != null)
				s += ("\t" + m.GetOpis() + System.lineSeparator());
/*			else
				s += System.lineSeparator();
	*/	
		return s;
	}
}
