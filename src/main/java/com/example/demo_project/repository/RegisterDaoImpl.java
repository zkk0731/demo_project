package com.example.demo_project.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.Register;

//不用實作Dao jpa會自動尋找實作方法
public class RegisterDaoImpl extends BaseDao {
//	沒限制筆數
	public List<Register> doQueryByExpiredRegTime(Date date) {
//		StringBuffer 方便自串串接 可用直接用String相加
		StringBuffer sb = new StringBuffer();
//		sql 語法
		sb.append(" select R from Register R ").append(" where R.regTime > :expiredDate ");
		
		Map<String, Object> params = new HashMap<>();
//		帶值給自訂參數
		params.put("expiredDate", date);

		return doQuery(sb.toString(), params, Register.class);
	}
	
//	有限制筆數
	public List<Register> doQueryByExpiredRegTime(Date date,int pageSize) {
//		StringBuffer 方便自串串接 可用直接用String相加
		StringBuffer sb = new StringBuffer();
//		sql 語法
		sb.append(" select R from Register R ").append(" where R.regTime > :expiredDate ");
		
		Map<String, Object> params = new HashMap<>();
//		帶值給自訂參數
		params.put("expiredDate", date);

		return doQuery(sb.toString(), params, Register.class,pageSize);
	}
	
//	有限制筆數及起始位置
	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize, int startPosition) {
//		StringBuffer 方便自串串接 可用直接用String相加
		StringBuffer sb = new StringBuffer();
//		sql 語法
		sb.append(" select R from Register R ").append(" where R.regTime > :expiredDate ");
		
		Map<String, Object> params = new HashMap<>();
//		帶值給自訂參數
		params.put("expiredDate", date);

		return doQuery(sb.toString(), params, Register.class, pageSize ,startPosition);
	}
	
//	有限制筆數及起始位置 使用sql內名稱輸入
	public List<Register> doNativeQueryByExpiredRegTime(Date date, int pageSize, int startPosition) {
//		StringBuffer 方便自串串接 可用直接用String相加
		StringBuffer sb = new StringBuffer();
//		sql 語法
		sb.append(" select * from register R ").append(" where R.reg_time > :expiredDate ");
		
		Map<String, Object> params = new HashMap<>();
//		帶值給自訂參數
		params.put("expiredDate", date);

		return doNativeQuery(sb.toString(), params, Register.class, pageSize ,startPosition);
	}
	
	public int updateAgeByName(String name,int age) {
		StringBuffer sb = new StringBuffer();
//		sql 語法
		sb.append(" update Register set age = :age ").append(" where name = :name ");
		
		Map<String, Object> params = new HashMap<>();
//		帶值給自訂參數
		params.put("age", age);
		params.put("name", name);
		return doUpdate(sb.toString(), params);
	}
	
	public int updateAgeByAccount(String newAccount,int newAge) {
		StringBuffer sb = new StringBuffer();
//		sql 語法
		sb.append(" update Register set age = :age ").append(" where account = :account ");
		
		Map<String, Object> params = new HashMap<>();
//		帶值給自訂參數
		params.put("age", newAge);
		params.put("account", newAccount);
		return doUpdate(sb.toString(), params);
	}
	
	
	public int nativeUpdateAgeByName(String name,int age) {
		StringBuffer sb = new StringBuffer();
//		sql 語法
		sb.append(" update register set age = :age ").append(" where name = :name ");
		
		Map<String, Object> params = new HashMap<>();
//		帶值給自訂參數
		params.put("age", age);
		params.put("name", name);
		return doNativeUpdate(sb.toString(), params);
	}
	
	public int nativeUpdateAgeByAccount(String account,int age) {
		StringBuffer sb = new StringBuffer();
//		sql 語法
		sb.append(" update register set age = :age ").append(" where account = :account ");
		
		Map<String, Object> params = new HashMap<>();
//		帶值給自訂參數
		params.put("age", age);
		params.put("account", account);
		return doNativeUpdate(sb.toString(), params);
	}
	
	public List<Register> doQueryRoleContains(List<String> roleList){
		StringBuffer sb = new StringBuffer();
		Map<String, Object> params = new HashMap<>();
//		sql 語法
		sb.append(" select * from register r where");
			for(int i = 0;i < roleList.size();i ++) {
				String item = roleList.get(i);
				if(i < roleList.size() - 1) {
//					role like :role0 or like :role1 or like :role2.... 
					sb.append(" role like :role" + i + " or ");
				}else {
//					最後一項不用加or在後面
					sb.append(" role like :role"+ i);
				}
//				帶值給自訂參數
//			Ex:	role0=%SA% , role2=%SD%
				params.put("role" + i,"%" + item +"%");
			}
			return doNativeQuery(sb.toString(), params, Register.class, -1, 0);
		

		
	}
}
