package jp.daich.letter.spring.model.procedure;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.daich.letter.spring.entity.response.LetterInfo;
import jp.daich.letter.spring.model.dao.TSentenceDao;

@Component
public class CreateLetterInfoProcedure {

    @Autowired
    private LetterInfo info;

    @Autowired
    private TSentenceDao tSentenceDao;

    public LetterInfo create(String id) {

        List<Map<String, Object>> tSentence = tSentenceDao.getById(id);

        if (tSentence.size() == 1) {
            // debug keyset of resultSetKey
            System.out.println(tSentence.get(0).get("title"));
            info.setId(id);
            info.setText((String)tSentence.get(0).get("title"));
        }
        else {
            // debug
            System.out.println("tSentenceDao.getById(id) is not Found. id = " + id);
            info.setId("");
        }

        return info;
    }

}