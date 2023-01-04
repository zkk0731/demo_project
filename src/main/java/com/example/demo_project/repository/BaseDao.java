package com.example.demo_project.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.util.CollectionUtils;

public class BaseDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
//	EX: @Param("newName") String newName 的"newName" 及 String newName 分別放入 Map裡  
	//無限制返回筆數
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz) {
		Query query = entityManager.createQuery(sql, clazz);

		if (!CollectionUtils.isEmpty(params)) {
//			原本用entrySet遍歷取值
//			for(Entry<String, Object> item:params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
//	兩種for都可以					
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		return query.getResultList();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
//	EX: @Param("newName") String newName 的"newName" 及 String newName 分別放入 Map裡  
	//限制返回筆數
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz, int pageSize) {
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
//			原本用entrySet遍歷取值
//			for(Entry<String, Object> item:params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
//	兩種for都可以					
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		
		if(pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		
		return query.getResultList();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
//	EX: @Param("newName") String newName 的"newName" 及 String newName 分別放入 Map裡  
	//限制返回筆數及起始位置
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz
			, int pageSize, int startPosition) {
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
//			原本用entrySet遍歷取值
//			for(Entry<String, Object> item:params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
//	兩種for都可以					
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		
		if(pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		
		if(startPosition >= 0) {
			query.setFirstResult(startPosition);
		}
		
		return query.getResultList();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
//	EX: @Param("newName") String newName 的"newName" 及 String newName 分別放入 Map裡  
	//限制返回筆數及起始位置
//	使用sql內名稱的query
	protected <EntityType> List<EntityType> doNativeQuery(String nativeSql, Map<String, Object> params, Class<EntityType> clazz
			, int pageSize, int startPosition) {
//		class 可為空
		Query query = null;

		if(clazz == null) {
			query = entityManager.createNativeQuery(nativeSql);
		}else {
			query = entityManager.createNativeQuery(nativeSql,clazz);
		}
		
		if (!CollectionUtils.isEmpty(params)) {
//			原本用entrySet遍歷取值
//			for(Entry<String, Object> item:params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
//	兩種for都可以					
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		
		if(pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		
		if(startPosition >= 0) {
			query.setFirstResult(startPosition);
		}
		
		return query.getResultList();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doUpdate(String sql, Map<String, Object> params){
		Query query = entityManager.createQuery(sql);
		
		if (!CollectionUtils.isEmpty(params)) {				
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		
		return query.executeUpdate();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doNativeUpdate(String nativeSql, Map<String, Object> params){
		Query query = entityManager.createNativeQuery(nativeSql);
		
		if (!CollectionUtils.isEmpty(params)) {				
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		
		return query.executeUpdate();
	}
}
