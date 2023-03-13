package Service;

import DAO.UserDao;
import DAO.UserDaoImpl;
import org.example.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {
    UserDaoImpl userDao=new UserDaoImpl();

    public boolean checkUserExist(User user) {

        boolean b = userDao.getUserByName(user.getLogin()) == null ? false : true;
        return b;
    }

}
