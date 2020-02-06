package dao;

import model.User;

import java.util.List;

public interface UserDao<T extends User> {
    List<T> getAllUsers();

    boolean addUser(T user);

    boolean delUser(T user);

    boolean update(T user);
}
