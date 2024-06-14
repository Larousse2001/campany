package tn.esprit.achrefarous.services;

import tn.esprit.achrefarous.entities.Campany;
import tn.esprit.achrefarous.repositories.CampanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CampanyService implements ICampanyService {

    private final CampanyRepository campanyRepository;

    public CampanyService(CampanyRepository campanyRepository) {
        this.campanyRepository = campanyRepository;
    }

    @Override
    public Campany addCampany(Campany campany) {
        if (campany.getCampanyName() == null) {
            throw new IllegalArgumentException("Campany name cannot be null");
        }
        return campanyRepository.save(campany);
    }
}
