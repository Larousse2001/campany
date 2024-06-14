package tn.esprit.achrefarous.services;

import tn.esprit.achrefarous.entities.Employe;

public interface IEmployeService {
    Employe addEmployeAndAssignToCampany(Employe employe, String campanyName);
}