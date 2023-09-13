package com.tyy.stu.http;

import com.tyy.stu.utils.TExecutor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLParameters;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class BlibiliFans {





    @SneakyThrows
    @Test
    public void test(){


        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .executor(TExecutor.getExecutor())
                .build();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.bilibili.com/x/relation/stat?vmid=254463269&w_rid=f4c9c5b5e0379033b207bcd7f65103ed&wts=1693579706&web_location=333.999"))
                .setHeader("aa","cc")
                .version(HttpClient.Version.HTTP_1_1)
                .GET()
                .build();



        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println( request.toString());
        System.out.println(body);



    }






}
