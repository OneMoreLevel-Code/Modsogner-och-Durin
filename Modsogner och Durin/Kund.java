/*
 * author: Felix Cederblad
 * mail: felix_cederblad@hotmail.com
 * username: fece4341
 */
import java.util.ArrayList;
public class Kund implements Comparable<Kund>
{
	private String namn;
	private String adress;
	private ArrayList<TelefonNummer> nummer = new ArrayList<>();
	private ArrayList<Andel> andelar = new ArrayList<>();
	private ArrayList<Andel> andelarSomÄrFakturerade = new ArrayList<>();
	private ArrayList<Uppdrag> uppdrag = new ArrayList<>();	
	private ArrayList<Uppdrag> faktureradeUppdrag = new ArrayList<>();	
	private final int KOSTNAD = 9999;
	private int totalFakturering = 0;

	public Kund(String namn, String adress)
	{
		this.setNamn(namn);
		this.setAdress(adress);
	}
	public void läggaTillTelefonNummer(TelefonNummer TelefonNummer)
	{
		nummer.add(TelefonNummer);
	}
	
	public String listaKundensTelefonNummer()
	{
		if(nummer.size()>0)
		{
			String totTeleNummer = "";
			for(TelefonNummer telefonNummer : nummer)
			{
				totTeleNummer += telefonNummer;
			}
			return totTeleNummer;
		}
		else
		{
			String ingetTeleNummer = "Kunden har inget telefonnummer";
			return ingetTeleNummer;
		}
	}
	public void läggaTillUppdrag(Uppdrag uppdrag)
	{
		this.uppdrag.add(uppdrag);
	}
	public void läggaTillFaktureratUppdrag(Uppdrag uppdrag)
	{
		this.faktureradeUppdrag.add(uppdrag);
	}
	
	public void läggaTillAndel(Andel andel)
	{
		this.andelar.add(andel);
	}
	public void läggaTillFaktureradAndel(Andel andel)
	{
		this.andelarSomÄrFakturerade.add(andel);
	}
	public void skrivUtFaktura()
	{	
		int antalTimmarTot = 0;
		int totSumma = 0;
		System.out.println("Faktura för: " + namn);
		for(int i = 0; i<uppdrag.size(); i++)
		{
			System.out.println("Uppdrag: " + uppdrag.get(i).getBeskrivning() + " " + andelar.get(i).getProcent() * KOSTNAD * uppdrag.get(i).getAntalTimmar()/100 + "kr");
			andelarSomÄrFakturerade.add(andelar.get(i));
			läggaTillFaktureratUppdrag(uppdrag.get(i));
			antalTimmarTot += uppdrag.get(i).getAntalTimmar();
			totSumma += andelar.get(i).getProcent()*KOSTNAD * uppdrag.get(i).getAntalTimmar();
			uppdrag.remove(i);
			andelar.remove(i);	
			i--;
		}
		if(totSumma!=0)
		{
			totaltFaktureratBelopp(antalTimmarTot);
			System.out.println("Totalt att betala: " + totSumma/100 + "kr");
			System.out.println("\n");
		}
		else
		{
			System.out.println("Det finns inget uppdrag att fakturera för:" + namn + "\n");
		}
	}
	public void totaltFaktureratBelopp(int antalTimmarTot)
	{
		int tot = 0;
		for(int i = 0; i<andelarSomÄrFakturerade.size(); i++)
		{		
			tot += andelarSomÄrFakturerade.get(i).getProcent();
		}
		totalFakturering = tot*KOSTNAD*antalTimmarTot/100;
	}
	public void listaUppdrag()
	{
		for(Uppdrag uppdrag : uppdrag)
		{
			System.out.println(uppdrag + "\n");
		}
	}

	public String getNamn() 
	{
		return namn;
	}
	public int getTotalFakturering() 
	{
		return totalFakturering;
	}
	public int getUppdragslistaStorlek() 
	{
		return uppdrag.size();
	}
	public void setNamn(String namn) 
	{
		this.namn = namn;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int compareTo(Kund jämförKund)
	{
		return namn.compareTo(jämförKund.getNamn());
	}
	public String toString()
	{
		return namn + "\t" + adress + "\t" + listaKundensTelefonNummer();
	}

}
