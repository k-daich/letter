package jp.daich.letter.spring.model.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.db.dao.base.BaseDao;
import jp.daich.letter.spring.model.db.entity.TSentence;

@Component
public class TSentenceDao extends BaseDao {

    /**
     * Using BaseDao Constructor
     */
    public TSentenceDao(final EntityManager em) {
        super(em);
    }

    /**
     * return tableName
     * 
     * @return tableName
     */
    @Override
    protected String getTableName() {
        return "t_sentence";
    }

    /**
     * sentence_idを条件に検索する。 検索結果が1件以外であれば例外を投げる。
     * 
     * @param id
     * @return
     */
    public TSentence getById(final String sentence_id) {
        Query query = em.createQuery("from t_sentence where sentence_id = :sentence_id");
        query.setParameter("sentence_id", sentence_id);
        TSentence result = (TSentence)query.getSingleResult();
        em.close();
        return result;
    }

    /**
     * execute Insert
     * @param entity
     */
    public void create(TSentence entity) {
        em.persist(entity);
        em.flush();
        em.close();
    }
}