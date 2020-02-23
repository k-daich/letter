package jp.daich.letter.spring.model.procedure;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.daich.letter.spring.entity.response.LetterInfo;
import jp.daich.letter.spring.model.db.dao.repository.TPageRepository;
import jp.daich.letter.spring.model.db.dao.repository.TSentenceRepository;

@Component
public class CreateLetterInfoProcedure {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private LetterInfo letterInfo;

    @Autowired
    private TSentenceRepository tSentenceRepo;

    @Autowired
    private TPageRepository tPageRepo;

    public LetterInfo execute(String sentence_id) {

        // レスポンス用のオブジェクトにTSentenceの情報を設定する
        letterInfo.setTSentenceValues(
                // TSentenceテーブルをSELECT
                tSentenceRepo.findBySentence_id(sentence_id));

        // レスポンス用のオブジェクトにTpageリストを設定する
        letterInfo.settPageList(
                // TPageテーブルをSELECT
                tPageRepo.findBySentence_id(
                        // TSentenceテーブルのsentence_id
                        letterInfo.getSentence_id()));

        return letterInfo;
    }

}