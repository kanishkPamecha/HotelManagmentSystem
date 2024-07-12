package Hotel.Management.System;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class Node {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:3000/api/data");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String data = "{\"key\": \"value\"}";
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = data.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            String response = conn.getResponseMessage();
            System.out.println("Response Code: " + response);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
