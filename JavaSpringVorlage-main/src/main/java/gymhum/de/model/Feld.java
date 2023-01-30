package gymhum.de.model;

public class Feld {
    int reihe;
    int höhe;
    boolean istBesetzt;
    boolean istKreuz;
    boolean istKreis;

    public Feld(int reihe, int höhe, boolean istBesetzt, boolean istKreuz, boolean istKreis){
        setHöhe(höhe);
        setIstKreuz(istKreuz);
        setReihe(reihe);
        setIstKreis(istKreis);
        setIstBesetzt(istBesetzt);
    }
    public void setIstBesetzt(boolean istBesetzt) {
        this.istBesetzt = istBesetzt;
    }
    public void setIstKreuz(boolean istKreuz) {
        this.istKreuz = istKreuz;
    }
    public void setIstKreis(boolean istKreis) {
        this.istKreis = istKreis;
    }
    public void setHöhe(int höhe) {
        this.höhe = höhe;
    }
    public void setReihe(int reihe) {
        this.reihe = reihe;
    }
    public int getHöhe() {
        return höhe;
    }
    public int getReihe() {
        return reihe;
    }
    public boolean getIstBesetzt() {
        return istBesetzt;
    }
    public boolean getIstKreuz() {
        return istKreuz;
    }
    public boolean getIstKreis() {
        return istKreis;
    }
}
