package Step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static Integer getInteger(String prompt) {
        int value;
        System.out.print(prompt);
        try {
            value = Integer.parseInt(Input.input.readLine());
        } catch (Exception error) {
            // error condition
            throw new NumberFormatException();
        }
        return value;
    }

    public static String getString(String prompt) {
        String string;
        System.out.print(prompt);
        try {
            string = Input.input.readLine();
        } catch (Exception error) {
            // error condition
            string = null;
        }
        return string;
    }


}