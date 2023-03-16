package Service;

import DAO.UserDaoImpl;
import org.example.User;

public class UserService {
    UserDaoImpl userDao=new UserDaoImpl();

    public boolean checkUserExist(User user) {

        boolean b = userDao.getUserByName(user.getLogin()) != null;
        return b;
    }

}
