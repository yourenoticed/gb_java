import java.io.FileWriter;
import java.io.IOException;

public class Task3_writeFile {
    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("task3.txt");
        file.write(getString(100, "Test"));
        file.close();
    }

    public static String getString(int amount, String word) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            string.append(word + "\n");
        }
        return string.toString();
    }
}