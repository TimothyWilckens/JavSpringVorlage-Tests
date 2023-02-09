package gymhum.de;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gymhum.de.model.Feld;
import gymhum.de.model.Spieler;

@Controller
public class SpielController {

    Feld[][] felder;
    Spieler p1;
    boolean gewonnen;
    
    public SpielController(){
        setFelder(new Feld[6][7]);
        setP1(new Spieler(false));
        setGewonnen(false);
        initFeld();
        // Pruefung();
        // showTestFeld();
    }

    @GetMapping("/spiel")
    public String showSpiel(@RequestParam(name="activePage", required = false, defaultValue = "spiel") String activePage, Model model){
        model.addAttribute("activePage", "spiel");
        model.addAttribute("felder", getFelder());
        model.addAttribute("felder", getFelder());
        model.addAttribute("gewonnen", getGewonnen(gewonnen));
        return "index.html";
    }

    
    @GetMapping("/addstein")
    public String addStein(@RequestParam(name="activePage", required = true, defaultValue = "spiel") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        for(int hoehe = 5; hoehe >= 0; hoehe--) {
            if(getFelder()[hoehe][id].getIstFrei()) {
                if(p1.getActiveplayer() == true) {
                    getFelder()[hoehe][id].setIstFrei(false);
                    getFelder()[hoehe][id].setZustand(true);
                    p1.setActiveplayer(false);
                    System.out.println("Feld " + hoehe + " " + id +" wurde geändert in O");  
                    break;    
                } 
                else if(p1.getActiveplayer()== false) {
                    getFelder()[hoehe][id].setIstFrei(false);
                    getFelder()[hoehe][id].setZustand(false);
                    p1.setActiveplayer(true);   
                    System.out.println("Feld " + hoehe + " " + id +" wurde geändert in X");  
                    break;              
                }             
            } 
        }
        Pruefung();
        return "redirect:/spiel";
    }


    private void initFeld(){
        for(int i = 0; i < 6; i++){
            for(int k = 0; k < 7; k++){
                getFelder()[i][k] = new Feld();
            }
        }
    }

    private void showTestFeld(){
        for(int i = 0; i < 6; i++){
            for(int k = 0; k < 7; k++){
                System.out.print(getFelder()[i][k].getIstFrei() + " ");
            }
        }
    }

    private void TestWerte(){
        // Test Horizontal
        felder[0][0].setIstFrei(false);
        felder[0][0].setZustand(false);
        felder[0][1].setIstFrei(false);
        felder[0][1].setZustand(false);
        felder[0][2].setIstFrei(false);
        felder[0][2].setZustand(false);
        felder[0][3].setIstFrei(false);
        felder[0][3].setZustand(false);

        // Test Vertikal
        felder[2][2].setIstFrei(false);
        felder[2][2].setZustand(false);
        felder[3][2].setIstFrei(false);
        felder[3][2].setZustand(false);
        felder[4][2].setIstFrei(false);
        felder[4][2].setZustand(false);
        felder[5][2].setIstFrei(false);
        felder[5][2].setZustand(false);

        // Test Schräg Unten
        felder[2][2].setIstFrei(false);
        felder[2][2].setZustand(false);
        felder[3][3].setIstFrei(false);
        felder[3][3].setZustand(false);
        felder[4][4].setIstFrei(false);
        felder[4][4].setZustand(false);
        felder[5][5].setIstFrei(false);
        felder[5][5].setZustand(false);

        // Test Schräg Oben
        felder[1][4].setIstFrei(false);
        felder[1][4].setZustand(false);
        felder[2][3].setIstFrei(false);
        felder[2][3].setZustand(false);
        felder[3][2].setIstFrei(false);
        felder[3][2].setZustand(false);
        felder[4][1].setIstFrei(false);
        felder[4][1].setZustand(false);

    }

