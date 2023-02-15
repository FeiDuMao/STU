package com.tyy.stu.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tyy.stu.utils.JsonUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Collection;

@Slf4j
public class HttpTest {


    public static void main(String[] args) throws IOException, InterruptedException {


        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofHours(1))
                .build();

        URI jaaUri = URI.create("https://v3.uat.junson.cloud/jaa3api/scenario/list?ak=9dcc8c47329fe4d658abe101431065e6");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(jaaUri)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JaaResp resp = JsonUtil.reade(response.body(), JaaResp.class);
        log.info("resp is {}",resp);

    }

    @NoArgsConstructor
    @Data
    static class JaaResp {
        private String code;
        private String msg;
        private Collection<Data> data;

        /**
         * 反序列LocalDate需要在mapper中注册javaTimeModel
         */
        @JsonProperty(value = "min_supported_date")
        private LocalDate minSupportedDate;

        @NoArgsConstructor
        @lombok.Data
        static class Data {
            private String scenario;
            @JsonProperty("scenario_cn")
            private String scenarioCn;
            @JsonProperty("default_shock")
            private Shock defaultShock;

            @NoArgsConstructor
            @lombok.Data
            static class Shock {
                @JsonProperty("AI")
                private Double ai;
                @JsonProperty("PI")
                private Double pi;
                @JsonProperty("GRE")
                private Double gre;
            }

        }

    }


}
