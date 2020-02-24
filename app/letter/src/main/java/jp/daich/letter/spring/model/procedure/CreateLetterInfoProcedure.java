package jp.daich.letter.spring.model.procedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.daich.letter.spring.entity.response.LetterInfo;
import jp.daich.letter.spring.model.db.repository.TPageRepositoryCustom;
import jp.daich.letter.spring.model.db.repository.TSentenceRepositoryCustom;

@Component
public class CreateLetterInfoProcedure {

    @Autowired
    private LetterInfo letterInfo;

    @Autowired
    private TSentenceRepositoryCustom tSentenceRepoCstm;

    @Autowired
    private TPageRepositoryCustom tPageRepoCstm;

    public LetterInfo execute(String sentence_id) {

        // レスポンス用のオブジェクトにTSentenceの情報を設定する
        letterInfo.setTSentenceValues(
                // TSentenceテーブルをSELECT
                tSentenceRepoCstm.findBySentence_id(sentence_id));

        // レスポンス用のオブジェクトにT_Pageリストを設定する
        letterInfo.settPageList(
                // T_PageテーブルをSELECT
                tPageRepoCstm.findBySentence_id(
                        // TSentenceテーブルのsentence_id
                        letterInfo.getSentence_id()));

        return letterInfo;
    }

}