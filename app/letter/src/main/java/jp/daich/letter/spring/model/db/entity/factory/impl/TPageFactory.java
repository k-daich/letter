package jp.daich.letter.spring.model.db.entity.factory.impl;

import jp.daich.letter.spring.model.db.entity.T_Page;
import jp.daich.letter.spring.model.db.entity.factory.EntityFactory;

public class TPageFactory<E extends T_Page, O extends Object> extends EntityFactory {

    public TPageFactory(E entityBase) {
        super(entityBase);
    }

    public T_Page create(Object obj) {
        return (T_Page) entityBase;
    }
}