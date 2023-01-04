package com.example.demo_project.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.ActiveAccountReq;
import com.example.demo_project.vo.LoginInfo;
import com.example.demo_project.vo.RegisterReq;
import com.example.demo_project.vo.RegisterResp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.Session;

@RestController
public class RegisterController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RegisterService registerService;
	
	private RegisterResp checkParam(RegisterReq req) {
		RegisterResp resp = new RegisterResp();
		if(!StringUtils.hasText(req.getAccount())) {
			resp.setMessage(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
			return resp;
		}
		if(!StringUtils.hasText(req.getPwd())) {
			resp.setMessage(RegisterRtnCode.PWD_REQUIRED.getMessage());
			return resp;
		}
		if(!StringUtils.hasText(req.getName())) {
			resp.setMessage(RegisterRtnCode.NAME_REQUIRED.getMessage());
			return resp;
		}
		return null;
	}
	
	@PostMapping(value = "/api/register")
	public RegisterResp register(@RequestBody RegisterReq req, HttpSession session) {
		RegisterResp resp = new RegisterResp();
		RegisterResp check = checkParam(req);
		if(check != null) {
			return check;
		}
		Register reg = registerService.register(req.getAccount(), req.getPwd(), 
				req.getName(), req.getAge(), req.getCity());
		if(reg == null) {
			resp.setMessage(RegisterRtnCode.ACCOUNT_EXISTED.getMessage());
			return resp;
		}
		
		int verifyCode = (int) (Math.random()*(9999 - 1000 + 1) + 1000);
		session.setAttribute("verifyCode", verifyCode);
		session.setAttribute("account", req.getAccount());
		resp = new RegisterResp(reg,RegisterRtnCode.SUCCESSFUL.getMessage(),verifyCode);
		
		return resp;
	}
	
	@PostMapping(value = "/api/active_account")
	public RegisterResp activeAccount(@RequestBody RegisterReq req) {
		RegisterResp resp = new RegisterResp();
		if(!StringUtils.hasText(req.getAccount())) {
			resp.setMessage(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
			return resp;
		}
		
		return registerService.activeAccount(req.getAccount());
	}
	
	@PostMapping(value = "/api/add_role")
	public RegisterResp addRole(@RequestBody RegisterReq req) {
		RegisterResp resp = new RegisterResp();
		if(!StringUtils.hasText(req.getAccount())) {
			resp.setMessage(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
			return resp;
		}
		return registerService.addRole(req.getAccount(), req.getRoleList());
	}
	
	@PostMapping(value = "/api/log_in")
	public RegisterResp logIn(@RequestBody LoginInfo loginInfo, HttpSession session) {
		RegisterResp resp = new RegisterResp();
		
		if(!StringUtils.hasText(loginInfo.getAccount()) || !StringUtils.hasText(loginInfo.getPwd())) {
			resp.setMessage("Parameter is error");
			return resp;
		}
		
		Register result = registerService.findById(loginInfo.getAccount());
		
		if(result == null) {
			resp.setMessage("User not found");
			return resp;
		}
		session.setAttribute("accountInfo", result);
//		session.setMaxInactiveInterval(30);
		resp.setMessage("login success");
		return resp;
		
	}
	
	@PostMapping(value = "/api/get_user_info")
	public RegisterResp getLogInInfo(HttpSession session) {
		RegisterResp resp = new RegisterResp();
		if(session.getAttribute("accountInfo") == null) {
			resp.setMessage("not log in");
			return resp;
		}
		Register register = (Register) session.getAttribute("accountInfo");
		Register result = registerService.findById(register.getAccount());
		resp.setMessage("account name: " + result.getAccount());
		
		return resp;
		
	}
	
	@PostMapping(value = "/api/log_out")
	public RegisterResp logOut(HttpSession session, SessionStatus sessionStatus) {
		RegisterResp resp = new RegisterResp();
		if(session.getAttribute("account") != null) {
			session.removeAttribute("account");
			sessionStatus.setComplete();
		}
		resp.setMessage("log out");
		
		return resp;
	}
	
	@PostMapping(value = "/api/active_account2")
	public RegisterResp activeAccount2(@RequestBody ActiveAccountReq req, HttpSession session) {
		RegisterResp resp = new RegisterResp();
//		if(session.getAttribute("account") == null) {
//			resp.setMessage("user not login");
//			return resp;
//		}
		if(session.getAttribute("verifyCode") == null) {
			resp.setMessage("verify code not exist");
			return resp;
		}
		
		if(session.getAttribute("account") == null) {
			resp.setMessage("not log in");
			return resp;
		}
		
		int code = (int) session.getAttribute("verifyCode");
		if(code == req.getVerifyCode()) {
			registerService.activeAccount(session.getAttribute("account").toString());
			resp.setMessage("active success");
			return resp;
		}
		resp.setMessage("verify code error");
		return resp;
	}
		
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/api/sessionSetMap")
	public Map<String,Integer> setMap(HttpSession session) {
		Map<String,Integer> map = new HashMap<>();
		map.put("Abc", 1);
		
		session.setAttribute("map", map);
		Object result = session.getAttribute("map");
		ObjectMapper oMapper = new ObjectMapper();
		Map<String,Integer> map2 = oMapper.convertValue(result, Map.class);
		
		return map2;
		
	}
}
