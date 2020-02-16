package jp.daich.letter.spring.model.db.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.db.dao.base.BaseDao;

@Component
public class TPageDao extends BaseDao {

    protected TPageDao(EntityManager em) {
        super(em);
    }

    /**
     * return tableName
     * 
     * @return tableName
     */
    @Override
    protected String getTableName() {
        return "t_page";
    }

    /**
     * 
     * @param id
     * @return
     */
    public List<Map<String, Object>> getBySentence_id(final String sentence_id) {
        return findList("select * from " + getTableName() + " where fk_sentence_id = " + sentence_id
                + " order by page_of_sentence");
    }

}