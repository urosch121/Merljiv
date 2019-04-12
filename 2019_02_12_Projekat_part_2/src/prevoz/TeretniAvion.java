package prevoz;

import merljivi.Merljivi;
import merljivi.Osoba;
import tovar.Kontejner;

public class TeretniAvion extends Avion 
{
	public TeretniAvion(String oznaka, double tezina_prazan, double ... max_tezina) 
	{
		super(oznaka,tezina_prazan,max_tezina);
	}
	
	@Override
	public void Dodaj(Merljivi m) 
	{
		if(!(m instanceof Kontejner))
		{
			System.out.println("Greska: Mozete dodati samo kontejner");
			return;
		}
		
		// pronadji prvo slobodno mesto;
		int ind = 0;
		
		while(ind < 10 && this.m_objekti[ind] != null)
			ind++;
		
		if(ind < 10)
			this.Dodaj(m, ind);
		else
			System.out.println("Greska: Pun avion");
	}

	@Override
	public void Dodaj(Merljivi m, int i) 
	{
		if(!(m instanceof Kontejner))
		{
			System.out.println("Greska: Mozete dodati samo kontejner");
			return;
		}

		if(i > 10 || m_objekti[i] != null)
			System.out.println("Greska: Ne moze se dodati objekat na tu poziciju");
		if(this.GetTezina() + m.GetTezina() > this.max_tezina)
			System.out.println("Greska: Pretovaren avion, ne moze se ubaciti objekat u isti");
		else
			m_objekti[i] = m;
	}

	@Override
	public String GetOpis()
	{
		String s = super.GetOpis() + " : " + System.lineSeparator();
		
		for(Merljivi m : this.m_objekti)
			if(m != null)
				s += "\t" + m.GetOpis() + System.lineSeparator();
		
		return s;
	}	

}
