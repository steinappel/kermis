
public abstract class Attractie {
	
	int count;
	String naam;
	double prijs;
	double omzet;
	int oppervlakte;
	Attractie(String deNaam, double prijs, int count, double omzet, int oppervlakte){
		this.naam = deNaam;
		this.prijs=prijs;
		this.count =count;
		this.omzet = omzet;
		this.oppervlakte=oppervlakte;
		
	}
	
	
	interface GokAttractie{
		void kansSpelBelastingBetalen();
	}

}

abstract class RisicoRijkeAttractie extends Attractie{
	
	int aantal = 1;
	
	final int draaiLimiet;

	RisicoRijkeAttractie(String deNaam, double prijs, int count, double omzet, int oppervlakte, int draaiLimiet, int aantal) {
		super(deNaam, prijs, count, omzet, oppervlakte);
		this.draaiLimiet = draaiLimiet;
		this.aantal = aantal;
		
		// TODO Auto-generated constructor stub
	}
	
	void opstellingsKeuring(){
        if (aantal == draaiLimiet) {
            System.out.println(naam + " is gekeurd en kan weer draaien");
            aantal = 0;
        } else {
            System.out.println(naam + " heeft maar " + aantal + " keer gedraait en hoeft nog niet gekeurd te worden");
        }
    }
	
	
}

class Botsautos extends Attractie{
	
	 Botsautos(String deNaam, double prijs, int count, double omzet, int oppervlakte) {
		super(deNaam, prijs, count, omzet, oppervlakte);
		// TODO Auto-generated constructor stub
	}
	
}

class Spin extends RisicoRijkeAttractie implements Attractie.GokAttractie{
	
	 Spin(String deNaam, double prijs, int count, double omzet, int oppervlakte, int draaiLimiet, int aantal) {
		super(deNaam, prijs, count, omzet, oppervlakte, draaiLimiet, aantal);
		// TODO Auto-generated constructor stub
	}
	 
	 public void kansSpelBelastingBetalen() {
		 Kassa.Belasting +=(prijs*0.3);
		 omzet+=(prijs-(prijs*0.3));
	 }
	
}

class Hawaii extends RisicoRijkeAttractie{
	
	 Hawaii(String deNaam, double prijs, int count, double omzet, int oppervlakte, int draaiLimiet, int aantal) {
		super(deNaam, prijs, count, omzet, oppervlakte, draaiLimiet, aantal);
		// TODO Auto-generated constructor stub
	}
}

class Spookhuis extends Attractie{
	
	 Spookhuis(String deNaam, double prijs, int count, double omzet, int oppervlakte) {
		super(deNaam, prijs, count, omzet, oppervlakte);
		// TODO Auto-generated constructor stub
	}
	
}

class Spiegelpaleis extends Attractie{
	
	 Spiegelpaleis(String deNaam, double prijs, int count, double omzet, int oppervlakte) {
		super(deNaam, prijs, count, omzet, oppervlakte);
		// TODO Auto-generated constructor stub
	}
	
}

class Ladderklimmen extends Attractie implements Attractie.GokAttractie{
	
	 Ladderklimmen(String deNaam, double prijs, int count, double omzet, int oppervlakte) {
		super(deNaam, prijs, count, omzet, oppervlakte);
		// TODO Auto-generated constructor stub
	}
	 
	 public void kansSpelBelastingBetalen() {
		 Kassa.Belasting +=(prijs*0.3);
		 omzet+=(prijs-(prijs*0.3));
	 }
	
}
