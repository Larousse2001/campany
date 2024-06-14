package tn.esprit.achrefarous.restControllers;

import tn.esprit.achrefarous.entities.Campany;
import org.springframework.web.bind.annotation.*;
import tn.esprit.achrefarous.services.ICampanyService;

@RestController
@RequestMapping("/api")
public class CampanyController {

    private final ICampanyService campanyService;

    public CampanyController(ICampanyService campanyService) {
        this.campanyService = campanyService;
    }

    @PostMapping("/campanies")
    public Campany addCampany(@RequestBody Campany campany) {
        return campanyService.addCampany(campany);
    }
}