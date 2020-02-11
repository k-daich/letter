package jp.daich.letter.spring.model.dao.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

abstract public class BaseDao {

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
    protected Map<String, Object> findOne(String query) {
        List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(query);

        // 検索結果：1件
        if (resultSet.size() == 1) {
            return resultSet.get(0);
        } else {
            // 検索結果：0件
            if (resultSet.size() == 0) {
                throw new RuntimeException("findOne(query) is not Found. query = " + query);
            }
            // 検索結果：2件以上
            else {
                throw new RuntimeException(
                        "findOne(query) is found some row. query = " + query + ", and row size = " + resultSet.size());
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