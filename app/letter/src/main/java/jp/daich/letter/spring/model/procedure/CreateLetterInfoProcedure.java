package jp.daich.letter.spring.model.procedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.daich.letter.spring.entity.response.LetterInfo;

@Component
public class CreateLetterInfoProcedure {

    @Autowired
    private LetterInfo info;

    public LetterInfo create(String id) {
        info.setId(id);

        return info;

    }

}