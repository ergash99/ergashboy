package uz.tiu.daily.services.topshiriqMenuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.persistence.Kelishilgan_bulinmalar;
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
public class Kelishilgan_bulinmaServices {
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Kelishilgan_bulinmalar getKelishilgan_bulinmalarId(Long id) {
        try {
            TypedQuery<Kelishilgan_bulinmalar> query = entityManager.createQuery("select v from Kelishilgan_bulinmalar v where  v.id=" + id, Kelishilgan_bulinmalar.class);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Kelishilgan_bulinmalar> getKelishilgan_bulinmalarList() {
        try {

            TypedQuery<Kelishilgan_bulinmalar> query;

            query = entityManager.createQuery("select d from Kelishilgan_bulinmalar d", Kelishilgan_bulinmalar.class);


            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
