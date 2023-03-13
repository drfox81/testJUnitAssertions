package org.example;

import DAO.UserDao;
import DAO.UserDaoImpl;
import Service.UserService;
import lessonTest.LoginExeption;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static DAO.UserDaoImpl.users;

public class User {
    private String login;
    private String email;
    private static Pattern pat;
    private static Matcher mat;

    public User(String login, String email) throws lessonTest.LoginExeption {
        this.login = getLoginIn(login);
        this.email = getEmailIn(email);
        if (login.equals(email)) {
            throw new lessonTest.LoginExeption("Логин не должен совпадать с адресом почты");
        }
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public static String getLoginIn(String string) {
        pat = Pattern.compile("^[a-zA-Z0-9+]{3,50}$", Pattern.CASE_INSENSITIVE);
        mat = pat.matcher(string);
        if (mat.matches()) {
            return string;
        } else return null;
    }

    public String getEmailIn(String strEmail) throws lessonTest.LoginExeption {
        pat = Pattern.compile("^[A-Za-z0-9+_.-]+@[ a-zA-Z0-9.-]+$", Pattern.CASE_INSENSITIVE);
        mat = pat.matcher(strEmail);
        if (mat.matches()) {
            return strEmail;
        } else throw new lessonTest.LoginExeption();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }

    @Override
    public String toString() {
        return "User -> " +
                login + " - " + email+" || ";
    }

    public static void main(String[] args) throws lessonTest.LoginExeption {
        User user = new User("werewr", "err@ert.ru");
        User misha = new User("Misha", "misha@mail.ru");
        User masha = new User("Masha", "masha@mail.ru");
        User dasha = new User("Dasha", "dasha@mail.ru");


        System.out.println(UserDaoImpl.users);
        users.add(user);
        users.add(masha);
        users.add(misha);
        UserService userService=new UserService();
        UserDaoImpl userDao=new UserDaoImpl();
        UserDaoImpl.findAllUsers();

        System.out.println(userDao.getUserByName("sha"));
        System.out.println(userService.checkUserExist(dasha));


    }
}
