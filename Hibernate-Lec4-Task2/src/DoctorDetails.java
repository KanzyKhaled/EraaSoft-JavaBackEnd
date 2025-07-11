import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class DoctorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullAddress;
    private String firstName;
    private String lastName;
    private int age;

    @OneToOne(mappedBy = "doctorDetails")
    private Doctor doctor;
}

