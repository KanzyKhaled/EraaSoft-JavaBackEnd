import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int numberOfDoctors;
    private int numberOfPatient;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors;

    @ManyToMany
    @JoinTable(
            name = "hospital_patient",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients;
}
