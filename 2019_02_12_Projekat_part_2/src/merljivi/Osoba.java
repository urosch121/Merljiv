package merljivi;

public class Osoba implements Merljivi 
{
	protected String ime;
	protected double tezina;
	
	public Osoba(String ime, double tezina)
	{
		this.ime = ime;
		this.tezina = tezina;
	}
	
	@Override
	public double GetTezina() 
	{
		return this.tezina;
	}

	@Override
	public String GetOpis() 
	{
		return this.ime + "(" + this.tezina + ")";
	}

	
}
