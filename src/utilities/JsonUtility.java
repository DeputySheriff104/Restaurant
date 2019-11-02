package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class JsonUtility {

    public static void addOpenSquareBracket(String jsonPath) throws IOException {

        FileWriter file = new FileWriter(jsonPath, false);
        file.write("[\n");
        file.flush();

    }

    public static void addCloseSquareBracket(String jsonPath) throws IOException {

        FileWriter file = new FileWriter(jsonPath, true);
        file.append("\n]");
        file.flush();
    }

    public static void addCommaAndNewLine(String jsonPath) throws IOException {

        FileWriter file = new FileWriter(jsonPath, true);
        file.append(",\n");
        file.flush();

    }
}
