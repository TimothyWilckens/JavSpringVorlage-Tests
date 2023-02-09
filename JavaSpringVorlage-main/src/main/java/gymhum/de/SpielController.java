package gymhum.de;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gymhum.de.model.Feld;

@Controller
public class SpielController {

    Feld[][] felder;
    
    public SpielController(){
        setFelder(new Feld[6][7]);
        initFeld();
        TestLauf();
        showTestFeld();
    }

    @GetMapping("/spiel")
    public String showSpiel(@RequestParam(name="activePage", required = false, defaultValue = "spiel") String activePage, Model model){
        model.addAttribute("activePage", "spiel");
        model.addAttribute("felder", getFelder());
        return "index.html";
    }

    @GetMapping("/addsteinprep")
    public String addStein(@RequestParam(name="activePage", required = true, defaultValue = "/addstein") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        model.addAttribute("activePage", "spiel");
        model.addAttribute("felder", getFelder()[][id]);
        return "index.html";
    }

    // Die Person wird gelöscht und anschließend geht es zur Tabellenansicht zurück.
    @GetMapping("/addstein")
    public String delPersonenFinal(@RequestParam(name="activePage", required = true, defaultValue = "spiel") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        removePerson(getPerson(id));
        return "redirect:/personen";
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

    private void TestLauf(){

        // Test Horizontal
        felder[0][0].setIstFrei(false);
        felder[0][0].setZustand(false);
        felder[0][1].setIstFrei(false);
        felder[0][1].setZustand(false);
        felder[0][2].setIstFrei(false);
        felder[0][2].setZustand(false);
        felder[0][3].setIstFrei(false);
        felder[0][3].setZustand(false);
        
        for(int hoehe = 0; hoehe < 6; hoehe++){
            for(int breite = 0; breite < 4; breite++){
                if(getFelder()[hoehe][breite].getIstFrei() == false && getFelder()[hoehe][breite+1].getIstFrei() == false && getFelder()[hoehe][breite +2 ].getIstFrei() == false && getFelder()[hoehe][breite + 3].getIstFrei() == false){
                    if(getFelder()[hoehe][breite].getZustand() && getFelder()[hoehe][breite+1].getZustand() && getFelder()[hoehe][breite+2].getZustand() && getFelder()[hoehe][breite+3].getZustand()){
                        System.out.println("Spieler O hat gewonnen horizontal");
                    }
                    else if(getFelder()[hoehe][breite].getZustand() == false && getFelder()[hoehe][breite+1].getZustand() == false && getFelder()[hoehe][breite+2].getZustand() == false && getFelder()[hoehe][breite+3].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen horizontal");
                    }
                }
            }
        }

        // Test Vertikal
        felder[2][2].setIstFrei(false);
        felder[2][2].setZustand(false);
        felder[3][2].setIstFrei(false);
        felder[3][2].setZustand(false);
        felder[4][2].setIstFrei(false);
        felder[4][2].setZustand(false);
        felder[5][2].setIstFrei(false);
        felder[5][2].setZustand(false);

        for(int hoehe = 0; hoehe < 3; hoehe++){
            for(int breite = 0; breite < 7; breite++){
                if(getFelder()[hoehe][breite].getIstFrei() == false && getFelder()[hoehe+1][breite].getIstFrei() == false && getFelder()[hoehe+2][breite].getIstFrei() == false && getFelder()[hoehe+3][breite].getIstFrei() == false){
                    if(getFelder()[hoehe][breite].getZustand() && getFelder()[hoehe+1][breite].getZustand() && getFelder()[hoehe+2][breite].getZustand() && getFelder()[hoehe+3][breite].getZustand()){
                        System.out.println("Spieler O hat gewonnen vertikal");
                    }
                    else if(getFelder()[hoehe][breite].getZustand() == false && getFelder()[hoehe+1][breite].getZustand() == false && getFelder()[hoehe+2][breite].getZustand() == false && getFelder()[hoehe+3][breite].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen vertikal");
                    }
                }
            }
        }

        // Test Schräg Unten
        felder[2][2].setIstFrei(false);
        felder[2][2].setZustand(false);
        felder[3][3].setIstFrei(false);
        felder[3][3].setZustand(false);
        felder[4][4].setIstFrei(false);
        felder[4][4].setZustand(false);
        felder[5][5].setIstFrei(false);
        felder[5][5].setZustand(false);

        for(int hoehe = 0; hoehe < 3; hoehe++){
            for(int breite = 0; breite < 4; breite++){
                if(getFelder()[hoehe][breite].getIstFrei() == false && getFelder()[hoehe+1][breite+1].getIstFrei() == false && getFelder()[hoehe+2][breite+2].getIstFrei() == false && getFelder()[hoehe+3][breite+3].getIstFrei() == false){
                    if(getFelder()[hoehe][breite].getZustand() && getFelder()[hoehe+1][breite+1].getZustand() && getFelder()[hoehe+2][breite+2].getZustand() && getFelder()[hoehe+3][breite+3].getZustand()){
                        System.out.println("Spieler O hat gewonnen schräg oben");
                    }
                    else if(getFelder()[hoehe][breite].getZustand() == false && getFelder()[hoehe+1][breite+1].getZustand() == false && getFelder()[hoehe+2][breite+2].getZustand() == false && getFelder()[hoehe+3][breite+3].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen schräg oben");
                    }
                }
            }
        }

        // Test Schräg Oben
        felder[1][4].setIstFrei(false);
        felder[1][4].setZustand(false);
        felder[2][3].setIstFrei(false);
        felder[2][3].setZustand(false);
        felder[3][2].setIstFrei(false);
        felder[3][2].setZustand(false);
        felder[4][1].setIstFrei(false);
        felder[4][1].setZustand(false);

        for(int hoehe = 3; hoehe < 6; hoehe++){
            for(int breite = 0; breite < 4; breite++){
                if(getFelder()[hoehe][breite].getIstFrei() == false && getFelder()[hoehe-1][breite+1].getIstFrei() == false && getFelder()[hoehe-2][breite+2].getIstFrei() == false && getFelder()[hoehe-3][breite+3].getIstFrei() == false){
                    if(getFelder()[hoehe][breite].getZustand() && getFelder()[hoehe-1][breite+1].getZustand() && getFelder()[hoehe-2][breite+2].getZustand() && getFelder()[hoehe-3][breite+3].getZustand()){
                        System.out.println("Spieler O hat gewonnen schräg unten");
                    }
                    else if(getFelder()[hoehe][breite].getZustand() == false && getFelder()[hoehe-1][breite+1].getZustand() == false && getFelder()[hoehe-2][breite+2].getZustand() == false && getFelder()[hoehe-3][breite+3].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen schräg unten");
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


}