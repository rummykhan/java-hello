package org.example.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class CoreHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(CoreHttpClient.class);

    private HttpClient client = null;

    public CoreHttpClient() {
        this.client = HttpClientBuilder.create().build();
    }

    public String get(String url) {

        logger.info("Google search url: {}", url);

        HttpGet getRequest = new HttpGet(url);
        getRequest.addHeader("Accept", "application/json");

        HttpResponse response = null;
        try {
             response = this.client.execute(getRequest);

            return this.formatResponse(response);
        } catch (Exception e) {
            logger.info("Found exception: {}", e.getMessage());
        } finally {
            logger.info("Http request closed: {}", response);
        }

        return null;
    }


    private String formatResponse(HttpResponse response) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder stringBuilder = new StringBuilder();

        String line = "";
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }
}
