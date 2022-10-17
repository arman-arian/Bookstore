package com.tosan.bookstore.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

@Configuration
public class MapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
