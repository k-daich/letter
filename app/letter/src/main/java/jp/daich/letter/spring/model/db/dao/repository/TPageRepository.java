package jp.daich.letter.spring.model.db.dao.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.daich.letter.spring.model.db.entity.TPage;

@Repository
public interface TPageRepository {

    List<TPage> findBySentence_id(String sentence_id);
}