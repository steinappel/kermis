import java.util.Random;
import java.util.Scanner;



class Kassa {
	int totaalkaartjes;
	public static double Belasting;
	

	Scanner scanner = new Scanner(System.in);
	Botsautos botsautos = new Botsautos("Botsauto's", 2.5, 0,0,50);
	Spin spin = new Spin("Spin", 2.25, 0,0,50,5,0);
	Spiegelpaleis spiegelpaleis = new Spiegelpaleis("Spiegelpaleis", 2.75, 0,0,50);
	Hawaii hawaii = new Hawaii("Hawaii", 2.9, 0,0,50,10,0);
	Spookhuis spookhuis = new Spookhuis("Spookhuis", 3.2, 0,0,50);
	Ladderklimmen ladderklimmen = new Ladderklimmen("Ladderklimmen", 5.0, 0,0,50);
	Attractie[] attracties = { botsautos, spin, spiegelpaleis, spookhuis, hawaii, ladderklimmen };
	
	void starten() {
		boolean doorgaan = true;
			while (doorgaan) {
				String deKeuze = vraagOmAttractieKeuze();
				if(deKeuze.equals("q")){
					for(Attractie i : attracties) {
                        if (i.count > 0) {
                            System.out.println(i.naam + " - Kaartjes: " + i.count + ", Omzet: " + (i.omzet) + " euro");
                        }
                    }
				doorgaan = false;
			}else {
				if(deKeuze.equals("1")) {
					draaien(botsautos);
				}
				if(deKeuze.equals("2")) {
					System.out.println(spin.draaiLimiet);
					if(spin.aantal == spin.draaiLimiet){
						System.out.println(spin.naam +  " heeft het draai limiet van " + spin.draaiLimiet + " bereikt en moet eerst gekeurd worden (invoer: m)");
					}
					else{
						draaien(spin);
					}
				}
				if(deKeuze.equals("3")) {  
					draaien(spiegelpaleis);
				}
				if(deKeuze.equals("4")) {
					
					if(hawaii.aantal == hawaii.draaiLimiet) {
						 System.out.println(" heeft het draai limiet van " + hawaii.draaiLimiet + " bereikt en moet eerst gekeurd worden (invoer: m)");
					}else {
						draaien(hawaii);
						
					}
					
				}
				if(deKeuze.equals("5")) {
					draaien(spookhuis);
				}
				if(deKeuze.equals("6")) {
					draaien(ladderklimmen);
				}
				if(deKeuze.equals("k")) {
					int total = (botsautos.count+spin.count+spiegelpaleis.count+hawaii.count+spookhuis.count+ladderklimmen.count);
					System.out.println(total);
				}
				if(deKeuze.equals("o")) {
					System.out.println(botsautos.omzet+spin.omzet+spiegelpaleis.omzet+hawaii.omzet+spookhuis.omzet+ladderklimmen.omzet);
					
					
				}
				if(deKeuze.equals("b")) {
					System.out.println(Belasting);
				
				}
				if(deKeuze.equals("m")) {
					spin.opstellingsKeuring();
					hawaii.opstellingsKeuring();
					
				
				}
			
			
			}
				
				
		}
	}
	
	void draaien(Attractie keuze) {
		
		if(keuze instanceof Attractie.GokAttractie) {
			((Attractie.GokAttractie ) keuze).kansSpelBelastingBetalen();
		} else {	
			keuze.omzet+=keuze.prijs;
		}
		if(keuze instanceof RisicoRijkeAttractie) {
			((RisicoRijkeAttractie) keuze).aantal++;
		}
		keuze.count++;
		//System.out.println(keuze.count);
		//System.out.println(((RisicoRijkeAttractie) keuze).aantal);
		System.out.println("Ik ben aan het draaien, de attractie: "+keuze.naam);
	}
	
	String vraagOmAttractieKeuze() {
		System.out.println("Welke attractie wilt u een kaartje voor hebben?");
		Scanner scanner = new Scanner(System.in);
		String invoer = scanner.nextLine();
		
		System.out.println("u heeft gekozen voor: "+invoer);
		return invoer;
	}
	
}
