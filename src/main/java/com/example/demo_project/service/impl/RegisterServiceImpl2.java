package com.example.demo_project.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo_project.annotation.ConditionalOnB;
import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.RegisterResp;

@ConditionalOnB
@EnableScheduling
@Service
public class RegisterServiceImpl2 implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public Register register(String account, String pwd, String name, int age, String city) {
		if (registerDao.findById(account).isPresent()) {
			return null;
		}
		Register register = new Register(account, pwd, name, age, city);
		register.setRegTime(new Date());
//		register.setActive(false);	//boolean �w�]false
		register.setRole("General");
		return registerDao.save(register);
	}

	@Override
	public RegisterResp activeAccount(String account) {
		RegisterResp resp = new RegisterResp();
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Register reg = regOp.get();
			reg.setActive(true);
			registerDao.save(reg);
			resp.setMessage(RegisterRtnCode.SUCCESSFUL.getMessage());
			return resp;
		}
		resp.setMessage(RegisterRtnCode.ACTIVE_FAIL.getMessage());
		return resp;
	}

	@Override
	public RegisterResp addRole(String account, List<String> roleList) {
		RegisterResp resp = new RegisterResp();
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Set<String> roleSet = new HashSet<>(); // �h������
			for (String item : roleList) {
				roleSet.add(item);
			}
			// �h��DB���w�s�b���ȩM�Ѽƪ��ȡA��̭��ƪ�����
			Register reg = regOp.get();
			String role = reg.getRole();
			if (!role.isEmpty()) {
				String[] roleArray = role.split(","); // �γr���Ӥ���role����
				for (int i = 0; i < roleArray.length; i++) {
					String str = roleArray[i].trim(); // �h�e��ť�
					roleSet.add(str); // ��DB��role��iSet
				}
			}
			reg.setRole(roleSet.toString().substring(1, roleSet.toString().length() - 1));
			// Set�নString��ȵ�role //�h�e�ᤤ�A��,substring(�_�lindex(���]�t),����index(�S�]�t))
			registerDao.save(reg);
			resp.setMessage(RegisterRtnCode.SUCCESSFUL.getMessage());
			return resp;
		}

		resp.setMessage(RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
		return resp;
	}

	@Override
	public Register findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Register> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Scheduled(fixedRateString = "${heartbeat.ms}")
//	public void schedulePrintDate() {
//		System.out.println("==================");
//		System.out.println(new Date());
//	}
	
//	@Scheduled(cron = "0 0 10 * * ?")
//	public void schedule0() {
//		System.out.println(new Date());
//	}
//	
//	@Scheduled(cron = "0 * 14-16 * * ?")
//	public void schedule1() {
//		System.out.println(new Date());
//	}
}
