package problems.onstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProblemTests {
    @Test
    public void testMorseCodes() {
        UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
        String[] words  = {"gin", "zen", "gig", "msg"};
        assertEquals(2, uniqueMorseRepresentations.uniqueMorseRepresentations(words));

    }
    @Test
    public void judgeCircle() {
        JudgeCircle judgeCircle = new JudgeCircle();
        assertEquals(true, judgeCircle.judgeCircle("UD"));
        assertEquals(false, judgeCircle.judgeCircle("UL"));
        assertEquals(true, judgeCircle.judgeCircle("LR"));

    }
}
