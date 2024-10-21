package com.organization.provider.model.remote;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Company;

public class CompanyRemote {
	
	private Long id;
	private String name;
	
    public CompanyRemote() {}

	public CompanyRemote(Company company) {
		BeanUtils.copyProperties(company, this);
	}
    
	public static CompanyRemote convert(Company company) {
    	if(company ==null) {
    		return new CompanyRemote();
    	}
    	if(company instanceof CompanyRemote) {
    		return (CompanyRemote) company;
    	} else {
    		return new CompanyRemote(company); 
    	}
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}