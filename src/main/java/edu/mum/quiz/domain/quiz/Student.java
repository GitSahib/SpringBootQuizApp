package edu.mum.quiz.domain.quiz;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.mum.quiz.domain.Model;

public class Student extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(max = 40)
	private String name;
	@NotNull
	private String ID;
	@NotNull
	private String email;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
