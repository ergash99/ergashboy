package uz.tiu.daily.services.menuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.common.Constants;
import uz.tiu.daily.persistence.Smeta;
import uz.tiu.daily.persistence.Topshiriq;
import uz.tiu.daily.persistence.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Service
public class SmetaService {
    @PersistenceContext
    EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Smeta getSmetaById(Long id) {
        try {
            TypedQuery<Smeta> query = entityManager.createQuery("select u from Smeta u where u.id = " + id, Smeta.class);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Smeta> getSmetaList(Integer pageNumber) {
        int perPage = Constants.LIST_PER_PAGE;
        int skipRows = pageNumber * perPage;
        try {
            Query query;
            query = entityManager.createNamedQuery("Smeta.findALL", Smeta.class);
            query.setFirstResult(skipRows);
            query.setMaxResults(Constants.LIST_PER_PAGE);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Long countSmeta(){
        try {
            TypedQuery<Long> query = (TypedQuery<Long>) entityManager.createNamedQuery("Smeta.countAll", Long.class);
            Long result =  query.getSingleResult();
            if (result == null) return 0L;
            return result;

        }catch (NoResultException e){
            return 0L;
        }
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Integer getCount() {
        try {
            javax.persistence.Query query = entityManager.createQuery("SELECT count(id) from Smeta where status='A'");
            Long count = (Long) query.getSingleResult();
            return count.intValue();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Transactional
    public Smeta save(Smeta smeta) {
        if (smeta.getId() != null) {
            entityManager.merge(smeta);
        } else {
            entityManager.persist(smeta);
        }
        return smeta;
    }

}
