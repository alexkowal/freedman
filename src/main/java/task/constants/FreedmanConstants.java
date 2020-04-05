package task.constants;

import task.classes.Main;

import java.io.File;
import java.net.URISyntaxException;

public class FreedmanConstants {
    String FILE_PATH = new File(Main.class.getProtectionDomain().getCodeSource().getLocation()
            .toURI()).getPath().replace("freedman.jar", "/");

    //    public static final String FILE_PATH = "/Users/aleksandr/freedman/src/main/java/task/files/";
    public static final String STRING_RUS_FILE_PATH_1 = "rus1.txt";
    public static final String STRING_RUS_FILE_PATH_2 = "rus2.txt";
    public static final String STRING_ENG_FILE_PATH_1 = "eng1.txt";
    public static final String STRING_ENG_FILE_PATH_2 = "eng2.txt";

    public static final String ALPH_FILE_PATH = "alph.txt";
    public static final String OPEN_TEXT_FILE_PATH = "text.txt";
    public static final String KEY_FILE_PATH = "key.txt";
    public static final String ENCRYPTED_TEXT_FILE_PATH = "encrypted-text.txt";
    public static final String RANDOM_STRING_1_FILE_PATH = "random-string-1.txt";
    public static final String RANDOM_STRING_2_FILE_PATH = "random-string-2.txt";

    public static final String AVG_IDX_RUS = "средний индекс совпадения русских строк.txt";
    public static final String AVG_IDX_ENG = "средний индекс совпадения английских строк.txt";
    public static final String AVG_IDX_RND = "средний индекс совпадения случайных строк.txt";

    public static final String IDX_RUS = "индекс совпадения русских строк.txt";
    public static final String IDX_ENG = "индекс совпадения английских строк.txt";
    public static final String IDX_RND = "индекс совпадения случайных строк.txt";
    public static final String IDX_SHIFT = "индекс совпадения строк со сдвигом.txt";


    public FreedmanConstants() throws URISyntaxException {
    }
}
