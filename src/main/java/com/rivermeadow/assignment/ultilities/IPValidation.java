package com.rivermeadow.assignment.ultilities;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivermeadow.assignment.repository.WorkLoadRepository;

@Service
public final class IPValidation {
	
	@Autowired
	public WorkLoadRepository workLoadRepository;
	
	public static HashSet<String> ipStrings;

	public final void fillStringSet() {
		workLoadRepository.findAll().forEach(wL -> ipStrings.add(wL.getCredentials().getWebAddress()));
	}
	
	public final void validateIp(String ip) {
		if (ipStrings.contains(ip)) {
			throw new IllegalArgumentException();
		}
	}
}
