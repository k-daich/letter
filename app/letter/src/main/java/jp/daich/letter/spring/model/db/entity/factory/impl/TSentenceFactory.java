package jp.daich.letter.spring.model.db.entity.factory.impl;

import jp.daich.letter.spring.model.db.entity.T_Sentence;
import jp.daich.letter.spring.model.db.entity.factory.EntityFactory;

public class TSentenceFactory <E extends T_Sentence, O extends Object> extends EntityFactory {

    public TSentenceFactory(E entityBase) {
        super(entityBase);
    }

    @Override
    public T_Sentence create(Object obj) {
        return (T_Sentence) entityBase;
    }

}