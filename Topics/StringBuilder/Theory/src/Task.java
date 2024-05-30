// You can experiment here, it won’t be checked

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://stepik.org/media/attachments/lesson/255258/logins.txt");
        Scanner sc = new Scanner(url.openStream(), StandardCharsets.UTF_8);

        while (sc.hasNextLine()) {
            String user = sc.nextLine();
            System.out.println(user);
        }
    }
}