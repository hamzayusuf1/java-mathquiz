package org.mathquiz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MathquizTest {
    @Test
    public void ValidateAnswerCorrect () {
        Main main = new Main();
        Result result = new Result(true, 23.0);
        main.OutputMessage(result);

    }
    @Test
    public void TestAnswerIncorrect () {
        Main main = new Main();
        Result result = new Result(false, 45.0);
        main.OutputMessage(result);

    }
    @Test
    public void TestOnlyRightAnswers () throws Exception {
        Main main = new Main();
         Result result = main.CheckAnswer1(23.0);
         assertTrue(result.isSuccessful);
    }

    @Test
    public void TestWrongAnswers () throws Exception {
        Main main = new Main();
         Result result = main.CheckAnswer1(33.0);
         assertFalse(result.isSuccessful);
    }



}
