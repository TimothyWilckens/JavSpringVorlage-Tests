/*
 * Der IndexController dient dazu, deine Hauptseiten zu steuern. Hier erstellst du entsprechende Links für die einzelnen Unterseiten. Später werden aber noch andere Controller dazukommen, um Daten zu verwalten. 
 * 
 */
package gymhum.de;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index(@RequestParam(name="activePage", required = false, defaultValue = "home") String activePage, Model model){
        model.addAttribute("activePage", activePage);
        return "index.html";
    }
}