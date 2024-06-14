package tn.esprit.achrefarous.restControllers;

import tn.esprit.achrefarous.entities.Employe;
import org.springframework.web.bind.annotation.*;
import tn.esprit.achrefarous.services.IEmployeService;

@RestController
@RequestMapping("/api")
public class EmployeController {

    private final IEmployeService employeService;

    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping("/employes/{campanyName}")
    public Employe addEmployeAndAssignToCampany(@RequestBody Employe employe, @PathVariable String campanyName) {
        return employeService.addEmployeAndAssignToCampany(employe, campanyName);
    }
}
