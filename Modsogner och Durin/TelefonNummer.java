/*
 * author: Felix Cederblad
 * mail: felix_cederblad@hotmail.com
 * username: fece4341
 */
import java.util.ArrayList;
public class TelefonNummer 
{
	private String teleNummer;
	private String beskrivning;
	private ArrayList<Kund> kunder = new ArrayList<>();
	
	public TelefonNummer(String teleNummer, String beskrivning)
	{
		this.setTeleNummer(teleNummer);
		this.setBeskrivning(beskrivning);
	}
	public void läggaTillKundTillTeleNummer(Kund kund)
	{
		this.kunder.add(kund);
	}
	public String kollaTelefonNummretsAntalKunder()
	{
		String totKunder = "";
		if(kunder.size()>1)
		{			
			for(Kund kund : kunder)
			{
				totKunder += "\n" + kund.getNamn();
			}
			return "Telefonnummer: " + this.teleNummer + " har kunderna: " + totKunder;
		}
		else
		{
			return totKunder;
		}
	}
	public String getTeleNummer() 
	{
		return teleNummer;
	}
	public void setTeleNummer(String teleNummer) 
	{
		this.teleNummer = teleNummer;
	}
	public String getBeskrivning() {
		return beskrivning;
	}
	public void setBeskrivning(String beskrivning) {
		this.beskrivning = beskrivning;
	}
	public String toString()
	{
		return beskrivning  + ": " + teleNummer + " ";
	}
}
