package jp.daich.letter.spring.model.db.dao.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.db.dao.repository.TPageRepository;
import jp.daich.letter.spring.model.db.entity.TPage;
import jp.daich.letter.spring.model.db.entity.TPage_;

@Component
public class TPageRepositoryImpl implements TPageRepository {

    @PersistenceContext
    EntityManager em;

    public List<TPage> findBySentence_id(final String sentence_id) {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<TPage> query = cb.createQuery(TPage.class);
        final Root<TPage> root = query.from(TPage.class);

        query.where( //
                cb.equal(root.get(TPage_.fk_sentence_id), sentence_id));

        return (List<TPage>) em.createQuery(query).getResultList();
    }

}