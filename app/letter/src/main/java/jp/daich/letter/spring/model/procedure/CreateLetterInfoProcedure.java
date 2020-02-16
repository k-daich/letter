package jp.daich.letter.spring.model.procedure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.db.entity.TPage;
import jp.daich.letter.spring.entity.response.LetterInfo;
import jp.daich.letter.spring.model.db.dao.TPageDao;
import jp.daich.letter.spring.model.db.dao.TSentenceDao;

@Component
public class CreateLetterInfoProcedure {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private LetterInfo letterInfo;

    @Autowired
    private TSentenceDao tSentenceDao;

    @Autowired
    private TPageDao tPageDao;

    public LetterInfo execute(String sentence_id) {
        // レスポンス用のオブジェクトにTSentenceの情報を設定する
        letterInfo.setTSentenceValues(
                // 取得したエンティティからTSentenceオブジェクトを構築する
                // TSentence.build(
                        // TSentenceテーブルをSELECT
                        tSentenceDao.getById(sentence_id));

        // レスポンス用のオブジェクトにTpageリストを設定する
        letterInfo.settPageList(
                // 取得したエンティティからTPageオブジェクトのリストを構築する
                buildTPageList(
                        // TPageテーブルをSELECT
                        tPageDao.getBySentence_id(
                                // TSentenceテーブルのsentence_id
                                letterInfo.getSentence_id())));

        return letterInfo;
    }

    /**
     * Daoの結果Listを元にTpageオブジェクトのListを構築する
     * @param entityList
     * @return
     */
    private List<TPage> buildTPageList(List<Map<String, Object>> entityList) {
        List<TPage> tpl = new ArrayList<>();
        for (Map<String, Object> row : entityList) {
            tpl.add(TPage.build(row));
        }
        return tpl;
    }
}