    private void Pruefung(){

        for(int hoehe = 0; hoehe < 6; hoehe++){
            for(int breite = 0; breite < 4; breite++){
                if(getFelder()[hoehe][breite].getIstFrei() == false && getFelder()[hoehe][breite+1].getIstFrei() == false && getFelder()[hoehe][breite +2 ].getIstFrei() == false && getFelder()[hoehe][breite + 3].getIstFrei() == false){
                    if(getFelder()[hoehe][breite].getZustand() && getFelder()[hoehe][breite+1].getZustand() && getFelder()[hoehe][breite+2].getZustand() && getFelder()[hoehe][breite+3].getZustand()){
                        System.out.println("Spieler O hat gewonnen");
                    }
                    else if(getFelder()[hoehe][breite].getZustand() == false && getFelder()[hoehe][breite+1].getZustand() == false && getFelder()[hoehe][breite+2].getZustand() == false && getFelder()[hoehe][breite+3].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen");
                        setGewonnen(true);
                    }
                }
            }
        }

        for(int hoehe = 0; hoehe < 3; hoehe++){
            for(int breite = 0; breite < 7; breite++){
                if(getFelder()[hoehe][breite].getIstFrei() == false && getFelder()[hoehe+1][breite].getIstFrei() == false && getFelder()[hoehe+2][breite].getIstFrei() == false && getFelder()[hoehe+3][breite].getIstFrei() == false){
                    if(getFelder()[hoehe][breite].getZustand() && getFelder()[hoehe+1][breite].getZustand() && getFelder()[hoehe+2][breite].getZustand() && getFelder()[hoehe+3][breite].getZustand()){
                        System.out.println("Spieler O hat gewonnen");
                    }
                    else if(getFelder()[hoehe][breite].getZustand() == false && getFelder()[hoehe+1][breite].getZustand() == false && getFelder()[hoehe+2][breite].getZustand() == false && getFelder()[hoehe+3][breite].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen");
                        setGewonnen(true);
                    }
                }
            }
        }

        for(int hoehe = 0; hoehe < 3; hoehe++){
            for(int breite = 0; breite < 4; breite++){
                if(getFelder()[hoehe][breite].getIstFrei() == false && getFelder()[hoehe+1][breite+1].getIstFrei() == false && getFelder()[hoehe+2][breite+2].getIstFrei() == false && getFelder()[hoehe+3][breite+3].getIstFrei() == false){
                    if(getFelder()[hoehe][breite].getZustand() && getFelder()[hoehe+1][breite+1].getZustand() && getFelder()[hoehe+2][breite+2].getZustand() && getFelder()[hoehe+3][breite+3].getZustand()){
                        System.out.println("Spieler O hat gewonnen");
                    }
                    else if(getFelder()[hoehe][breite].getZustand() == false && getFelder()[hoehe+1][breite+1].getZustand() == false && getFelder()[hoehe+2][breite+2].getZustand() == false && getFelder()[hoehe+3][breite+3].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen");
                    }
                }
            }
        }

        for(int hoehe = 3; hoehe < 6; hoehe++){
            for(int breite = 0; breite < 4; breite++){
                if(getFelder()[hoehe][breite].getIstFrei() == false && getFelder()[hoehe-1][breite+1].getIstFrei() == false && getFelder()[hoehe-2][breite+2].getIstFrei() == false && getFelder()[hoehe-3][breite+3].getIstFrei() == false){
                    if(getFelder()[hoehe][breite].getZustand() && getFelder()[hoehe-1][breite+1].getZustand() && getFelder()[hoehe-2][breite+2].getZustand() && getFelder()[hoehe-3][breite+3].getZustand()){
                        System.out.println("Spieler O hat gewonnen");
                    }
                    else if(getFelder()[hoehe][breite].getZustand() == false && getFelder()[hoehe-1][breite+1].getZustand() == false && getFelder()[hoehe-2][breite+2].getZustand() == false && getFelder()[hoehe-3][breite+3].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen");
                    }
                }
            }
        }
    }

    public void setFelder(Feld[][] felder) {
        this.felder = felder;
    }
    public Feld[][] getFelder() {
        return felder;
    }

    public void setP1(Spieler p1) {
        this.p1 = p1;
    }

    public Spieler getP1() {
        return p1;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
    }

    public boolean getGewonnen(boolean gewonnen){
        return gewonnen;
    }
}