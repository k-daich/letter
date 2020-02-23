package jp.daich.letter.spring.model.db.dao.repository;

import java.util.Iterator;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import jp.daich.letter.spring.model.db.entity.T_Sentence;

@Repository
// public interface TSentenceRepository extends JpaRepository<T_Sentence Long> {
public interface TSentenceRepository {

//    @Query(value="SELECT TS FROM T_SENTENCE AS ts WHERE TS.SENTENCE_ID = 1")
    Iterator<T_Sentence> findBySentence_id(String sentence_id);
}