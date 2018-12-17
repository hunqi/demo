package v2ch04.urlConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

/**
 * Get web data by URLConnection
 * @author ray.sun
 * @since Dec 14th 2018
 */
public class URLConnectionUtils {

    public static String get(String urlStr, String username, String password){
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(30000);

            if(url == null || urlStr.replace(" ", "").equals("")) return "";
            connection.setRequestProperty("Authorization", assembleBasicToken(username, password));
            connection.connect();

            StringBuilder result = new StringBuilder();
            try (Scanner in = new Scanner(connection.getInputStream(), "UTF-8")){
                while (in.hasNextLine())
                    result.append(in.nextLine());
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String assembleBasicToken(String username, String password){
        String input = username + ":" + password;
        Base64.Encoder encoder = Base64.getEncoder();
        String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
        return "Basic " + encoding;
    }

    public static void main(String[] args) {
        String result = URLConnectionUtils.get("http://www.baidu.com",
                "",
                "");
        System.out.println("result=" + result);
    }

}
