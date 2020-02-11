package jp.daich.letter.spring.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.dao.base.BaseDao;

@Component
public class TPageDao extends BaseDao {

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