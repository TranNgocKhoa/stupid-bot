package com.khoa.bot.configuation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {
    private final ClientHttpRequestInterceptor messengerClientInterceptor;

    public RestClientConfiguration(@Qualifier("messengerClientInterceptor") ClientHttpRequestInterceptor messengerClientInterceptor) {
        this.messengerClientInterceptor = messengerClientInterceptor;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder, ObjectMapper messengerObjectMapper) {
        return restTemplateBuilder.additionalInterceptors(messengerClientInterceptor)
                .additionalMessageConverters(new MappingJackson2HttpMessageConverter(messengerObjectMapper))
                .build();
    }
}
