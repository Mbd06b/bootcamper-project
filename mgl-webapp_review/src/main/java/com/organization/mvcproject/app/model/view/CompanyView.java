package com.organization.mvcproject.app.model.view;

import org.springframework.beans.BeanUtils;

import com.organization.mvcproject.api.model.Company;

public class CompanyView {
	
	private Long id;
	private String name;
	
    public CompanyView() {}

	public CompanyView(Company company) {
		BeanUtils.copyProperties(company, this);
	}
    
	public static CompanyView convert(Company company) {
    	if(company ==null) {
    		return new CompanyView();
    	}
    	if(company instanceof CompanyView) {
    		return (CompanyView) company;
    	} else {
    		return new CompanyView(company); 
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