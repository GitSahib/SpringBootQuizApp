package edu.mum.quiz.domain.quiz;

import java.util.Arrays;

public enum QuestionType {
	MULTIPLE_CHOICE,
	TURE_FALSE,
	FILL_BLANK,
	SHORT_QUESTION,
	LONG_QUESTION;
	public static String[] getNames() {
	    return Arrays.stream(values()).map(Enum::name).toArray(String[]::new);
	}
}
