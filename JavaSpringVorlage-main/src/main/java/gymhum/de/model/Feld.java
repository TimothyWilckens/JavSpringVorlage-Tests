package gymhum.de.model;

public class Feld {
    boolean istFrei;
    boolean zustand;
    // Zustand true=O und false=X

    public Feld(){
        setIstFrei(true);
        setZustand(true);
    }
    public void setIstFrei(boolean istFrei) {
        this.istFrei = istFrei;
    }
    public void setZustand(boolean zustand) {
        this.zustand = zustand;
    }
    public boolean getIstFrei() {
        return istFrei;
    }
    public boolean getZustand() {
        return zustand;
    }
}
