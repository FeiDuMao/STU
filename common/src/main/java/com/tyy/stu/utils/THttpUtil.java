package com.tyy.stu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

public class THttpUtil {


    public static void main(String[] args) {


        Logger log = LoggerFactory.getLogger(THttpUtil.class);

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofHours(1))
                .version(HttpClient.Version.HTTP_2)
                .executor(TExecutor.getExecutor())
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("www.baidu.com"))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();

        try {
            HttpResponse<String> result = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            log.error("send quest to {} error !", "");
            throw new RuntimeException(e);
        }

    }


    private HttpRequest getRequest(String url, Map<String, String> param) {

        if (CollectionUtil.isNotEmpty(param)) {
            StringBuilder stringBuilder = new StringBuilder(url);
            stringBuilder.append("?");
            param.forEach((key, val) -> stringBuilder.append(key).append("=").append(val).append("&"));
            stringBuilder.deleteCharAt(stringBuilder.length());
            url = stringBuilder.toString();
        }

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
    }


}
