package tn.esprit.achrefarous.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class RedCrescent {
    @Id
    private long redId;
    private String area;

    @OneToMany
    @JsonIgnore
    private Set<Donation> donationSet;
}
