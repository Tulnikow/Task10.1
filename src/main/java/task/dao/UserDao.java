package task.dao;
import task.model.User;

import java.util.List;

public interface UserDao {
     void addUser(User user);
     void updateUser(int id, User user);

     void removeUser(int id);

     User getUserById(int id);

     List<User> listUser();
}
