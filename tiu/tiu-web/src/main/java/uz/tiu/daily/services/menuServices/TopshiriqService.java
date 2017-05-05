package uz.tiu.daily.services.menuServices;

import net.sf.jasperreports.engine.xml.JRPenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.common.Constants;
import uz.tiu.daily.controllers.main.MainController;
import uz.tiu.daily.persistence.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 21.04.17.
 */
@Service
public class TopshiriqService {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private MainController mainController;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Topshiriq getTopshiriqById(Long id) {
        try {
            TypedQuery<Topshiriq> query = entityManager.createQuery("select u from Topshiriq u where u.id = " + id, Topshiriq.class);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Topshiriq> getTopshiriqList( int pageId){
        try {
            TypedQuery<Topshiriq> query=entityManager.createQuery("SELECT r from  Topshiriq r WHERE r.status=:status ", Topshiriq.class);
            query.setParameter("status", Constants.STATUS_ACTIVE);
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }

    }



    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Integer getCount() {
        try {
            javax.persistence.Query query = entityManager.createQuery("SELECT count(id) from Topshiriq where status='A'");
            Long count = (Long) query.getSingleResult();
            return count.intValue();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    public Topshiriq save(Topshiriq topshiriq) {
        if (topshiriq.getId() != null) {
            entityManager.merge(topshiriq);
        } else {
            entityManager.persist(topshiriq);
        }
        return topshiriq;
    }
}
