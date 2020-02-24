package jp.daich.letter.spring.model.procedure;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.daich.letter.spring.entity.request.RegistSentenceForm;
import jp.daich.letter.spring.model.db.entity.T_Sentence;
import jp.daich.letter.spring.model.db.repository.TSentenceRepository;

@Component
public class RegistSentenceProcedure {

    @Autowired
    TSentenceRepository tSentenceRepository;

    public void execute(RegistSentenceForm requestForm) {

        // リクエストフォーム情報のチェック
        T_Sentence t_Sentence = buildEntity(requestForm);

        // DBへinsertを実施する
        tSentenceRepository.saveAndFlush(t_Sentence);
    }

    /**
     * build entity by requestForm values
     * @param requestForm
     * @return
     */
    private T_Sentence buildEntity(RegistSentenceForm requestForm) {
        T_Sentence t_Sentence = new T_Sentence();

        t_Sentence.setSentence_id("TODO_impl");
        t_Sentence.setTitle(requestForm.getTitle());
        t_Sentence.setSender(requestForm.getSender());
        t_Sentence.setDestination(requestForm.getDestination());
        t_Sentence.setCreate_date(new Date());

        return t_Sentence;
    }
}