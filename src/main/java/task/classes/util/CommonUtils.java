package task.classes.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static task.constants.FreedmanConstants.FILE_PATH;

public class CommonUtils {
    public static String readStringFromFile(String fileName) throws IOException {
        List<String> r = Files.readAllLines(new File(fileName).toPath(), StandardCharsets.UTF_8);
        String result = "";
        for (String s : r) {
            result = result.concat(s);
        }
        return result;
    }

    public static void writeToFile(String fileName, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH + fileName))) {
            bw.write(content);
        }
    }

    public static boolean checkIsStringEng(String text) {
        return (text.charAt(0) > 'a' && text.charAt(0) < 'z') || (text.charAt(0) > 'A' && text.charAt(0) < 'Z');
    }
}
