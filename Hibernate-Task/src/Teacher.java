
import org.hibernate.annotations.Check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Teacher_Test")
@Check(constraints = "age BETWEEN 15 AND 20")
public class Teacher {
    @Id
    private Long id;

    @Column(length = 50)
    private String name;


    private int age;

    @Column(unique = true)
    private String address;
}
