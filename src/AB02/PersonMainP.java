package AB02;

class Firma {
    private Person[] mitarbeiter;

    public Firma (Person[] p) {
        mitarbeiter = p;
    }
}


abstract class Person {
    private String name;
    private String vorname;
    private int personalNummer;
    private int alter;

    public Person(String name, String vorname,  int personalNummer, int alter) {
        this.name = name;
        this.vorname = vorname;
        this.personalNummer = personalNummer;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void print() {
        System.out.print("Name: " + name + ", Vorname: " + vorname + ", Personalnummer: " + personalNummer + ", ");
    }

    public abstract int berechneFerien(int alter);
}

class Chef extends Person {
    String abteilung;
    public Chef(String name, String vorname,  int personalNummer, int alter, String abteilung) {
        super(name, vorname, personalNummer, alter);
        this.abteilung = abteilung;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Abteilung: " + abteilung);
    }

    @Override
    public int berechneFerien(int alter) {
        if (alter >= 55) {
            return 6;
        }
        if (alter >= 45) {
            return 5;
        }
        return 4;
    }
}

class Fachangestellter extends Person {
    Chef vorgesetzter;
    public Fachangestellter(String name, String vorname,  int personalNummer, int alter, Chef vorgesetzter) {
        super(name, vorname, personalNummer, alter);
        this.vorgesetzter = vorgesetzter;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Vorgesetzter: " + vorgesetzter.getName() + " " + vorgesetzter.getVorname());
    }

    @Override
    public int berechneFerien(int alter) {
        if (alter >= 60) {
            return 6;
        }
        if (alter >= 50) {
            return 5;
        }
        return 4;
    }
}

class Lehrnender extends Person {
    int lehrjahr;
    public Lehrnender(String name, String vorname,  int personalNummer, int alter, int lehrjahr) {
        super(name, vorname, personalNummer, alter);
        this.lehrjahr = lehrjahr;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Lehrjahr: " + lehrjahr);
    }

    @Override
    public int berechneFerien(int alter) {
        return 5;
    }
}

public class PersonMainP {
    public static void main (String args[]) {

        Firma f = new Firma(
                new Person[] {new Chef("Sattler", "Beatrice",25, 30, "Verkauf")} );

        Chef c = new Chef("Müller", "Hans", 34, 25, "CS");
        Fachangestellter fa = new Fachangestellter("Cornu", "Pascal", 001,17, c);
        Lehrnender l = new Lehrnender("Borter", "Florian", 002, 16, 2);

        //c.print();
        //fa.print();
        //l.print();

        Person[] angestellte = new Person[3];
        angestellte[0] = c;
        angestellte[1] = fa;
        angestellte[2] = l;
        for (Person p : angestellte) {
            p.print();
            System.out.println("Der Ferienanspruch beträgt: " + p.berechneFerien(46));
        }

//        Chef personal3 = new Chef("Sattler", "Beatrice", 0, "Verkauf");
//        Fachangestellter personal2 = new Fachangestellter("", "", 0, personal3);
//        Person personal4 = new Person("", "", 0);
//        Fachangestellter personal1 = new Fachangestellter("Klein", "Thomas", 0, personal3);
//
//        personal1.vorgesetzter=personal3; 		//*1
//        personal4 = personal1; 				//*2
//        personal4.vorgesetzter = personal3; 		//*3
//        personal1 = personal4; 				//*4
//        personal1 = (Fachangestellter) personal4; 	//*5

    }
}