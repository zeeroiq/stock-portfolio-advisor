package com.shri.spring.stock.advisor.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Getter
@Configuration
public class FMGApiConfig {

    @Value("${fmg.api.v3.endpoint}")
    private String FMG_API_URL;

    @Value("${fmg.api.key}")
    private String fmgApiKey;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(FMG_API_URL)
                .build();
    }

}
