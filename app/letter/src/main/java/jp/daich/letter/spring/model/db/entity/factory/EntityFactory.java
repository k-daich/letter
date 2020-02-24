package jp.daich.letter.spring.model.db.entity.factory;

public abstract class EntityFactory<E extends EntityBase,O extends Object> {

    protected EntityBase entityBase;

    protected EntityFactory(E entityBase) {
        this.entityBase = entityBase;
    }

    abstract public E create(Object object);

}