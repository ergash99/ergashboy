package uz.tiu.daily.services.topshiriqMenuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.persistence.Topshiriq_holati;
import uz.tiu.daily.persistence.Topshiriq_turi;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 25.04.17.
 */
@Service
public class Topshiriq_holatiServices {
    @PersistenceContext
    EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Topshiriq_holati getTopshiriq_holatiById(Long id) {
        try {
            TypedQuery<Topshiriq_holati> query = entityManager.createQuery("select v from Topshiriq_holati v where  v.id=" + id, Topshiriq_holati.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Topshiriq_holati> getTopshiriq_holatiList() {
        try {

            TypedQuery<Topshiriq_holati> query;

            query = entityManager.createQuery("select d from Topshiriq_holati d", Topshiriq_holati.class);


            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
