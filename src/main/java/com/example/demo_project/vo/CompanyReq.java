package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyReq {

	@JsonProperty("org_id")
	private String orgId;
	
	@JsonProperty("com_id")
	private String CompanyId;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(String companyId) {
		CompanyId = companyId;
	}
	
	
}
