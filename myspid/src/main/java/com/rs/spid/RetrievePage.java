package com.rs.spid;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RetrievePage {

    private static CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    static boolean download(String url, String outputFile) throws IOException {
        HttpGet post = new HttpGet(url);

        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){

            try(InputStream content = response.getEntity().getContent();
                BufferedOutputStream bos = new BufferedOutputStream(
                        Files.newOutputStream(Paths.get(outputFile)))){
                int b = -1;

                while ((b = content.read()) != -1){
                    bos.write(b);
                }
            }
            System.out.printf("written to disk: %s\n", outputFile);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        download("http://www.stcn.com/", String.format("D:\\demos\\Spider\\%d.txt", System.currentTimeMillis()));
    }

}
