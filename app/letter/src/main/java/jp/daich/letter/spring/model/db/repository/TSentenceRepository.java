package jp.daich.letter.spring.model.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.daich.letter.spring.model.db.entity.T_Sentence;

@Repository
public interface TSentenceRepository extends JpaRepository<T_Sentence, Long> {
}