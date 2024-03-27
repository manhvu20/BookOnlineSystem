package com.bookonline.sessions;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import com.bookonline.entities.User;

@Stateless
@LocalBean
public class UserManagement {

    @PersistenceContext
    private EntityManager entityManager;

    public void registerUser(User user) {
        entityManager.persist(user);
    }

    public boolean login(String name, String password) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name AND u.password = :password");
        query.setParameter("username", name);
        query.setParameter("password", password);
        return !query.getResultList().isEmpty();
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void changePassword(String name, String newPassword) {
        User user = findUserByUsername(name);
        if (user != null) {
            user.setPassword(newPassword);
            entityManager.merge(user);
        }
    }

    public User findUserByUsername(String name) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name");
        query.setParameter("username", name);
        List<User> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public void deleteUser(String name) {
        User user = findUserByUsername(name);
        if (user != null) {
            entityManager.remove(user);
        }
    }
    
    public List<User> getAllUsers() {
    Query query = entityManager.createQuery("SELECT u FROM User u");
    return query.getResultList();
    }   

}
