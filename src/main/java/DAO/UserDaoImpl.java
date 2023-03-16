package DAO;

import org.example.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {

    public static List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        } else {
            System.out.println("такой есть!");
        }
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getLogin().equals(name)) {
                return user;
            }
        }
        return null;

    }

    public static void findAllUsers() {
        List<String> list = users.stream().map(User::getLogin).toList();
        System.out.println(list);
    }


}
