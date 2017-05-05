package uz.tiu.daily.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uz.tiu.daily.common.Constants;
import uz.tiu.daily.persistence.Managers;
import uz.tiu.daily.persistence.Role;
import uz.tiu.daily.persistence.User;
import uz.tiu.daily.persistence.UserRole;


import javax.persistence.*;
import java.util.List;

/**
 * @author Gayratjon Rayimjonov
 */
@Service
public class UsersService {

    @PersistenceContext
    EntityManager entityManager;


    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<User> getAllList(Integer pageNumber) {
        int perPage = Constants.LIST_PER_PAGE;
        int skipRows = pageNumber * perPage;
        try {
            Query query;
            query = entityManager.createNamedQuery("User.findALL", User.class);
            query.setFirstResult(skipRows);
            query.setMaxResults(Constants.LIST_PER_PAGE);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Managers> getAllManagersList() {
        try {
            Query query;
            query = entityManager.createQuery("SELECT m from Managers m where m.status = 'A'", Managers.class);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        try {
            TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = " + id, User.class);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public User getUserByLogin(String login) {
        try {
            TypedQuery<User> query = entityManager.createQuery("select u from User u where u.login= :login" , User.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Managers getManagersById(Long id) {
        try {
            TypedQuery<Managers> query = entityManager.createQuery("select u from Managers u where u.id= :id" , Managers.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        try {
            TypedQuery<Role> query = entityManager.createQuery("select r from Role r where r.id = " + id, Role.class);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    public User saveUser(User user) {
        if (user.getId() != null) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
        return user;
    }
    @Transactional
    public UserRole saveUseRole(UserRole userRole) {
        entityManager.persist(userRole);


        return userRole;
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Long countUsers(){
        try {
            TypedQuery<Long> query = (TypedQuery<Long>) entityManager.createNamedQuery("Users.countAll", Long.class);
            Long result =  query.getSingleResult();
            if (result == null) return 0L;
            return result;

        }catch (NoResultException e){
            return 0L;
        }
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Long countDaily(){
        try {
            TypedQuery<Long> query = (TypedQuery<Long>) entityManager.createNamedQuery("Users.countAll", Long.class);
            Long result =  query.getSingleResult();
            if (result == null) return 0L;
            return result;

        }catch (NoResultException e){
            return 0L;
        }
    }
}
