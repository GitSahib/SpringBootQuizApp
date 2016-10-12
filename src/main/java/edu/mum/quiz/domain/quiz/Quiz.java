package edu.mum.quiz.domain.quiz;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.mum.quiz.domain.Model;

@Entity
@Table(name = "quiz")
public class Quiz extends Model{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull

	@Size(max = 200)
	private String title;

	@OneToMany(mappedBy="quiz")
	List<Question> questions;
	
	@NotNull
	@Size(max = 500)
	private String description;
	
	@NotNull
	Date startTime;
	@NotNull
	Date endTime;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Quiz [title=" + title + ", description=" + description + "]";
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


}
