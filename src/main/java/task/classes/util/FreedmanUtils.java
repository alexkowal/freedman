package task.classes.util;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Map;

public class FreedmanUtils {
    private FreedmanUtils() {
    }

    public static Double matchIndex(String s1, String s2, boolean isEng) throws Exception {
        s1 = formatString(s1, isEng);
        s2 = formatString(s2, isEng);
        if (s1.length() != s2.length())
            throw new Exception("Длина строк должна совпадать");
        return ((double) (compareStrings(s1.toLowerCase(), s2.toLowerCase())) / s1.length()) * 100;
    }

    public static Double avgMatchIndex(String s1, String s2, Map<String, Integer> alph, boolean isEng) throws Exception {
        s1 = formatString(s1, isEng);
        s2 = formatString(s2, isEng);

        if (s1.length() != s2.length())
            throw new Exception("Длина строк должна совпадать");
        Map<String, Integer> first = Maps.newHashMap(alph);
        Map<String, Integer> second = Maps.newHashMap(alph);
        first = Maps.newHashMap(Maps.transformValues(first, val -> 0));
        second = Maps.newHashMap(Maps.transformValues(second, val -> 0));

        for (int i = 0; i < s1.length(); i++) {
            String val = String.valueOf(s1.charAt(i));
            first.put(val, first.get(val) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            String val = String.valueOf(s2.charAt(i));
            second.put(val, second.get(val) + 1);
        }

        double result = 0;

        List<Integer> valuesFirst = Lists.newArrayList(first.values());
        List<Integer> valuesSecond = Lists.newArrayList(second.values());

        for (int i = 0; i < alph.size(); i++) {
            result = result + ((double) valuesFirst.get(i) / s1.length() *
                    ((double) valuesSecond.get(i) / s1.length()));
        }
        return result * 100;
    }

    private static int compareStrings(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i))
                res++;
        }
        return res;
    }

    private static String formatString(String s, boolean isEng) {
        s = s.toLowerCase();
        if (isEng) {
            return removeNonAlphCharsEng(s);
        } else {
            return removeNonAlphCharsRus(s);
        }
    }

    private static String removeNonAlphCharsEng(String s) {
        s = s.replaceAll("[^a-zA-Z\\s]", "");
        return s;
    }

    private static String removeNonAlphCharsRus(String s) {
        s = s.replaceAll("[^а-яА-Я\\s]", "");
        return s;
    }

    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }


}
