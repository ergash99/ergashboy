package uz.tiu.daily.services.topshiriqMenuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.persistence.DM_AAT;
import uz.tiu.daily.persistence.Tashabbuschi_tuzilma;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by ERGASHBOY_JAVA on 25.04.17.
 */
@Service
public class Tashabbuschi_tuzilmaServices {
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Tashabbuschi_tuzilma getTashabbuschi_tuzilmaId(Long id) {
        try {
            TypedQuery<Tashabbuschi_tuzilma> query = entityManager.createQuery("select v from Tashabbuschi_tuzilma v where  v.id=" + id, Tashabbuschi_tuzilma.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Tashabbuschi_tuzilma> getTashabbuschi_tuzilmaList() {
        try {

            TypedQuery<Tashabbuschi_tuzilma> query;

            query = entityManager.createQuery("select d from Tashabbuschi_tuzilma d", Tashabbuschi_tuzilma.class);


            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
