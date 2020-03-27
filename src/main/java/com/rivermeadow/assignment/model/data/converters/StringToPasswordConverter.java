package com.rivermeadow.assignment.model.data.converters;

import javax.security.enterprise.credential.Password;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPasswordConverter implements Converter<String, Password> {

	@Override
	public Password convert(String source) {
		return new Password(source);
	}

}