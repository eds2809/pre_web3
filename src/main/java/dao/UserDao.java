package dao;

import java.util.List;

public interface UserDao<T> {
    List<T> getAllUsers();
    boolean addUser(T user);
    boolean delUser(T user);
    boolean update(T user);
}
