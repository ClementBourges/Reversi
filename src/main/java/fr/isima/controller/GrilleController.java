package fr.isima.controller;

import fr.isima.business.Grille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/grille")
public class GrilleController {

    private Grille grille;

    public GrilleController()
    {
        grille= new Grille();
    }

    @GetMapping("{id1}/{id2}")
    public String displayQuote(@PathVariable(value = "id1") Integer id1,@PathVariable(value = "id2") Integer id2) {
        System.out.println(id1);
        System.out.println(id2);
        //Mécanique de jeu !!!
        if(grille.tour%2==0)
        {
            grille.matrice[id1][id2]=1;
            grille.tour++;

        }
        else {
            grille.matrice[id1][id2]=2;
            grille.tour++;

        }
        return "<meta http-equiv='refresh' content='0; url=/main'>";
    }

    ModelAndView getGrille(String viewName) {
        return new ModelAndView(viewName, "Grille", grille);
    }
}
