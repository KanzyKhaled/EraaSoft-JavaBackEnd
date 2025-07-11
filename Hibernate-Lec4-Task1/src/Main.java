import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class);
        // Open session and begin transaction
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //Save

        /*
        Player p = new Player();
        p.setName("Alice");
        p.setAge(22);
        p.setStatus(true);
        session.save(p);
        transaction.commit();
        */

        //Update

        /*
        Player p = session.get(Player.class, 1);
        p.setAge(25);
        session.update(p);
        transaction.commit();
        */

        //Delete

        /*
        Player p = session.get(Player.class, 1);
        session.delete(p);
        tx.commit();
         */

        Player p = session.get(Player.class, 1);
        System.out.println(p.getName());

        // Name starts with 'A'
        List<Player> nameStartsWithA = session.createQuery(
                "FROM Player WHERE name LIKE 'A%'", Player.class).list();

        // Age >= 20
        List<Player> ageAtLeast20 = session.createQuery(
                "FROM Player WHERE age >= 20", Player.class).list();

        // Status is true
        List<Player> activePlayers = session.createQuery(
                "FROM Player WHERE status = true", Player.class).list();

        // ID is even
        List<Player> evenIdPlayers = session.createQuery(
                "FROM Player WHERE MOD(id, 2) = 0", Player.class).list();

    }
}