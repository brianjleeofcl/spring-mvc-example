package net.brianjlee.springExample;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAccessObject {

    private String url = System.getenv("JDBC_DATABASE_URL");
    {
        if (url == null) {
            url = "jdbc:postgresql://127.0.0.1:5432/testdb";
        }
    }

    private Map<String, String> props = new HashMap<String, String>();
    {
        props.put("javax.persistence.jdbc.url", url);
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("user-persistence", props);

    public User[] getUsers() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("from User");

        List<User> result = query.getResultList();
        User[] users = new User[result.size()];
        return result.toArray(users);
    }

    public User getUser(int id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("from User where id = :id", User.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    public User insertUser(String firstName, String lastName, String phone) throws InstantiationException {
        EntityManager em = emf.createEntityManager();
        User user = new User();
        em.getTransaction().begin();
        em.persist(user);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        try {
            user.setPhone(phone);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        em.getTransaction().commit();
        return user;
    }
}
