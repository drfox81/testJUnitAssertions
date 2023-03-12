package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest extends lessonTest.LoginExeption {
    static String loginTrue = "frog167";
    static String emailTrue = "frog@mail.ru";
    static String emailNoCorrect = "frogmail.ru";

    static String loginNoEquals = "frog@mail.ru";

    static String mailNoEquals = "frog@mail.ru";
    public static User user;

    @AfterAll
    public static void endTest() {
        System.out.println("тест пройден успешно!");
    }

    @Test
    void shouldLoginTrue() throws lessonTest.LoginExeption {
        user = new User(loginTrue, emailTrue);
        Assertions.assertEquals(user.getLogin(), loginTrue);
    }

    @Test
    void shouldEmailTrue() throws lessonTest.LoginExeption {
        user = new User(loginTrue, emailTrue);
        Assertions.assertEquals(user.getEmail(), emailTrue);
    }

    @Test
    void shouldEmailTrueTwo() throws lessonTest.LoginExeption {
        user = new User(loginTrue, emailTrue);
        Assertions.assertTrue(user.getEmail().contains("@"));
        Assertions.assertTrue(user.getEmail().contains("."));
        Assertions.assertThrows(lessonTest.LoginExeption.class,()->new User(loginTrue,emailNoCorrect));
    }

    @Test
    void shouldEmailAndloginEquals(){
        Assertions.assertThrows(lessonTest.LoginExeption.class,()->new User(loginNoEquals, mailNoEquals));
    }


}