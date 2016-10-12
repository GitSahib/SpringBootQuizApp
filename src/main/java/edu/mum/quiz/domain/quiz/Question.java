package edu.mum.quiz.domain.quiz;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.mum.quiz.domain.Model;

@Entity
@Table(name="questions")
public class Question extends Model{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    private Quiz quiz;
	@Enumerated(EnumType.STRING)
	private QuestionType type;
    @NotNull
    @Size(max = 3000)
    private String text;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Choice> choices = new HashSet<Choice>();
    
    //region - Getters And Setters
    /**
	 * @return the quiz
	 */
	public Quiz getQuiz() {
		return quiz;
	}

	/**
	 * @param quiz the quiz to set
	 */
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the choices
	 */
	public Set<Choice> getChoices() {
		return choices;
	}

	/**
	 * @param choices the choices to set
	 */
	public void setChoices(Set<Choice> choices) {
		this.choices = choices;
	}

	
	public Question clone()
	{
		return this;
	}

	/**
	 * @return the type
	 */
	public QuestionType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(QuestionType type) {
		this.type = type;
	}
	//endregion
}