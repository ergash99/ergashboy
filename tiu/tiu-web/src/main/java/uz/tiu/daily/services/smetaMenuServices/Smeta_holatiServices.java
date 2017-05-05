package uz.tiu.daily.services.smetaMenuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.persistence.Buyurtma_holati;
import uz.tiu.daily.persistence.Smeta_holati;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 26.04.17.
 */
@Service
public class Smeta_holatiServices {
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Smeta_holati getSmeta_holatiById(Long id) {
        try {
            TypedQuery<Smeta_holati> query = entityManager.createQuery("select v from Smeta_holati v where  v.id=" + id, Smeta_holati.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Smeta_holati> getSmeta_holatiList() {
        try {

            TypedQuery<Smeta_holati> query;

            query = entityManager.createQuery("select d from Smeta_holati d", Smeta_holati.class);


            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
