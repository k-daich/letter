package jp.daich.letter.spring.model.db.dao.repository;

import org.springframework.stereotype.Repository;

import jp.daich.letter.spring.model.db.entity.T_Sentence;

@Repository
public interface TSentenceRepository {

    T_Sentence findBySentence_id(String sentence_id);
}