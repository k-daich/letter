package jp.daich.letter.spring.model.dao;

import java.util.Map;

import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.dao.base.BaseDao;

@Component
public class TSentenceDao extends BaseDao {

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
    public Map<String, Object> getById(String sentence_id) {
        return findOne("select * from " + getTableName() + " where sentence_id = " + sentence_id);
    }
}