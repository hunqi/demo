package com.rs.spid;

import org.apache.commons.codec.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MySpider1 {

    private HttpResponse response;

    public static void main(String[] args) throws IOException {
        MySpider1 spider1 = new MySpider1();
        /*try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpResponse response = spider1.post(httpClient, "https://www.baidu.com");
            spider1.print(response);
        }*/

        try (/*CloseableHttpClient httpClient = HttpClientUtil.getNoopSSLClient("hello", "world");*/
                CloseableHttpClient httpClient = HttpClientBuilder.create().build()
        ) {
            //http://www.stcn.com/
            //http://data.stcn.com/common27/filepublish/tradedata/jiaoyi.html?type=ahbj
            spider1.get(httpClient, "http://data.stcn.com/common27/filepublish/tradedata/jiaoyi.html?type=ahbj").print();
        }
    }

    MySpider1 post(CloseableHttpClient httpClient, String url) throws IOException {
//        List<NameValuePair> pairs = new ArrayList<>();
//        pairs.add(new BasicNameValuePair("virus", "pandemic"));
//        pairs.add(new BasicNameValuePair("country", "America"));

        HttpPost post = new HttpPost(url);

//        post.setEntity(new UrlEncodedFormEntity(pairs, Charsets.UTF_8));
        response = httpClient.execute(post);

        return this;
    }

    void setPostEntity(HttpPost post, List<NameValuePair> pairs){
        post.setEntity(new UrlEncodedFormEntity(pairs, Charsets.UTF_8));
    }

    void print() throws IOException {
        if (null == response) {
            System.out.println("response is null");
            return;
        }

        try (Scanner scanner = new Scanner(response.getEntity().getContent())) {
            while (scanner.hasNext()) {
                String line = scanner.next();
//                if (null != line && line.contains("http"))
                System.out.println(line);
            }

        }
    }

    MySpider1 get(CloseableHttpClient httpClient, String url) throws IOException {
        HttpGet get = new HttpGet(url);
        response = httpClient.execute(get);
        return this;
    }

}
