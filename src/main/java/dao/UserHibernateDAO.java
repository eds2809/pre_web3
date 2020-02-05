package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserHibernateDAO implements UserDao<User> {

    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    @Override
    public List<User> getAllUsers() {
        Query query = session.createQuery("from User");
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public boolean addUser(User user) {
        Transaction transaction = session.beginTransaction();
        long id = (long) session.save(user);
        transaction.commit();
        session.close();
        return id > 0;
    }

    @Override
    public boolean delUser(User user) {
        Transaction transaction = session.beginTransaction();
        user = session.get(User.class,user.getId());
        session.delete(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User user) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(
                "update User set name=:name,pass=:pass,age=:age where id=:id"
        );
        query.setParameter("name", user.getName());
        query.setParameter("id", user.getId());
        query.setParameter("age", user.getAge());
        query.setParameter("pass", user.getPass());
        int result = query.executeUpdate();
        transaction.commit();
        session.close();
        return result > 0;
    }
}
