package com.rivermeadow.assignment.model.data.factory;

import javax.security.enterprise.credential.Password;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class PasswordFactory extends AbstractFactoryBean<Object>{

	@Override
	public Class<?> getObjectType() {
		return Password.class;
	}

	@Override
	protected Object createInstance() throws Exception {
		return new Password("dummy");
	}

	
}
