package jp.daich.letter.spring.model.db.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="vsCode", date="2020/02/22")
@StaticMetamodel(T_Sentence.class)
public class T_Sentence_ {
    public static volatile SingularAttribute<T_Sentence, String> sentence_id;
    public static volatile SingularAttribute<T_Sentence, String> title;
    public static volatile SingularAttribute<T_Sentence, String> sender;
    public static volatile SingularAttribute<T_Sentence, String> destination;
    public static volatile SingularAttribute<T_Sentence, Date> create_date;
}