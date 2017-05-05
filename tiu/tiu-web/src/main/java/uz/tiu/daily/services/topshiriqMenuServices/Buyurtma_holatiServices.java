package uz.tiu.daily.services.topshiriqMenuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.persistence.Buyurtma_holati;
import uz.tiu.daily.persistence.Topshiriq_holati;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 25.04.17.
 */
@Service
public class Buyurtma_holatiServices {
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Buyurtma_holati getBuyurtma_holatiById(Long id) {
        try {
            TypedQuery<Buyurtma_holati> query = entityManager.createQuery("select v from Buyurtma_holati v where  v.id=" + id, Buyurtma_holati.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Buyurtma_holati> getBuyurtma_holatiList() {
        try {

            TypedQuery<Buyurtma_holati> query;

            query = entityManager.createQuery("select d from Buyurtma_holati d", Buyurtma_holati.class);


            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
