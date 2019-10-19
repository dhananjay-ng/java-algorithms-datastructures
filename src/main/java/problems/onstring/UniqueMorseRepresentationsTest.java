package problems.onstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueMorseRepresentationsTest {
    @org.junit.jupiter.api.Test
    public void testMorseCodes() {
        UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
        String[] words  = {"gin", "zen", "gig", "msg"};
        assertEquals(2, uniqueMorseRepresentations.uniqueMorseRepresentations(words));

    }
}
