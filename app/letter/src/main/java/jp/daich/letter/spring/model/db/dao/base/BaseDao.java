package jp.daich.letter.spring.model.db.dao.base;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
abstract public class BaseDao {

    @Autowired
    protected EntityManager em;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    /**
     * child class must implement
     * 
     * @return tableName
     */
    abstract protected String getTableName();

    /**
     * find one row from DB. If found other than one, throw exception.
     * 
     * @param query
     * @return one row
     */
    protected void assertOneRecord(List<Object> resultSet) {
        // 検索結果：1件
        if (resultSet.size() == 1) {
            return;
        } else {
            // 検索結果：0件
            if (resultSet.size() == 0) {
                throw new RuntimeException("resultSet is not Found.");
            }
            // 検索結果：2件以上
            else {
                throw new RuntimeException(
                        "resultSet is found some row. row size = " + resultSet.size());
            }
        }
    }

    /**
     * It find any row from DB. If found 0 row, throw exception.
     * 
     * @param query
     * @return row list
     */
    protected List<Map<String, Object>> findList(String query) {
        List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(query);

        if (resultSet.size() == 0) {
            throw new RuntimeException("findList(query) is not Found. query = " + query);
        }
        return resultSet;
    }

}