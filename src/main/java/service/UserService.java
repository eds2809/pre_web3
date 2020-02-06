package service;

import dao.UserDao;
import dao.UserDaoFactory;
import model.User;

import java.util.List;

public class UserService {

    public static UserService instance = new UserService();

    private UserDao userDao;

    private UserService() {
        userDao = UserDaoFactory.instance.getUserDao();
    }


    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean delUser(long id) {
        return userDao.delUser(new User(id));
    }

    public boolean addUser(String name, String pass, Long age) {
        return name != null &&
                pass != null &&
                !name.isEmpty() &&
                !pass.isEmpty() &&
                age > 0 &&
                userDao.addUser(
                        new User(name, pass, age)
                );
    }

    public boolean updateUser(long id, String name, String pass, Long age) {
        User user = new User(id, name, pass, age);
        return user.validate() && userDao.update(user);
    }
}
