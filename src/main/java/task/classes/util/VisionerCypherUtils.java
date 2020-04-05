package task.classes.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static task.constants.FreedmanConstants.ALPH_FILE_PATH;
import static task.constants.FreedmanConstants.FILE_PATH;
import static task.classes.util.CommonUtils.readStringFromFile;

public class VisionerCypherUtils {

    private static String normalizeKey(String text, String key) {
        String resultKey = "";
        while (resultKey.length() < text.length()) {
            resultKey = resultKey.concat(key);
        }
        return resultKey.substring(0, text.length());
    }

    public static String visionerCypher(String text, String key) throws IOException {
        Map<Character, Integer> alph = getAlphFromFile();
        Map<Integer, Character> reversedAlph = getReversedAplh(alph);
        text = text.toLowerCase();
        key = key.toLowerCase();
        String normalizedKey = normalizeKey(text, key);
        int module = alph.size();
        StringBuilder encryptedString = new StringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            int pos = (((alph.get(text.charAt(i)) + alph.get(normalizedKey.charAt(i))) % module));
            encryptedString.setCharAt(i, reversedAlph.get(pos));
        }
        return encryptedString.toString();
    }

    private static Map<Integer, Character> getReversedAplh(Map<Character, Integer> alph) {
        Map<Integer, Character> reversedAlph = new HashMap<>();
        alph.forEach((key, value) -> reversedAlph.put(value, key));
        return reversedAlph;
    }

    private static Map<Character, Integer> getAlphFromFile() throws IOException {
        String alphFromFile = readStringFromFile(FILE_PATH + ALPH_FILE_PATH);
        alphFromFile = sortString(alphFromFile);
        Map<Character, Integer> alph = new HashMap<>();
        for (int i = 0; i < alphFromFile.length(); i++) {
            char chatAtIndex = alphFromFile.charAt(i);
            if (!alph.containsKey(chatAtIndex)) {
                alph.put(chatAtIndex, i);
            }
        }
        return alph;
    }

    private static String sortString(String text) {
        return text.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String cycleShift(String text) {
        String substring = text.substring(0, text.length() - 1);
        String result = String.valueOf(text.charAt(text.length() - 1));
        return result.concat(substring);
    }

    public static String shiftNTimes(String text, int count) {
        String tmp = text;
        for (int i = 0; i < count; i++) {
            tmp = cycleShift(tmp);
        }
        return tmp;
    }
}
