package jp.daich.letter.spring.model.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "vsCode", date = "2020/02/23")
@StaticMetamodel(T_Page.class)
public class T_Page_ {
    public static volatile SingularAttribute<T_Page, String> page_id;
    public static volatile SingularAttribute<T_Page, String> fk_sentence_id;
    public static volatile SingularAttribute<T_Page, Integer> page_of_sentence;
    public static volatile SingularAttribute<T_Page, String> text;
    public static volatile SingularAttribute<T_Page, String> image;
    public static volatile SingularAttribute<T_Page, Integer> form_id;
    public static volatile SingularAttribute<T_Page, Integer> form_type;
}