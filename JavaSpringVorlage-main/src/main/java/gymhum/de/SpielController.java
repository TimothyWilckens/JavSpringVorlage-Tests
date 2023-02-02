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
        model.addAttribute("spiel", getFelder());
        return "index.html";
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
        felder[2][2].setIstFrei(false);
        felder[2][2].setZustand(false);
        felder[3][2].setIstFrei(false);
        felder[3][2].setZustand(false);
        felder[4][2].setIstFrei(false);
        felder[4][2].setZustand(false);
        felder[5][2].setIstFrei(false);
        felder[5][2].setZustand(false);
        
        for(int i = 0; i < 6; i++){
            for(int k = 0; k < 4; k++){
                if(getFelder()[i][k].getIstFrei() == false && getFelder()[i][k+1].getIstFrei() == false && getFelder()[i][k +2 ].getIstFrei() == false && getFelder()[i][k + 3].getIstFrei() == false){
                    if(getFelder()[i][k].getZustand() && getFelder()[i][k+1].getZustand() && getFelder()[i][k +2 ].getZustand() && getFelder()[i][k + 3].getZustand()){
                        System.out.println("Spieler O hat gewonnen");
                    }
                    else if(getFelder()[i][k].getZustand() == false && getFelder()[i][k+1].getZustand() == false && getFelder()[i][k +2 ].getZustand() == false && getFelder()[i][k + 3].getZustand() == false){
                        System.out.println("Spieler X hat gewonnen");
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