package calclulate;

import java.util.ResourceBundle;

/**
 * Created by erafiil on 25.06.15.
 */
class Message {

    static String getMessage(String key) {
        resourceBundle = ResourceBundle.getBundle(FILE_NAME);
        return resourceBundle.getString(key);
    }

    private static ResourceBundle resourceBundle;
    private final static String FILE_NAME = "messages";
}
