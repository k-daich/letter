package jp.daich.letter.spring.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TSentenceDao {

    public static final String TBL_NAME = "T_SENTENCE";
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 
     * @param id
     * @return
     */
    public List<Map<String, Object>> getById(String id) {
        return jdbcTemplate.queryForList("select * from " + TBL_NAME + " where id = " + id);
    }
}