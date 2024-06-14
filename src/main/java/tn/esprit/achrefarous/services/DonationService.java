package tn.esprit.achrefarous.services;

import tn.esprit.achrefarous.entities.Donation;
import tn.esprit.achrefarous.entities.DonationType;
import tn.esprit.achrefarous.entities.Employe;
import tn.esprit.achrefarous.repositories.DonationRepository;
import tn.esprit.achrefarous.repositories.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;

@Service
public class DonationService implements IDonationService {

    private final DonationRepository donationRepository;
    private final EmployeRepository employeRepository;

    public DonationService(DonationRepository donationRepository, EmployeRepository employeRepository) {
        this.donationRepository = donationRepository;
        this.employeRepository = employeRepository;
    }

    @Override
    public Donation addDonation(Donation donation) {
        if (donation.getType() == DonationType.MONETARY && donation.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0 for monetary donations");
        }
        if (donation.getType() != DonationType.MONETARY) {
            donation.setAmount(0);
        }
        return donationRepository.save(donation);
    }

    @Override
    public Set<Donation> getDonationByType(DonationType type) {
        return donationRepository.findByTypeOrderByDate(type);
    }

    @Override
    @Scheduled(cron = "0 0 0 1 * ?") // Every start of the month
    public void getEmployeByDonation() {
        // Calculate the first and last day of the previous month
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDate = calendar.getTime();

        // Get donations made in the previous month
        List<Donation> donations = donationRepository.findDonationsByDateBetween(startDate, endDate);

        // Group donations by employee and count them
        Map<Employe, Long> donationCountByEmployee = donations.stream()
                .collect(Collectors.groupingBy(Donation::getEmploye, Collectors.counting()));

        // Find the employee with the maximum number of donations
        Employe bestEmploye = Collections.max(donationCountByEmployee.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Log the best employee (or perform any other action)
        System.out.println("Best employee for the last month: " + bestEmploye.getFirstName() + " " + bestEmploye.getLastName());
    }

    @Override
    public List<Employe> getEmployeByArea(String companyName) {
        return employeRepository.findEmployesByCampanyNameAndDonationArea(companyName);
    }

    @Override
    public Float getTotalDonation(Date date1, Date date2) {
        return donationRepository.calculateTotalAmountBetweenDates(date1, date2);
    }
}