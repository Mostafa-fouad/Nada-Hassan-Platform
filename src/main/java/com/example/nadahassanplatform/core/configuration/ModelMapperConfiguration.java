package com.example.nadahassanplatform.core.configuration;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.*;
import java.util.Optional;

@Configuration
public class ModelMapperConfiguration {
  @Bean
  @Primary
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
