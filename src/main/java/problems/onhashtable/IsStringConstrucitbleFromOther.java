package problems.onhashtable;

import java.util.HashMap;

public class IsStringConstrucitbleFromOther {
    public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                            String magazineText) {
        HashMap<Character, Integer> ii = new HashMap<>();
        for (int i = 0; i < letterText.length(); i++) {
            if (!ii.containsKey(letterText.charAt(i))) {
                ii.put(letterText.charAt(i), 1);
            } else {
                ii.put(letterText.charAt(i), ii.get(letterText.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < magazineText.length(); i++) {
            if (ii.containsKey(magazineText.charAt(i))) {
                ii.put(magazineText.charAt(i), ii.get(magazineText.charAt(i)) - 1);
                if (ii.get(magazineText.charAt(i)) == 0) {
                    ii.remove(magazineText.charAt(i));
                    if (ii.isEmpty()) return true;
                }
            }
        }
        return ii.isEmpty();
    }

}
