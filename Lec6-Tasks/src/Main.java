import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Load configuration from hibernate.cfg.xml
        Configuration cfg = new Configuration().configure();

        // Build SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Example: Save an entity
        User user = new User();
        user.setId(1);
        user.setName("Kanzy");
        session.save(user);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();
        sessionFactory.close();
    }
}
