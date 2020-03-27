package com.rivermeadow.assignment.ultilities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivermeadow.assignment.repository.WorkLoadRepository;
import com.rivermeadow.assignment.ultilities.UniqueIP;

@Service
class UniqueIPValidator implements ConstraintValidator<UniqueIP, String> {
	 
	@Autowired
    private WorkLoadRepository workLoadRepository;
 
    public UniqueIPValidator(WorkLoadRepository workLoadRepository) {
        this.workLoadRepository = workLoadRepository;
    }
 
    public void initialize(UniqueIP constraint) {
    }
 
	@Override
    public boolean isValid(String ip, ConstraintValidatorContext context) {
        if (!(ip != null && workLoadRepository.findAll().stream().noneMatch(
        		wl -> wl.getCredentials().getWebAddress().equals(ip)))){
        	throw new ValidationException("work load ip is duplicated");
            
        }
        return true;
    }
 
}