package tn.esprit.achrefarous.repositories;
import tn.esprit.achrefarous.entities.Employe;
import tn.esprit.achrefarous.entities.RedCrescent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    @Query("SELECT e FROM Employe e JOIN e.donationSet d WHERE e.campany.campanyName = :campanyName")
    List<Employe> findEmployesByCampanyNameAndDonationArea(String campanyName);
}
