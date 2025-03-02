package org.mathquiz.repository;

import org.mathquiz.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    // Custom query methods can be added here
    @Query(value = "SELECT * FROM public.questions ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Questions findRandomQuestion();

    List<Questions> findByDifficulty(String category);

}
