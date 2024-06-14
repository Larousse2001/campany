package tn.esprit.achrefarous.services;

import tn.esprit.achrefarous.entities.Donation;
import tn.esprit.achrefarous.entities.DonationType;
import tn.esprit.achrefarous.entities.Employe;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IDonationService {
    Donation addDonation(Donation donation);
    Set<Donation> getDonationByType(DonationType type);
    void getEmployeByDonation();
    List<Employe> getEmployeByArea(String companyName);
    Float getTotalDonation(Date date1, Date date2);
}