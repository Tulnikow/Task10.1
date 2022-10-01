package task.services;

import org.springframework.stereotype.Service;
import task.dao.UserDao;
import task.model.User;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public void addUser(User user) {
        userDaoImpl.addUser(user);
    }

    @Override
    public void updateUser(int id,User user) {
        userDaoImpl.updateUser(id,user);
    }

    @Override
    public void removeUser(int id) {
        userDaoImpl.removeUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userDaoImpl.getUserById(id);
    }

    @Override
    public List<User> listUser() {
        return userDaoImpl.listUser();
    }
}
