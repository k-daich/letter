package jp.daich.letter.spring.model.db.repository;

import org.springframework.stereotype.Repository;

import jp.daich.letter.spring.model.db.entity.T_Sentence;

@Repository
public interface TSentenceRepositoryCustom {

    T_Sentence findBySentence_id(String sentence_id);
}