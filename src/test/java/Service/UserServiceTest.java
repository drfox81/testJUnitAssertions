package Service;

import DAO.UserDaoImpl;
import lessonTest.LoginExeption;
import org.example.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDaoImpl userDao;

    @InjectMocks
    private UserService out;

    private static final String MISHA_TRUE = "Misha";
    private static final User MISHA_USER_TRUE;
    private static final User MISHA_USER_FALSE;

    static {
        try {
            MISHA_USER_TRUE = new User("Misha","wewe@er.ru");
            MISHA_USER_FALSE = new User("Msha","wee@er.ru");

        } catch (LoginExeption e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldCheckUserExistTrue() throws LoginExeption {

        when(userDao.getUserByName(MISHA_TRUE)).thenReturn(MISHA_USER_TRUE);
        assertEquals(true,out.checkUserExist(MISHA_USER_TRUE));
        assertEquals(false,out.checkUserExist(MISHA_USER_FALSE));
        verify(userDao,atLeast(1)).getUserByName("Misha");

    }


}