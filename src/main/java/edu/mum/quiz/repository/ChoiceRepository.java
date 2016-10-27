package edu.mum.quiz.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.quiz.domain.quiz.Choice;
import edu.mum.quiz.domain.quiz.Question;
@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long>{
	Choice findById(Long Id);
	void delete(Choice Choice);
	List<Choice> findByQuestion(Question question);
}
