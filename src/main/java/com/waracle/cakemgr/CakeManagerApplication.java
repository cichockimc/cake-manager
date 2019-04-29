package com.waracle.cakemgr;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class CakeManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CakeManagerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
        RestTemplate template = builder.build();
        template.getMessageConverters().add(converter);
        return template;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
