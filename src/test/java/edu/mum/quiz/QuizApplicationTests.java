package edu.mum.quiz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mum.quiz.domain.quiz.ChoiceBuilder;
import edu.mum.quiz.domain.quiz.Question;
import edu.mum.quiz.domain.quiz.QuestionBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void testBuildQuestionWithBooleanAnswer() 
	   throws CloneNotSupportedException {
	
	  Question q = new QuestionBuilder()
	                .title("Studies say people are crazy.")
	                .choice(new ChoiceBuilder()
	                        //.booleanChoice(true)
	                        //.text("They are crazy")
	                        .asChoice()
	                ).asQuestion();
	
	    assertEquals("Studies say people are crazy.", q.getText());
	    assertEquals(1, q.getChoices().size());
	   // assertEquals("They are crazy", q.getChoices().get(0).getAnswerText());
	
	   // assertEquals(BooleanChoice.class, q.getChoices().get(0).getClass());
	
	    Question q2 = q.clone();
	    assertEquals(q2, q);
	    assertNotSame(q2, q);
	}

}
