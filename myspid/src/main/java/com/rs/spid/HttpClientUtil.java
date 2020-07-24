package com.rs.spid;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;

public class HttpClientUtil {

    private static final AuthScope ANY_AUTH_SCOPE = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);

    public static CloseableHttpClient getNoopSSLClient(String user, String password) {
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder.setDefaultCredentialsProvider(credentialsProvider(user, password));
        clientBuilder.setSSLSocketFactory(noopSSLConnectionSocketFactory());

        return clientBuilder.build();
    }

    static CredentialsProvider credentialsProvider(String user, String password){
        CredentialsProvider cp = new BasicCredentialsProvider();
        cp.setCredentials(ANY_AUTH_SCOPE, new UsernamePasswordCredentials(user, password));
        return cp;
    }

    private static SSLConnectionSocketFactory noopSSLConnectionSocketFactory() {
        SSLContext sslContext;
        try {
            sslContext = new SSLContextBuilder().loadTrustMaterial(null,
                    (chain, authType) -> true).build();

            // trust all hosts
            return new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
