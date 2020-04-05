package task.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.out;
import static task.classes.Alphabets.eng;
import static task.classes.Alphabets.rus;
import static task.constants.FreedmanConstants.*;
import static task.classes.util.CommonUtils.*;
import static task.classes.util.FreedmanUtils.*;
import static task.classes.util.VisionerCypherUtils.shiftNTimes;
import static task.classes.util.VisionerCypherUtils.visionerCypher;

public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {

            out.println("1 - подсчитать индекс совпадения для случайных последовательностей \n" +
                    "2 - подсчитать индекс совпадения для последовательностей английского языка \n" +
                    "3 - подсчитать индекс совпадения для последовательностей русского языка\n");
            out.println("4 - подсчитать средний индекс совпадения для случайных последовательностей \n" +
                    "5 - подсчитать средний индекс совпадения для последовательностей английского языка \n" +
                    "6 - подсчитать средний индекс совпадения для последовательностей русского языка \n");
            out.println("7 - подсчитать индекс совпадения для открытого текста \n" +
                    "8 - подсчитать индекс совпадения для шифрограммы с ключом K \n");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int mode = Integer.parseInt(br.readLine());
            switch (mode) {
                case 1: {
                    String firstRandomString = generateRandomString(100);
                    String secondRandomString = generateRandomString(100);
                    writeToFile(RANDOM_STRING_1_FILE_PATH, firstRandomString);
                    writeToFile(RANDOM_STRING_2_FILE_PATH, secondRandomString);
                    double matchIndex = matchIndex(firstRandomString, secondRandomString, true);
                    writeToFile(IDX_RND, String.valueOf(matchIndex));
                    out.println("Результат записан в файл: " + IDX_RND);
                    out.println("Случайные строки записаны в файлы: " + RANDOM_STRING_1_FILE_PATH + ", " + RANDOM_STRING_2_FILE_PATH);

                    break;
                }
                case 2: {
                    String firstString = readStringFromFile(FILE_PATH + STRING_ENG_FILE_PATH_1);
                    String secondString = readStringFromFile(FILE_PATH + STRING_ENG_FILE_PATH_2);
                    double matchIndex = matchIndex(firstString, secondString, true);
                    writeToFile(IDX_ENG, String.valueOf(matchIndex));
                    out.println("Результат записан в файл: " + IDX_ENG);
                    break;
                }
                case 3: {
                    String firstString = readStringFromFile(FILE_PATH + STRING_RUS_FILE_PATH_1);
                    String secondString = readStringFromFile(FILE_PATH + STRING_RUS_FILE_PATH_2);
                    double matchIndex = matchIndex(firstString, secondString, false);
                    writeToFile(IDX_RUS, String.valueOf(matchIndex));
                    out.println("Результат записан в файл: " + IDX_RUS);
                    break;
                }
                case 4: {
                    String firstRandomString = generateRandomString(100);
                    String secondRandomString = generateRandomString(100);
                    writeToFile(RANDOM_STRING_1_FILE_PATH, firstRandomString);
                    writeToFile(RANDOM_STRING_2_FILE_PATH, secondRandomString);
                    double matchIndex = avgMatchIndex(firstRandomString, secondRandomString, eng, true);
                    writeToFile(AVG_IDX_RND, String.valueOf(matchIndex));
                    out.println("Результат записан в файл: " + AVG_IDX_RND);
                    out.println("Случайные строки записаны в файлы: " + RANDOM_STRING_1_FILE_PATH + ", " + RANDOM_STRING_2_FILE_PATH);
                    break;
                }
                case 5: {
                    String firstString = readStringFromFile(FILE_PATH + STRING_ENG_FILE_PATH_1);
                    String secondString = readStringFromFile(FILE_PATH + STRING_ENG_FILE_PATH_2);
                    double matchIndex = avgMatchIndex(firstString, secondString, eng, true);
                    writeToFile(AVG_IDX_ENG, String.valueOf(matchIndex));
                    out.println("Результат записан в файл: " + AVG_IDX_ENG);
                    break;
                }
                case 6: {
                    String firstString = readStringFromFile(FILE_PATH + STRING_RUS_FILE_PATH_1);
                    String secondString = readStringFromFile(FILE_PATH + STRING_RUS_FILE_PATH_2);
                    double matchIndex = avgMatchIndex(firstString, secondString, rus, false);
                    writeToFile(AVG_IDX_RUS, String.valueOf(matchIndex));
                    out.println("Результат записан в файл: " + AVG_IDX_RUS);
                    break;
                }
                case 7: {
                    out.println("Введите сдвиг");
                    int shift = Integer.parseInt(br.readLine());
                    String initialText = readStringFromFile(FILE_PATH + OPEN_TEXT_FILE_PATH);
                    String shiftedString = shiftNTimes(initialText, shift);
                    boolean isEng = checkIsStringEng(initialText);
                    double matchIndex = matchIndex(initialText, shiftedString, isEng);
                    writeToFile(IDX_SHIFT, String.valueOf(matchIndex));
                    out.println("Результат записан в файл: " + IDX_SHIFT);
                    break;
                }
                case 8: {
                    out.println("Введите сдвиг");
                    int shift = Integer.parseInt(br.readLine());
                    String initialText = readStringFromFile(FILE_PATH + OPEN_TEXT_FILE_PATH);
                    String key = readStringFromFile(FILE_PATH + KEY_FILE_PATH);
                    String encryptedString = visionerCypher(initialText, key);
                    String shiftedString = shiftNTimes(encryptedString, shift);
                    boolean isEng = checkIsStringEng(initialText);
                    double matchIndex = matchIndex(encryptedString, shiftedString, isEng);
                    writeToFile(IDX_SHIFT, String.valueOf(matchIndex));
                    writeToFile(ENCRYPTED_TEXT_FILE_PATH, encryptedString);
                    out.println("Результат записан в файл: " + IDX_SHIFT);
                    out.println("Результат шифрования: " + ENCRYPTED_TEXT_FILE_PATH);
                    break;
                }
                case 9: {
                    for (int i = 0; i <= 15; i++) {

                        int shift = i;
                        String initialText = readStringFromFile(FILE_PATH + OPEN_TEXT_FILE_PATH);
                        String shiftedString = shiftNTimes(initialText, shift);
                        boolean isEng = checkIsStringEng(initialText);
                        double matchIndex = matchIndex(initialText, shiftedString, isEng);
                        System.out.println(shift + ": " + matchIndex);
//                        writeToFile(IDX_SHIFT, String.valueOf(matchIndex));
//                        out.println("Результат записан в файл: " + IDX_SHIFT);
                    }
                    break;
                }
            }
        }
    }
}
