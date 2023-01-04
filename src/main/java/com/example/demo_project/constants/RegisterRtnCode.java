package com.example.demo_project.constants;
//¦CÁ|
public enum RegisterRtnCode {

	SUCCESSFUL("200","success"),			//³r¸¹¹j¶}
	ACCOUNT_REQUIRED("400","Account can't be empty"),
	PWD_REQUIRED("400","Pwd can't be empty"),
	NAME_REQUIRED("400","Name can't be empty"),
	ACCOUNT_EXISTED("403","Account is existed"),
	ACTIVE_FAIL("500","Account active fail"),
	ADD_ROLE_FAILURE("500","Add role fail");
	
	
	private String code;
	
	private String message;
	
	private RegisterRtnCode(String code,String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	
	
	
}
