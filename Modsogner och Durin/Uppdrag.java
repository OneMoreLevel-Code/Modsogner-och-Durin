/*
 * author: Felix Cederblad
 * mail: felix_cederblad@hotmail.com
 * username: fece4341
 */
import java.util.ArrayList;
public class Uppdrag 
{
	private String datum, beskrivning;
	private int antalTimmar;
	private ArrayList<Kund> kunder = new ArrayList<>();


	
	public Uppdrag(String datum, String beskrivning, int antalTimmar)
	{
		this.setDatum(datum);
		this.setBeskrivning(beskrivning);
		this.setAntalTimmar(antalTimmar);
	}
	public void läggaTillKundTillUppdrag(Kund kund)
	{
		this.kunder.add(kund);
	}
	public void listaKunder()
	{
		for(Kund kund : kunder)
		{
			System.out.println(kund);
		}
	}
	public String listaKunderUppdragetÄrFör()
	{
		String totKunder = "";
		for(Kund kund : kunder)
		{
			String kundNamn = kund.getNamn()+ " ";
			totKunder += kundNamn;
		}
		return totKunder;
		
	}
	public String getDatum() 
	{
		return datum;
	}
	public void setDatum(String datum) 
	{
		this.datum = datum;
	}
	public String getBeskrivning() 
	{
		return beskrivning;
	}
	public void setBeskrivning(String beskrivning) 
	{
		this.beskrivning = beskrivning;
	}
	public int getAntalTimmar() 
	{
		return antalTimmar;
	}
	public void setAntalTimmar(int antalTimmar) 
	{
		this.antalTimmar = antalTimmar;
	}
	public String toString()
	{
		return "Beskrivning: " + beskrivning + "\nDatum: " + datum  + "\nAntal timmar: " + antalTimmar + "\nKunder uppdraget är för: " + listaKunderUppdragetÄrFör();
	}

}
