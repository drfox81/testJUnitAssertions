package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String login;
    private  String email;
    private static Pattern pat;
    private static Matcher mat;

    public User(String login, String email) throws lessonTest.LoginExeption {
        this.login = getLoginIn(login);
        this.email = getEmailIn(email);
        if (login.equals(email)){
            throw new lessonTest.LoginExeption("Логин не должен совпадать с адресом почты");
        }
    }

    public  String getLogin() {
        return login;
    }

    public  String getEmail() {
        return email;
    }

    public static String getLoginIn(String string) {
        pat=Pattern.compile("^[a-zA-Z0-9+]{3,50}$",Pattern.CASE_INSENSITIVE);
        mat=pat.matcher(string);
        if (mat.matches()){
            return string;
        } else return null;
    }

    public String getEmailIn(String strEmail) {
        pat=Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$",Pattern.CASE_INSENSITIVE);
        mat=pat.matcher(strEmail);
        if (mat.matches()){
            return strEmail;
        } else return null;
    }

    public static void main(String[] args) throws lessonTest.LoginExeption {
        User user=new User("werewr","err@ert.ru");

        System.out.println(user.getLogin()+" "+user.getEmail());

    }
}
