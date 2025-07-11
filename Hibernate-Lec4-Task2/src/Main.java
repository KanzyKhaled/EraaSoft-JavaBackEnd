import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Hospital.class)
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(DoctorDetails.class)
                .addAnnotatedClass(Patient.class);
        // Open session and begin transaction
        SessionFactory factory =  configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.close();
        factory.close();
        }
    }
