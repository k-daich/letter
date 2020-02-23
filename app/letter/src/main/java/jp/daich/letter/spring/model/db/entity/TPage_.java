package jp.daich.letter.spring.model.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "vsCode", date = "2020/02/23")
@StaticMetamodel(TPage.class)
public class TPage_ {
    public static volatile SingularAttribute<TPage, String> page_id;
    public static volatile SingularAttribute<TPage, String> fk_sentence_id;
    public static volatile SingularAttribute<TPage, Integer> page_of_sentence;
    public static volatile SingularAttribute<TPage, String> text;
    public static volatile SingularAttribute<TPage, String> image;
    public static volatile SingularAttribute<TPage, Integer> form_id;
    public static volatile SingularAttribute<TPage, Integer> form_type;
}