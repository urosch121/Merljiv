package tovar;

import merljivi.Merljivi;

public class Paket implements Merljivi 
{
	protected String opis;
	private double tezina;
	
	public Paket(String opis, double tezina)
	{
		this.tezina = tezina;
		this.opis = opis;
	}
	
	@Override
	public double GetTezina() 
	{
		return this.tezina;
	}

	@Override
	public String GetOpis() 
	{
		return this.opis;
	}

}
