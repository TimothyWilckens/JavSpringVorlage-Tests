package gymhum.de;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gymhum.de.model.Person;

@Controller
public class PersonController {
    
    ArrayList<Person> personen;

    // Bei Objekterzeugung erstellen wir eine Standardliste mit vier Personen.
    public PersonController(){
        setPersonen(new ArrayList<>());
        getPersonen().add(new Person("Franz", "Müller", 34));
        getPersonen().add(new Person("Bernd", "Schmidt", 55));
        getPersonen().add(new Person("Lisbeth", "Zalander", 21));
        getPersonen().add(new Person("Ulf", "Friedrichs", 22));
        getPersonen().add(new Person("Ulf", "Friedrichs", 22));
    }

    // MAPPINGS

    // Personen werden als Tabelle dargestellt
    @GetMapping("/personen")
    public String showPersonen(@RequestParam(name="activePage", required = false, defaultValue = "personen") String activePage, Model model){
        model.addAttribute("activePage", "personen");
        model.addAttribute("personen", getPersonen());
        return "index.html";
    }

    // Bestätigungs-Mapping für das löschen einer Person. Die Person selbst wird aber noch nicht gelöscht!
    @GetMapping("/delpersonenprep")
    public String delPersonPrep(@RequestParam(name="activePage", required = true, defaultValue = "personen_delete") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        model.addAttribute("activePage", "personen_delete");
        model.addAttribute("person", getPerson(id));
        model.addAttribute("id", id);
        return "index.html";
    }

    // Die Person wird gelöscht und anschließend geht es zur Tabellenansicht zurück.
    @GetMapping("/delpersonenfinal")
    public String delPersonenFinal(@RequestParam(name="activePage", required = true, defaultValue = "personen") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        removePerson(getPerson(id));
        return "redirect:/personen";
    }

    // Die Person wird gelöscht und anschließend geht es zur Tabellenansicht zurück.
    @GetMapping("/addpersonprep")
    public String addPersonPrep(@RequestParam(name="activePage", required = false, defaultValue = "personen_add_prep") String activePage, Model model){
        model.addAttribute("activePage", "personen_add_prep");
        return "index.html";
    }

    // Eine neue Person wird hinzugefügt. Die Daten kommen aus dem Formular aus der personen_add_prep.html-Seite.
    @RequestMapping("/addperson")
    public String addPerson(@RequestParam(name="personVorname", required = true, defaultValue = "null") String personVorname, @RequestParam(name="personNachname", required = true, defaultValue = "null") String personNachname, @RequestParam(name="personAlter", required = true, defaultValue = "null") int personAlter, @RequestParam(name="activePage", required = false, defaultValue = "personen_add") String activePage, Model model){
        getPersonen().add(new Person(personVorname, personNachname, personAlter));
        return "redirect:/personen";
    }

    // Die zu ändernde Person wird geladen und an die View weitergegeben.
    @GetMapping("/updatepersonprep")
    public String updatePersonPrep(@RequestParam(name="activePage", required = false, defaultValue = "personen_update") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        model.addAttribute("person", getPerson(id));
        model.addAttribute("id", id);
        model.addAttribute("activePage", "personen_update");
        return "index.html";
    }

    // Eine neue Person wird hinzugefügt. Die Daten kommen aus dem Formular aus der personen_add_prep.html-Seite.
    @RequestMapping("/updateperson")
    public String updatePerson(@RequestParam(name="personVorname", required = true, defaultValue = "null") String personVorname, @RequestParam(name="personNachname", required = true, defaultValue = "null") String personNachname, @RequestParam(name="personAlter", required = true, defaultValue = "null") int personAlter, @RequestParam(name="id", required = true) int id, @RequestParam(name="activePage", required = false, defaultValue = "personen_add") String activePage, Model model){
        Person person = getPerson(id);
        person.setAlter(personAlter);
        person.setNachname(personNachname);
        person.setVorname(personVorname);
        return "redirect:/personen";
    }


    // Methode zum entfernen einer Person
    public void removePerson(Person person){
        getPersonen().remove(person);
    }

    // Methode zum holen einer bestimmten Person
    public Person getPerson(int index){
        return getPersonen().get(index);
    }

    // SETTER UND GETTER
    public void setPersonen(ArrayList<Person> personen) {
        this.personen = personen;
    }

    public ArrayList<Person> getPersonen() {
        return personen;
    }

    
}
