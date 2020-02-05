package service;

import dao.UserHibernateDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class UserService {

    public static UserService instance = new UserService();



   /* private Connection connection;

    private UserService() {
        this.connection = DBHelper.getMysqlConnection();
    }

    public List<User> getAllUsers() {
        return new UserJDBCDao(connection).getAllUsers();
    }

    public boolean addUser(String name) {
        return name != null && !name.isEmpty() && new UserJDBCDao(connection).addUser(new User(name));
    }

    public boolean delUser(long id) {
        return id != 0 && new UserJDBCDao(connection).delUser(new User(id));
    }

    public boolean updateUser(long id, String name) {
        User user = new User(id, name);
        return user.validate() && new UserJDBCDao(connection).update(user);
    }*/


    private SessionFactory sessionFactory;

    private UserService() {
        this.sessionFactory = DBHelper.getSessionFactory();
    }


    public List<User> getAllUsers() {
        return  new UserHibernateDAO(getSession()).getAllUsers();
    }

    public boolean delUser(long id) {
        return new UserHibernateDAO(getSession()).delUser(new User(id));
    }

    public boolean addUser(String name) {
        return name != null && !name.isEmpty() && new UserHibernateDAO(getSession()).addUser(new User(name));
    }

    public boolean updateUser(long id, String name) {
        User user = new User(id, name);
        return user.validate() && new UserHibernateDAO(getSession()).update(user);
    }

    private Session getSession(){
        return sessionFactory.openSession();
    }
}
