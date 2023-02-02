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
                System.out.println(getFelder()[i][k].getIstFrei());
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