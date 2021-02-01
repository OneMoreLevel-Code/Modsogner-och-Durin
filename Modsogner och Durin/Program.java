/*
 * author: Felix Cederblad
 * mail: felix_cederblad@hotmail.com
 * username: fece4341
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Program
{
	private static ArrayList<Kund> kunder = new ArrayList<>();
	private static ArrayList<Uppdrag> uppdragsLista = new ArrayList<>();
	private static ArrayList<TelefonNummer> nummer = new ArrayList<>();
	private static ArrayList<Kund> kunderUppdragetÄrFör = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	private static boolean nummerFinnsRedan = false;
	private static String rättInmatadSträng;
	private static int rättInmatadInt;
	
	
	private static String scannaInSträng()
	{
		boolean rättSträngInmatad = false;
		while(rättSträngInmatad==false)
		{
			System.out.print("Skriv in text: ");
			String inmatadSträng = scan.nextLine();
			
			if(inmatadSträng.isEmpty())
			{
				System.out.println("Tom inmatning, försök igen");
			}	
			else
			{
				rättSträngInmatad = true;
				rättInmatadSträng = inmatadSträng;
			}
		}	
		return rättInmatadSträng;
	}
	private static int scannaInInt()
	{
		boolean rättIntInmatad = false;
		while(rättIntInmatad==false)
		{
			System.out.print("Skriv in siffror: ");
			int inmatadInt = scan.nextInt();
			
			if(inmatadInt==0)
			{
				System.out.println("Tom inmatning, försök igen");
			}	
			else
			{
				rättIntInmatad = true;
				rättInmatadInt = inmatadInt;
			}
		}	
		scan.nextLine();
		return rättInmatadInt;
	}
	private static String inmatningAvVal() 
	{
		return scannaInSträng().toLowerCase();
	}
	private static void printaMeny()
	{
		System.out.println("1: Lägg till kund \t \t 2: Ta bort kund");
		System.out.println("3: Lägg till telefonnummer \t 4: Lägg till uppdrag");
		System.out.println("5: Lista alla uppdrag \t \t 6: Lista alla uppdrag för en viss kund");
		System.out.println("7: Lista alla kunder \t \t 8: Skriv ut fakturor");
		System.out.println("9: Hitta bästa kunden \t \t 10: Hitta kunder med samma telefonnummer");
		System.out.println("11: Avsluta");
	}
	private static void printNewLine()
	{
		System.out.println("\n");
	}
	
	private static void starta()
	{
		String testKnd1Namn = "testKnd1";
		String testKnd2Namn = "testKnd2";
		String testKnd3Namn = "testKnd3";
		
		String testKnd1Adress = "testAdress1";
		String testKnd2Adress = "testAdress2";
		String testKnd3Adress = "testAdress3";
		
		Kund testKund1 = new Kund(testKnd1Namn, testKnd1Adress);
		Kund testKund2 = new Kund(testKnd2Namn, testKnd2Adress);
		Kund testKund3 = new Kund(testKnd3Namn, testKnd3Adress);
		
		kunder.add(testKund1);
		kunder.add(testKund2);
		kunder.add(testKund3);
		
		TelefonNummer telefonNummer1 = new TelefonNummer("0734-892577", "Mobil");
		TelefonNummer telefonNummer2 = new TelefonNummer("0737-892577", "Mobil");
		TelefonNummer telefonNummer3 = new TelefonNummer("0736-812577", "Mobil");
		TelefonNummer telefonNummer4 = new TelefonNummer("0723-812577", "Hemtelefon");
		
		testKund1.läggaTillTelefonNummer(telefonNummer1);
		testKund2.läggaTillTelefonNummer(telefonNummer2);
		testKund3.läggaTillTelefonNummer(telefonNummer3);
		testKund3.läggaTillTelefonNummer(telefonNummer4);
		
		nummer.add(telefonNummer1);
		nummer.add(telefonNummer2);
		nummer.add(telefonNummer3);
		nummer.add(telefonNummer4);
		
		telefonNummer1.läggaTillKundTillTeleNummer(testKund1);
		telefonNummer2.läggaTillKundTillTeleNummer(testKund2);
		telefonNummer3.läggaTillKundTillTeleNummer(testKund3);
		telefonNummer4.läggaTillKundTillTeleNummer(testKund3);
		
		Uppdrag uppdrag1 = new Uppdrag("11/12/2015", "Bygga Stenmur", 9);
		Uppdrag uppdrag2 = new Uppdrag("13/12/2015", "Bygga Trottoar", 20);
		Uppdrag uppdrag3 = new Uppdrag("16/12/2015", "Bygga Trappa", 115);
		
		uppdragsLista.add(uppdrag1);
		uppdragsLista.add(uppdrag2);
		uppdragsLista.add(uppdrag3);
		
		testKund1.läggaTillUppdrag(uppdrag1);
		testKund2.läggaTillUppdrag(uppdrag2);
		testKund3.läggaTillFaktureratUppdrag(uppdrag3);
		testKund3.läggaTillUppdrag(uppdrag1);
		
		uppdrag1.läggaTillKundTillUppdrag(testKund1);	
		uppdrag2.läggaTillKundTillUppdrag(testKund2);
		uppdrag3.läggaTillKundTillUppdrag(testKund3);
		uppdrag1.läggaTillKundTillUppdrag(testKund3);
		
		Andel andel1 = new Andel(33);
		Andel andel2 = new Andel(33);
		Andel andel3 = new Andel(34);
		Andel andel4 = new Andel(34);
		
		testKund1.läggaTillAndel(andel1);
		testKund2.läggaTillAndel(andel2);
		testKund3.läggaTillFaktureradAndel(andel3);
		testKund3.läggaTillAndel(andel4);
		
		testKund1.totaltFaktureratBelopp(9);
		testKund2.totaltFaktureratBelopp(20);
		testKund3.totaltFaktureratBelopp(124);

		
	}
	private static void kör()
	{
		
		for(;;)
		{
			printaMeny();
			switch (inmatningAvVal())
			{
				case "1":
					läggTillKund();
					break;
				case "2":
					taBortKund();
					break;
				case "3":
					läggTillTelefonNummer();
					break;
				case "4":
					läggTillUppdrag();
					break;
				case "5":
					listaAllaUppdrag();
					break;
				case "6":
					listaUppdragFörKund();
					break;
				case "7":
					listaKunder();
					break;
				case "8":
					skrivUtFakturor();
					break;
				case "9":
					hittaBästaKunden();
					break;
				case "10":
					hittaKunderMedSammaTelefonNummer();
					break;
				case "11":
					avsluta();
					return;

			}
		}
	}
	private static void avsluta()
	{
		System.out.println("Programmet avslutas!");
	}
	private static String inmatningKundNamn()
	{
		System.out.println("Mata in kundnamn: ");
		return scan.nextLine();
	}
	private static Kund sökKund(String kundNamn)
	{
		int kundIndex = 0;
		while (kundIndex < kunder.size()) 
		{
			if ((kunder.get(kundIndex).getNamn()).equals(kundNamn)) 
			{
				break;
			} 
			else 
			{
				kundIndex++;
			}
		}
		return kunder.get(kundIndex);
	}
	private static void läggTillKund()
	{
		Kund kund = skapaKund();
		if(kund!=null)
		{
			kunder.add(kund);	
			Collections.sort(kunder);
			System.out.println("Kund har lagts till");
		}
	}
	private static Kund skapaKund()
	{
		System.out.println("Vad heter den nya kunden: ");
		String kundNamn = scannaInSträng();
		
		int kundIndex = 0;
		while (kundIndex < kunder.size()) 
		{
			if ((kunder.get(kundIndex).getNamn()).equals(kundNamn)) 
			{
				System.out.println("Denna kund existerar redan");
				return null;
			} 
			else 
			{
				kundIndex++;
			}
		}
			System.out.println("Adress: ");
			String kundAdress = scannaInSträng();
			
			Kund kund = new Kund(kundNamn, kundAdress);	
			return kund;
		
	}
	private static void taBortKund()
	{
		System.out.println("Vilken kund ska tas bort: ");
		String kundAttTasBort = scannaInSträng();
		
		boolean kundBorttagen = false;
		int kundIndex = 0;
		while (kundIndex < kunder.size()) 
		{
			if ((kunder.get(kundIndex).getNamn()).equals(kundAttTasBort)) 
			{
				if(kunder.get(kundIndex).getUppdragslistaStorlek()>0)
				{
					break;
				}
				kunder.remove(kundIndex);
				kundBorttagen = true;
			} 
			else 
			{
				kundIndex++;
			}
		}
		if(kundBorttagen == true)
		{
			System.out.println(kundAttTasBort + " har tagits bort.");
		}
		else if(kundIndex<kunder.size() && kundBorttagen==false)
		{
			System.out.println("Kunden har betalningar kvar att betala, kunden går inte att ta bort");
		}
		else
		{
			System.out.println("Denna kund existerar inte");
		}	
	}
	private static void läggTillTelefonNummer() 
	{
		TelefonNummer telefonNummer = skapaTelefonNummer();
		String kundensNamn = inmatningKundNamn();
		sökKund(kundensNamn).läggaTillTelefonNummer(telefonNummer);
		telefonNummer.läggaTillKundTillTeleNummer(sökKund(kundensNamn));
		if(nummerFinnsRedan==false)
		{
			nummer.add(telefonNummer);
		}
		else
		{
			nummerFinnsRedan = false;
		}
		System.out.println("TelefonNummer har lagts till");
		
	}
	private static TelefonNummer skapaTelefonNummer()
	{
		System.out.println("Nummer: ");
		String teleNum = scannaInSträng();
		
		int teleIndex = 0;
		while (teleIndex < nummer.size()) 
		{
			if ((nummer.get(teleIndex).getTeleNummer()).equals(teleNum)) 
			{
				System.out.println("Detta nummer existerar redan");
				nummerFinnsRedan = true;
				return nummer.get(teleIndex);

			} 
			else 
			{
				teleIndex++;
			}
		}
		System.out.println("Beskrivning: ");
		String beskrivning = scannaInSträng();
		
		TelefonNummer telefonNummer = new TelefonNummer(teleNum, beskrivning);
		return telefonNummer;
	}
	private static void läggTillUppdrag() 
	{
		Uppdrag uppdrag = skapaUppdrag();
		uppdragsLista.add(uppdrag);
		for(Kund kundUppdragetÄrFör : kunderUppdragetÄrFör)
		{
			kundUppdragetÄrFör.läggaTillUppdrag(uppdrag);
			uppdrag.läggaTillKundTillUppdrag(kundUppdragetÄrFör);
		}	
		kunderUppdragetÄrFör.clear();
		System.out.println("Uppdraget tillagt");
		
	}
	private static Uppdrag skapaUppdrag()
	{
		System.out.println("Datum (DD/MM/YYYY): ");
		String datum = scannaInSträng();
		
		System.out.println("Beskrivning: ");
		String beskrivning = scannaInSträng();
		
		System.out.println("Antal timmar: ");
		int antalTimmar = scannaInInt();
		
		
		int procentAndel = 0;
		int kvarvarandeProcentAndel = 100;
		while(procentAndel<100)
		{	
			System.out.println("Vilken kund utförs uppdraget för: ");
			String kund = scannaInSträng();
			kunderUppdragetÄrFör.add(sökKund(kund));
			int procentAttBetalaFör = 0;
			boolean rättProcent = false;
			while(rättProcent==false)
			{
				System.out.println("Hur många procent av uppdraget ska " + kund + " betala: ");
				procentAttBetalaFör = scannaInInt();
				if(procentAttBetalaFör>100)
				{
					System.out.println("Alltför högt värde, högsta möjliga är 100");
				}
				else if(procentAttBetalaFör<0)
				{
					System.out.println("Alltför lågt värde, lägsta möjliga är 0");
				}
				else if(procentAttBetalaFör>kvarvarandeProcentAndel)
				{
					System.out.println("För hög procentandel, kvarvarande procentandel att fyllas är: " + kvarvarandeProcentAndel);
				}
				else
				{
					kvarvarandeProcentAndel -= procentAttBetalaFör;
					Andel andel = new Andel(procentAttBetalaFör);
					sökKund(kund).läggaTillAndel(andel);
					procentAndel += procentAttBetalaFör;
					rättProcent = true;
				}
			}			
		}
		Uppdrag uppdrag = new Uppdrag(datum, beskrivning, antalTimmar);
		return uppdrag;
	}
	private static void listaAllaUppdrag() 
	{
		printNewLine();
		for(Uppdrag uppdrag : uppdragsLista)
		{
			System.out.println(uppdrag + "\n");
		}
		printNewLine();
	}	
	private static void listaUppdragFörKund() 
	{
		Kund k = sökKund(inmatningKundNamn());
		printNewLine();
		k.listaUppdrag();		
		printNewLine();
	}
	private static void listaKunder() 
	{
		printNewLine();
		System.out.println("Namn/Adress/Telefon");
		for(Kund kund : kunder)
		{
			System.out.println(kund);
		}
		printNewLine();
	}
	private static void skrivUtFakturor() 
	{
		for(Kund kund : kunder)
		{
			kund.skrivUtFaktura();
		}
		
	}
	private static void hittaBästaKunden() 
	{	
			int antalKunderSomHarFakturerat = 0;
			for(Kund kund : kunder)
			{
				if(kund.getTotalFakturering()>0)
				{
					antalKunderSomHarFakturerat++;
				}
			}
			
			int faktureringTop1Index = 0;
			for(int a = 0; a<kunder.size(); a++)
			{
				if(kunder.get(a).getTotalFakturering()>=kunder.get(faktureringTop1Index).getTotalFakturering())
				{
					faktureringTop1Index = a;
				}	
			}	
			int faktureringTop2Index = 0;
			for(int a = 0; a<kunder.size(); a++)
			{	
				if(a!=faktureringTop1Index)
				{
					if(kunder.get(a).getTotalFakturering()>=kunder.get(faktureringTop2Index).getTotalFakturering() && antalKunderSomHarFakturerat>1)
					{
						faktureringTop2Index = a;	
					}
					if (a!=0 && faktureringTop1Index==0 && faktureringTop2Index==0)
					{
						faktureringTop2Index = a;	
					}
				}					
			}
			int faktureringTop3Index = 0;
			for(int a = 0; a<kunder.size(); a++)
			{
				if(a!=faktureringTop1Index && a!=faktureringTop2Index)
				{
					if(kunder.get(a).getTotalFakturering()>=kunder.get(faktureringTop3Index).getTotalFakturering() && antalKunderSomHarFakturerat>2)
					{
						faktureringTop3Index = a;	
					}
					if (a!=0 && faktureringTop1Index==0 && faktureringTop3Index==0)
					{
						faktureringTop3Index = a;	
					}
					if (a!=0 && faktureringTop2Index==0 && faktureringTop3Index==0)
					{
						faktureringTop3Index = a;	
					}
				}
			}
			if(antalKunderSomHarFakturerat>0)
			{
				System.out.println("\nTop kunder: ");
				System.out.println("1: " + kunder.get(faktureringTop1Index).getNamn() + " har det fakturerade beloppet " + kunder.get(faktureringTop1Index).getTotalFakturering());	
			}
			else
			{
				System.out.println("\nIngen kund har fakturerats");
			}
			if(antalKunderSomHarFakturerat>1)
			{
				System.out.println("2: " + kunder.get(faktureringTop2Index).getNamn() + " har det fakturerade beloppet " + kunder.get(faktureringTop2Index).getTotalFakturering());
			}
			if(antalKunderSomHarFakturerat>2)
			{
				System.out.println("3: " + kunder.get(faktureringTop3Index).getNamn() + " har det fakturerade beloppet " + kunder.get(faktureringTop3Index).getTotalFakturering());
			}
			printNewLine();
	}
	private static void listaÖverTeleNumMedFlerKunder() 
	{
		String kunderMedSammaTelefonNummer = "";
		printNewLine();
		for(TelefonNummer tele : nummer)
		{
			if(!tele.kollaTelefonNummretsAntalKunder().equals(""))
			{
				kunderMedSammaTelefonNummer += tele.kollaTelefonNummretsAntalKunder() + "\n";
			}
		}
		if(kunderMedSammaTelefonNummer.equals(""))
		{
			System.out.println("\nInga kunder delar telefonnummer\n");
		}
		else
		{
			System.out.println(kunderMedSammaTelefonNummer);
		}
	}
	private static void hittaKunderMedSammaTelefonNummer() 
	{	
		listaÖverTeleNumMedFlerKunder();	
	}

	public static void main(String[] args)
	{
		starta();
		kör();
		avsluta();
	}
}
