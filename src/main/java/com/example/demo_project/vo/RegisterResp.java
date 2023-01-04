package com.example.demo_project.vo;

import com.example.demo_project.entity.Register;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RegisterResp {

	@JsonProperty("register_info")
	private Register register;
	
	private String message;
	
	@JsonProperty("verify_code")
	private int verifyCode;

	public RegisterResp() {
		
	}
	
	public RegisterResp(Register register, String message, int verifyCode) {
		this.register = register;
		this.message = message;
		this.verifyCode = verifyCode;
	}
	public RegisterResp(Register register) {
		this.register = register;
	}
	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}

	
	
	
}
