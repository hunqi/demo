package util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) throws IOException {

        try (InputStream in = new URL("http://www.baidu.com").openStream()) {

            byte[] buf = new byte[1024];

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (in.read(buf) != -1) {
                baos.write(buf, 0, buf.length);
            }

            System.out.println(new String(baos.toByteArray(), "UTF-8"));
        }

    }

}
