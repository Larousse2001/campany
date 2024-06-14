package tn.esprit.achrefarous.repositories;

import tn.esprit.achrefarous.entities.Campany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampanyRepository extends JpaRepository<Campany, Long> {
    Campany findByCampanyName(String campanyName);
}
