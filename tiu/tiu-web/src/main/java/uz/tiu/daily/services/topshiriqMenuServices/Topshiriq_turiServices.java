package uz.tiu.daily.services.topshiriqMenuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
public class Topshiriq_turiServices {
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Topshiriq_turi getTopshiriq_turiById(Long id) {
        try {
            TypedQuery<Topshiriq_turi> query = entityManager.createQuery("select v from Topshiriq_turi v where  v.id=" + id, Topshiriq_turi.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Topshiriq_turi> getTopshiriq_turiList() {
        try {

            TypedQuery<Topshiriq_turi> query;

            query = entityManager.createQuery("select d from Topshiriq_turi d", Topshiriq_turi.class);


            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
