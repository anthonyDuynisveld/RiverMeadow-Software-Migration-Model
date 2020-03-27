package com.rivermeadow.assignment.ultilities.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rivermeadow.assignment.model.data.converters.StringToPasswordConverter;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToPasswordConverter());
	}

}
