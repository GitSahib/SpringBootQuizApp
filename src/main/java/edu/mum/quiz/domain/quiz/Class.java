package edu.mum.quiz.domain.quiz;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.mum.quiz.domain.Model;


public class Class extends Model{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    @Size(max = 80)
    private String name;

    @NotNull
    private String mission;
    @NotNull
    private Date startDate;

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
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@ElementCollection
    private List<Student> students;
}
