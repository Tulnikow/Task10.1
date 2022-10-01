package task.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import task.model.User;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User userToBeUpdate = session.get(User.class, id);
        userToBeUpdate.setUserName(user.getUserName());
        userToBeUpdate.setUserLastname(user.getUserLastname());
        userToBeUpdate.setUserMail(user.getUserMail());
        userToBeUpdate.setUserAge(user.getUserAge());
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
        }
    }
    @Transactional
    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUser() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }
}
