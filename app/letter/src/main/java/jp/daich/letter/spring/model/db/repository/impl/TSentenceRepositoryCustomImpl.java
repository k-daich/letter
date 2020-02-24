package jp.daich.letter.spring.model.db.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.db.repository.TSentenceRepositoryCustom;
import jp.daich.letter.spring.model.db.entity.T_Sentence;
import jp.daich.letter.spring.model.db.entity.T_Sentence_;

@Component
public class TSentenceRepositoryCustomImpl implements TSentenceRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    public T_Sentence findBySentence_id(final String sentence_id) {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<T_Sentence> query = cb.createQuery(T_Sentence.class);
        final Root<T_Sentence> root = query.from(T_Sentence.class);

        query.where( //
                cb.equal(root.get(T_Sentence_.sentence_id), sentence_id));

        return (T_Sentence) em.createQuery(query).getSingleResult();
    }

}