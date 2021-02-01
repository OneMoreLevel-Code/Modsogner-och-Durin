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
	private static ArrayList<Kund> kunderUppdraget�rF�r = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	private static boolean nummerFinnsRedan = false;
	private static String r�ttInmatadStr�ng;
	private static int r�ttInmatadInt;
	
	
	private static String scannaInStr�ng()
	{
		boolean r�ttStr�ngInmatad = false;
		while(r�ttStr�ngInmatad==false)
		{
			System.out.print("Skriv in text: ");
			String inmatadStr�ng = scan.nextLine();
			
			if(inmatadStr�ng.isEmpty())
			{
				System.out.println("Tom inmatning, f�rs�k igen");
			}	
			else
			{
				r�ttStr�ngInmatad = true;
				r�ttInmatadStr�ng = inmatadStr�ng;
			}
		}	
		return r�ttInmatadStr�ng;
	}
	private static int scannaInInt()
	{
		boolean r�ttIntInmatad = false;
		while(r�ttIntInmatad==false)
		{
			System.out.print("Skriv in siffror: ");
			int inmatadInt = scan.nextInt();
			
			if(inmatadInt==0)
			{
				System.out.println("Tom inmatning, f�rs�k igen");
			}	
			else
			{
				r�ttIntInmatad = true;
				r�ttInmatadInt = inmatadInt;
			}
		}	
		scan.nextLine();
		return r�ttInmatadInt;
	}
	private static String inmatningAvVal() 
	{
		return scannaInStr�ng().toLowerCase();
	}
	private static void printaMeny()
	{
		System.out.println("1: L�gg till kund \t \t 2: Ta bort kund");
		System.out.println("3: L�gg till telefonnummer \t 4: L�gg till uppdrag");
		System.out.println("5: Lista alla uppdrag \t \t 6: Lista alla uppdrag f�r en viss kund");
		System.out.println("7: Lista alla kunder \t \t 8: Skriv ut fakturor");
		System.out.println("9: Hitta b�sta kunden \t \t 10: Hitta kunder med samma telefonnummer");
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
		
		testKund1.l�ggaTillTelefonNummer(telefonNummer1);
		testKund2.l�ggaTillTelefonNummer(telefonNummer2);
		testKund3.l�ggaTillTelefonNummer(telefonNummer3);
		testKund3.l�ggaTillTelefonNummer(telefonNummer4);
		
		nummer.add(telefonNummer1);
		nummer.add(telefonNummer2);
		nummer.add(telefonNummer3);
		nummer.add(telefonNummer4);
		
		telefonNummer1.l�ggaTillKundTillTeleNummer(testKund1);
		telefonNummer2.l�ggaTillKundTillTeleNummer(testKund2);
		telefonNummer3.l�ggaTillKundTillTeleNummer(testKund3);
		telefonNummer4.l�ggaTillKundTillTeleNummer(testKund3);
		
		Uppdrag uppdrag1 = new Uppdrag("11/12/2015", "Bygga Stenmur", 9);
		Uppdrag uppdrag2 = new Uppdrag("13/12/2015", "Bygga Trottoar", 20);
		Uppdrag uppdrag3 = new Uppdrag("16/12/2015", "Bygga Trappa", 115);
		
		uppdragsLista.add(uppdrag1);
		uppdragsLista.add(uppdrag2);
		uppdragsLista.add(uppdrag3);
		
		testKund1.l�ggaTillUppdrag(uppdrag1);
		testKund2.l�ggaTillUppdrag(uppdrag2);
		testKund3.l�ggaTillFaktureratUppdrag(uppdrag3);
		testKund3.l�ggaTillUppdrag(uppdrag1);
		
		uppdrag1.l�ggaTillKundTillUppdrag(testKund1);	
		uppdrag2.l�ggaTillKundTillUppdrag(testKund2);
		uppdrag3.l�ggaTillKundTillUppdrag(testKund3);
		uppdrag1.l�ggaTillKundTillUppdrag(testKund3);
		
		Andel andel1 = new Andel(33);
		Andel andel2 = new Andel(33);
		Andel andel3 = new Andel(34);
		Andel andel4 = new Andel(34);
		
		testKund1.l�ggaTillAndel(andel1);
		testKund2.l�ggaTillAndel(andel2);
		testKund3.l�ggaTillFaktureradAndel(andel3);
		testKund3.l�ggaTillAndel(andel4);
		
		testKund1.totaltFaktureratBelopp(9);
		testKund2.totaltFaktureratBelopp(20);
		testKund3.totaltFaktureratBelopp(124);

		
	}
	private static void k�r()
	{
		
		for(;;)
		{
			printaMeny();
			switch (inmatningAvVal())
			{
				case "1":
					l�ggTillKund();
					break;
				case "2":
					taBortKund();
					break;
				case "3":
					l�ggTillTelefonNummer();
					break;
				case "4":
					l�ggTillUppdrag();
					break;
				case "5":
					listaAllaUppdrag();
					break;
				case "6":
					listaUppdragF�rKund();
					break;
				case "7":
					listaKunder();
					break;
				case "8":
					skrivUtFakturor();
					break;
				case "9":
					hittaB�staKunden();
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
	private static Kund s�kKund(String kundNamn)
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
	private static void l�ggTillKund()
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
		String kundNamn = scannaInStr�ng();
		
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
			String kundAdress = scannaInStr�ng();
			
			Kund kund = new Kund(kundNamn, kundAdress);	
			return kund;
		
	}
	private static void taBortKund()
	{
		System.out.println("Vilken kund ska tas bort: ");
		String kundAttTasBort = scannaInStr�ng();
		
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
			System.out.println("Kunden har betalningar kvar att betala, kunden g�r inte att ta bort");
		}
		else
		{
			System.out.println("Denna kund existerar inte");
		}	
	}
	private static void l�ggTillTelefonNummer() 
	{
		TelefonNummer telefonNummer = skapaTelefonNummer();
		String kundensNamn = inmatningKundNamn();
		s�kKund(kundensNamn).l�ggaTillTelefonNummer(telefonNummer);
		telefonNummer.l�ggaTillKundTillTeleNummer(s�kKund(kundensNamn));
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
		String teleNum = scannaInStr�ng();
		
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
		String beskrivning = scannaInStr�ng();
		
		TelefonNummer telefonNummer = new TelefonNummer(teleNum, beskrivning);
		return telefonNummer;
	}
	private static void l�ggTillUppdrag() 
	{
		Uppdrag uppdrag = skapaUppdrag();
		uppdragsLista.add(uppdrag);
		for(Kund kundUppdraget�rF�r : kunderUppdraget�rF�r)
		{
			kundUppdraget�rF�r.l�ggaTillUppdrag(uppdrag);
			uppdrag.l�ggaTillKundTillUppdrag(kundUppdraget�rF�r);
		}	
		kunderUppdraget�rF�r.clear();
		System.out.println("Uppdraget tillagt");
		
	}
	private static Uppdrag skapaUppdrag()
	{
		System.out.println("Datum (DD/MM/YYYY): ");
		String datum = scannaInStr�ng();
		
		System.out.println("Beskrivning: ");
		String beskrivning = scannaInStr�ng();
		
		System.out.println("Antal timmar: ");
		int antalTimmar = scannaInInt();
		
		
		int procentAndel = 0;
		int kvarvarandeProcentAndel = 100;
		while(procentAndel<100)
		{	
			System.out.println("Vilken kund utf�rs uppdraget f�r: ");
			String kund = scannaInStr�ng();
			kunderUppdraget�rF�r.add(s�kKund(kund));
			int procentAttBetalaF�r = 0;
			boolean r�ttProcent = false;
			while(r�ttProcent==false)
			{
				System.out.println("Hur m�nga procent av uppdraget ska " + kund + " betala: ");
				procentAttBetalaF�r = scannaInInt();
				if(procentAttBetalaF�r>100)
				{
					System.out.println("Alltf�r h�gt v�rde, h�gsta m�jliga �r 100");
				}
				else if(procentAttBetalaF�r<0)
				{
					System.out.println("Alltf�r l�gt v�rde, l�gsta m�jliga �r 0");
				}
				else if(procentAttBetalaF�r>kvarvarandeProcentAndel)
				{
					System.out.println("F�r h�g procentandel, kvarvarande procentandel att fyllas �r: " + kvarvarandeProcentAndel);
				}
				else
				{
					kvarvarandeProcentAndel -= procentAttBetalaF�r;
					Andel andel = new Andel(procentAttBetalaF�r);
					s�kKund(kund).l�ggaTillAndel(andel);
					procentAndel += procentAttBetalaF�r;
					r�ttProcent = true;
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
	private static void listaUppdragF�rKund() 
	{
		Kund k = s�kKund(inmatningKundNamn());
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
	private static void hittaB�staKunden() 
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
	private static void lista�verTeleNumMedFlerKunder() 
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
		lista�verTeleNumMedFlerKunder();	
	}

	public static void main(String[] args)
	{
		starta();
		k�r();
		avsluta();
	}
}
