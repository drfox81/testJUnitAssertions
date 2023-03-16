package DAO;

import org.example.User;

public interface UserDao {

    void addUser(User user);


    User getUserByName(String name);

}
