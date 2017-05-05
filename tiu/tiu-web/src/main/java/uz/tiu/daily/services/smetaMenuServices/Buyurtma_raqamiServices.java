package uz.tiu.daily.services.smetaMenuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.persistence.Smeta_holati;
import uz.tiu.daily.persistence.Topshiriq;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 26.04.17.
 */
@Service
public class Buyurtma_raqamiServices {
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Topshiriq getBuyurtma_raqamiById(Long id) {
        try {
            TypedQuery<Topshiriq> query = entityManager.createQuery("select v from Topshiriq.buyurtma_raqami v where  v.id=" + id, Topshiriq.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Topshiriq> getBuyurtma_raqamiList() {
        try {

            TypedQuery<Topshiriq> query;

            query = entityManager.createQuery("select d from Topshiriq.buyurtma_raqami d", Topshiriq.class);


            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
