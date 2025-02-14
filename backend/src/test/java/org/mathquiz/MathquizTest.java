package org.mathquiz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MathquizTest {
    @Test
    public void ValidateAnswerCorrect () {
        Main main = new Main();
        Result result = new Result(true, 23.0, 23.0,1000);
        main.OutputMessage(result);

    }
    @Test
    public void TestAnswerIncorrect () {
        Main main = new Main();
        Result result = new Result(false, 45.0,37.0, 1000);
        main.OutputMessage(result);

    }
    @Test
    public void TestOnlyRightAnswers1 () throws Exception {
        Main main = new Main();
         Result result = main.CheckAnswer1(23.0, 1000);
         assertTrue(result.isSuccessful);
    }

    @Test
    public void TestWrongAnswers1 () throws Exception {
        Main main = new Main();
         Result result = main.CheckAnswer1(33.0,1000);
         assertFalse(result.isSuccessful);
    }

    @Test
    public void TestRightAnswers2 () throws Exception {
        Result result = Main.CheckAnswer2(37, 1000);
        assertTrue(result.isSuccessful);
        System.out.println(result.value);
    }

    @Test
    public void TestWrongAnswers2 () throws Exception {
        Result result = Main.CheckAnswer2(33.0,1000);
        assertFalse(result.isSuccessful);
    }

    @Test
    public void TestRightAnswers3() throws Exception {
        Result result = Main.CheckAnswer3(6400, 1000);
        assertTrue(result.isSuccessful);
    }

    @Test
    public void TestWrongAnswers3 () throws Exception {
        Result result = Main.CheckAnswer1(33.0,1000);
        assertFalse(result.isSuccessful);
    }

    @Test
    public void increasingPlayerScore() throws Exception {
        Result result = Main.CheckAnswer1(23, 1000);
        int actual = Main.playerScore;
        int expected = 1;
        assertEquals(1, actual, "Should be equal to 1 as is the first question");
    }

    @Test
    public void CorrectFinalScore() throws Exception {
        Main.CheckAnswer1(23, 1000);
        Main.CheckAnswer2(37, 1000);
        Main.CheckAnswer3(37, 1000);

        int actual = Main.playerScore;
        int expected = 2; /*Only two right answers*/

        assertEquals(2, actual, "eRROR");
    }



}
