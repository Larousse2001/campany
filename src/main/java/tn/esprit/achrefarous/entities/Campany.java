package tn.esprit.achrefarous.entities;

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
public class Campany {
    @Id
    private long campanyId;
    private String campanyName;
    private String address;

    @OneToMany(mappedBy = "campany")
    private Set<Employe> employeSet;
}
