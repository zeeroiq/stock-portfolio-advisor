package com.shri.spring.stock.advisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing
public class StockAdvisorApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockAdvisorApplication.class, args);
    }

}
