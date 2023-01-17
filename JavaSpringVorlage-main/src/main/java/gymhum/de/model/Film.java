package gymhum.de.model;

public class Film {
    String titel;
    int FSK;
    int laenge;

    public Film(String titel, int FSK, int laenge){
        setFSK(FSK);
        setLaenge(laenge);
        setTitel(titel);
    }
    public void setFSK(int fSK) {
        FSK = fSK;
    }
    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public int getFSK() {
        return FSK;
    }
    public int getLaenge() {
        return laenge;
    }
    public String getTitel() {
        return titel;
    }

    
}
