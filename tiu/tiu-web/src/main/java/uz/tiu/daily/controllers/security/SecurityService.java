package uz.tiu.daily.controllers.security;

import uz.tiu.daily.persistence.User;
import uz.tiu.daily.persistence.UserRole;
import uz.tiu.daily.common.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;



@Service
@Transactional
public class SecurityService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public User getUserByLogin(String login)
    {
        if (login==null)
            return null;

        try {
            TypedQuery<User> query;
            query = em.createNamedQuery("User.findByLogin", User.class);
            query.setParameter("login", login);
            query.setParameter("status", Constants.STATUS_ACTIVE);
            return query.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    public List<UserRole> getUserRoles(Long userId)
    {
        if (userId==null)
            return null;

        Query query;
        query = em.createNamedQuery("UserRole.findByUserId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Transactional
    public User saveUser(User user)
    {
        if (user.getId()!=null) {
            em.merge(user);
        } else {
            em.persist(user);
        }
        return user;
    }

    @Transactional
    public List<UserRole> saveUserRoles(List<UserRole> userRoles)
    {
        if (userRoles==null)
            return null;

        for (UserRole userRole: userRoles)
        {
            if (userRole.getId()!=null) {
                em.merge(userRole);
            } else {
                em.persist(userRole);
            }
        }
        return userRoles;
    }

}
