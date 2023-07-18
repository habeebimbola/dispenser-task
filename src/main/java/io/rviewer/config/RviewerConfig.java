package io.rviewer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Configuration
public class RviewerConfig {

    @Bean
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate = new  RestTemplateBuilder().errorHandler(defaultResponseErrorHandler()). build();
        return restTemplate;
    }

    private DefaultResponseErrorHandler defaultResponseErrorHandler()
    {
        return new DefaultResponseErrorHandler(){
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                super.handleError(response);
            }
        };
    }
}
