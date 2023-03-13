package DAO;

import lessonTest.LoginExeption;
import org.example.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class UserDaoImplTest {

    private static final String MISHA_TRUE = "Misha";
    private static final String MASHA_FALSE = "Masha";
    private static final String MASHA_NULL= null;

    private static final User MISHA_USER_TRUE;



    static {
        try {
            MISHA_USER_TRUE = new User("Misha","wewe@er.ru");
        } catch (LoginExeption e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    public static void initField() {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.addUser(MISHA_USER_TRUE);
    }

    @Test
    public void shouldGetUserByName() {
        UserDaoImpl userDao = new UserDaoImpl();
        assertEquals(MISHA_USER_TRUE, userDao.getUserByName(MISHA_TRUE));
    }
    @Test
    public void shouldGetUserByNameNull() {
        UserDaoImpl userDao = new UserDaoImpl();
        assertNull( userDao.getUserByName(MASHA_NULL));
    }
    @Test
    public void shouldGetUserByNameNoNull() {
        UserDaoImpl userDao = new UserDaoImpl();
        assertNotNull(userDao.getUserByName(MISHA_TRUE));
    }



}