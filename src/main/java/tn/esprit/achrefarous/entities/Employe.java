package tn.esprit.achrefarous.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employe {
    @Id
    private long employeId;
    private String lastName;
    private String firstName;
    private String position;

    @ManyToOne
    @JsonIgnore
    private Campany campany;

    @OneToMany(mappedBy = "employe")
    private Set<Donation> donationSet;
}
