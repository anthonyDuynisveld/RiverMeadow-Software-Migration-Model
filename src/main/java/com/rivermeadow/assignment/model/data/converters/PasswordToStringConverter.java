package com.rivermeadow.assignment.model.data.converters;

import javax.security.enterprise.credential.Password;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PasswordToStringConverter implements Converter<Password, String> {

	@Override
	public String convert(Password source) {
		return source.getValue().toString();
	}

}