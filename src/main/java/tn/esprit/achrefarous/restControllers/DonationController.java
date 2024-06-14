package tn.esprit.achrefarous.restControllers;

import tn.esprit.achrefarous.entities.Donation;
import tn.esprit.achrefarous.entities.DonationType;
import tn.esprit.achrefarous.entities.Employe;
import org.springframework.web.bind.annotation.*;
import tn.esprit.achrefarous.services.IDonationService;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class DonationController {

    private final IDonationService donationService;

    public DonationController(IDonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping("/donations")
    public Donation addDonation(@RequestBody Donation donation) {
        return donationService.addDonation(donation);
    }

    @GetMapping("/donations/type/{type}")
    public Set<Donation> getDonationByType(@PathVariable DonationType type) {
        return donationService.getDonationByType(type);
    }

    @GetMapping("/employes/donations")
    public List<Employe> getEmployeByArea(@RequestParam String companyName) {
        return donationService.getEmployeByArea(companyName);
    }

    @GetMapping("/donations/total")
    public Float getTotalDonation(@RequestParam Date date1, @RequestParam Date date2) {
        return donationService.getTotalDonation(date1, date2);
    }
}