package tn.esprit.achrefarous.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Donation {
    @Id
    private long donId;
    private float amount;
    private Date date;
    private DonationType type;

    @ManyToOne
    @JsonIgnore
    private Employe employe;

}
