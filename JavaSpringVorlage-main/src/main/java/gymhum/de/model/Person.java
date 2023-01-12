package gymhum.de.model;

public class Person {
    
    String vorname;
    String nachname;
    int alter;

    public Person(String vorname, String nachname, int alter){
        setAlter(alter);
        setNachname(nachname);
        setVorname(vorname);
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getAlter() {
        return alter;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

}





