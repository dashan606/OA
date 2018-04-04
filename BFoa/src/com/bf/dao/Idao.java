package com.bf.dao;

import java.io.Serializable;

public interface Idao {

	public void save(Object obj);

	public <T> void remove(Class<T> entityClass,Serializable id);

	public void remove(Object obj);
 
	public void update(Object obj);

	public void saveOrUpdate(Object entity);
   
	public <T> void deleteByLogic(Class<T> entity,Serializable[] ids,String id,String flag);
}
