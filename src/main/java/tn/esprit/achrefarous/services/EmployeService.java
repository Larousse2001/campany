package tn.esprit.achrefarous.services;

import tn.esprit.achrefarous.entities.Campany;
import tn.esprit.achrefarous.entities.Employe;
import tn.esprit.achrefarous.repositories.CampanyRepository;
import tn.esprit.achrefarous.repositories.EmployeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeService implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final CampanyRepository campanyRepository;

    public EmployeService(EmployeRepository employeRepository, CampanyRepository campanyRepository) {
        this.employeRepository = employeRepository;
        this.campanyRepository = campanyRepository;
    }

    @Override
    public Employe addEmployeAndAssignToCampany(Employe employe, String campanyName) {
        Campany campany = campanyRepository.findByCampanyName(campanyName);
        if (campany != null) {
            employe.setCampany(campany);
            return employeRepository.save(employe);
        }
        throw new IllegalArgumentException("Campany not found");
    }
}