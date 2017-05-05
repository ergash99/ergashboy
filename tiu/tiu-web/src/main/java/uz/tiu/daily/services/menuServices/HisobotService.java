package uz.tiu.daily.services.menuServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tiu.daily.common.Constants;
import uz.tiu.daily.persistence.Hisobot;
import uz.tiu.daily.persistence.Smeta;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Service
public class HisobotService {

    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Hisobot> getAllList(Integer pageNumber) {
        int perPage = Constants.LIST_PER_PAGE;
        int skipRows = pageNumber * perPage;
        try {
            Query query;
            query = entityManager.createNamedQuery("Hisobot.findALL", Hisobot.class);
            query.setFirstResult(skipRows);
            query.setMaxResults(Constants.LIST_PER_PAGE);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Long countHisobot(){
        try {
            TypedQuery<Long> query = (TypedQuery<Long>) entityManager.createNamedQuery("Hisibot.countAll", Long.class);
            Long result =  query.getSingleResult();
            if (result == null) return 0L;
            return result;

        }catch (NoResultException e){
            return 0L;
        }
    }

}
