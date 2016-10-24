package edu.mum.quiz.domain.quiz;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.mum.quiz.domain.Model;

@Entity

public class Subject extends Model{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    @Size(max = 200)
    private String name;
	
    @NotNull
    private String mission;
    @NotNull
    private Date startDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Question> questions;
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mission
	 */
	public String getMission() {
		return mission;
	}

	/**
	 * @param mission the mission to set
	 */
	public void setMission(String mission) {
		this.mission = mission;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the Questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param Questions the Questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	
}
