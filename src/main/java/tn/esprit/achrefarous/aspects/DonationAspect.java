package tn.esprit.achrefarous.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DonationAspect {

    @After("execution(* tn.esprit.achrefarous.services.DonationService.addDonation(..))")
    public void afterAddDonation() {
        System.out.println("Merci pour ce don");
    }
}
