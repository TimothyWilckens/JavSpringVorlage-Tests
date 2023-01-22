package gymhum.de;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gymhum.de.model.Film;

@Controller
public class FilmController {
    

    ArrayList<Film> filme;

    public FilmController(){
        setFilme(new ArrayList<>());
        getFilme().add(new Film("Avatar", 12, 120));
        getFilme().add(new Film("Pirates of the Carribean", 16, 110));
        getFilme().add(new Film("Matrix", 12, 90));
    }

    public void removeFilm(Film film){
        getFilme().remove(film);
    }

    public Film getFilm(int index){
        return getFilme().get(index);
    }
    
    public void setFilme(ArrayList<Film> filme) {
        this.filme = filme;
    }

    public ArrayList<Film> getFilme() {
        return filme;
    }

    @GetMapping("/filme")
    public String showFilme(@RequestParam(name="activePage", required = false, defaultValue = "filme") String activePage, Model model){
        model.addAttribute("activePage", "filme");
        model.addAttribute("filme", getFilme());
        return "index.html";
    }

    @GetMapping("/addfilmprep")
    public String addFilmPrep(@RequestParam(name="activePage", required = false, defaultValue = "filme_add_prep") String activePage, Model model){
        model.addAttribute("activePage", "filme_add_prep");
        return "index.html";
    }

    @RequestMapping("/addfilm")
    public String addFilm(@RequestParam(name="filmTitel", required = true, defaultValue = "null") String filmTitel, @RequestParam(name="filmFSK", required = true, defaultValue = "null") int filmFSK, @RequestParam(name="filmLaenge", required = true, defaultValue = "null") int filmLaenge, @RequestParam(name="activePage", required = false, defaultValue = "film_add") String activePage, Model model){
        getFilme().add(new Film(filmTitel, filmFSK, filmLaenge));
        return "redirect:/filme";
    }

    @GetMapping("/updatefilmprep")
    public String updateFilmPrep(@RequestParam(name="activePage", required = false, defaultValue = "filme_update") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        model.addAttribute("film", getFilm(id));
        model.addAttribute("id", id);
        model.addAttribute("activePage", "filme_update");
        return "index.html";
    }

    
    @RequestMapping("/updatefilm")
    public String updateFilme(@RequestParam(name="filmTitel", required = true, defaultValue = "null") String filmTitel, @RequestParam(name="filmFSK", required = true, defaultValue = "null") int filmFSK, @RequestParam(name="filmLaenge", required = true, defaultValue = "null") int filmLaenge, @RequestParam(name="id", required = true) int id, @RequestParam(name="activePage", required = false, defaultValue = "filme_add") String activePage, Model model){
        Film film = getFilm(id);
        film.setTitel(filmTitel);
        film.setFSK(filmFSK);
        film.setLaenge(filmLaenge);
        return "redirect:/filme";
    }
    
    @GetMapping("/delfilmeprep")
    public String delFilmPrep(@RequestParam(name="activePage", required = true, defaultValue = "filme_delete") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        model.addAttribute("activePage", "filme_delete");
        model.addAttribute("film", getFilm(id));
        model.addAttribute("id", id);
        return "index.html";
    }

    
    @GetMapping("/delfilmefinal")
    public String delFilmeFinal(@RequestParam(name="activePage", required = true, defaultValue = "filme") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        removeFilm(getFilm(id));
        return "redirect:/filme";
    }
}

