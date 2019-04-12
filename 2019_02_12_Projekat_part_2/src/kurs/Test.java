package kurs;

import java.util.ArrayList;

import merljivi.Merljivi;
import merljivi.Osoba;
import prevoz.Aerodrom;
import prevoz.PutnickiAvion;
import prevoz.TeretniAvion;
import tovar.Kontejner;
import tovar.Paket;

public class Test 
{

	public static void main(String[] args) 
	{
		/*Kontejner kont = new Kontejner(1500, 5);
		
		kont.Dodati(new Paket("sljive", 100));
		kont.Dodati(new Paket("visnje", 200));
		kont.Dodati(new Paket("kajsije", 150));
		kont.Dodati(new Paket("lubenice", 300));
		kont.Dodati(new Osoba("Djordja", 90));
		
		System.out.println(kont.GetOpis());
		
		System.out.println("--------------------------------------");
		
		Merljivi trazim = kont.Izvaditi("kajsije");
		if(trazim != null)
			System.out.println("Nasao sam kajsije");
		
		trazim = kont.Izvaditi("sljive");
		if(trazim != null)
			System.out.println("Nasao sam sljive");
		
		trazim = kont.Izvaditi("Djordje");
		if(trazim != null)
			System.out.println("Nasao sam Djordja");
		
		System.out.println(kont.GetOpis());*/
		
		Aerodrom nikolatesla = new Aerodrom("Nikola Tesla",2);
		
		Osoba pera = new Osoba("Jovan Jovanovic",70);
		Osoba mika = new Osoba("Mika Alas",78);
		
		Paket p1 = new Paket("Sljive",200);
		Paket p2 = new Paket("Visnje",500);
		
		Kontejner k1 = new Kontejner(500, 2000);
		
		PutnickiAvion pa = new PutnickiAvion("PUTIN12345", 1000,10000);
		TeretniAvion ta = new TeretniAvion("TER1234567", 1000,10000);
		
		k1.Dodati(p1);
		k1.Dodati(p2);
		
		ta.Dodaj(k1);
		
		pa.Dodaj(p1);
		pa.Dodaj(p2);
		System.out.println("*****************");
		pa.Dodaj(k1);
		System.out.println("*****************");
		
		pa.Dodaj(pera);
		pa.Dodaj(mika);
				
		nikolatesla.Slece(pa);	
		nikolatesla.Slece(ta);

		Kontejner k2 = new Kontejner(400, 3);
		
		nikolatesla.DodajObjekat(k2, "TER1234567");
		
		System.out.println("ukupna tezina je " + nikolatesla.UkupnaTezina());
				
		ArrayList<Osoba> osobe = nikolatesla.SpisakOsoba();
		System.out.println("Spsika svih putnika je:");
		for(Osoba osoba : osobe)
			System.out.println(osoba.GetOpis());
		System.out.println("************************");
		
		System.out.println(nikolatesla);
		
		System.out.println("************************");

		nikolatesla.Polece("TER1234567");
		nikolatesla.Polece("PUTIN12345");
	}

	
	
	
}
