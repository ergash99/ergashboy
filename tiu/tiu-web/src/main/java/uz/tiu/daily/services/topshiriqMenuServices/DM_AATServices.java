package uz.tiu.daily.services.topshiriqMenuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.persistence.DM_AAT;
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
public class DM_AATServices {
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public DM_AAT getDM_AATById(Long id) {
        try {
            TypedQuery<DM_AAT> query = entityManager.createQuery("select v from DM_AAT v where  v.id=" + id, DM_AAT.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<DM_AAT> getDM_AATList() {
        try {

            TypedQuery<DM_AAT> query;

            query = entityManager.createQuery("select d from DM_AAT d", DM_AAT.class);


            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
