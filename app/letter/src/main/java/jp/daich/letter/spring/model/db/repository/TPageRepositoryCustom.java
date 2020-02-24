package jp.daich.letter.spring.model.db.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.daich.letter.spring.model.db.entity.T_Page;

@Repository
public interface TPageRepositoryCustom {

    List<T_Page> findBySentence_id(String sentence_id);
}