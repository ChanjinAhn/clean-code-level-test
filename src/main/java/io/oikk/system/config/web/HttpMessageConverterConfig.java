package io.oikk.system.config.web;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class HttpMessageConverterConfig extends WebMvcConfigurationSupport {

    @Bean
    public HttpMessageConverter<?> htmlEscapingConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        MappingJackson2HttpMessageConverter htmlEscapingConverter =
            new MappingJackson2HttpMessageConverter();
        htmlEscapingConverter.setObjectMapper(objectMapper);

        return htmlEscapingConverter;
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(htmlEscapingConverter());
        super.addDefaultHttpMessageConverters(converters);  // default Http Message Converter  추가
    }
}