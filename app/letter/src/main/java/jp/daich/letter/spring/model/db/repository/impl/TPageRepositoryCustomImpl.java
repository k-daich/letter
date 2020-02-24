package jp.daich.letter.spring.model.db.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.db.repository.TPageRepositoryCustom;
import jp.daich.letter.spring.model.db.entity.T_Page;
import jp.daich.letter.spring.model.db.entity.T_Page_;

@Component
public class TPageRepositoryCustomImpl implements TPageRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    public List<T_Page> findBySentence_id(final String sentence_id) {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<T_Page> query = cb.createQuery(T_Page.class);
        final Root<T_Page> root = query.from(T_Page.class);

        query.where( //
                cb.equal(root.get(T_Page_.fk_sentence_id), sentence_id));

        return (List<T_Page>) em.createQuery(query).getResultList();
    }

}