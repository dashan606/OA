package com.bf.base;

import java.io.Serializable;
import java.util.Collection;


public interface BaseDao {

	public void save(Object obj);

	public void save(Object[] objs);

	public <T> void save(Collection<T> objs);

	public <T> void remove(Class<T> entityClass,Serializable id);

	public void remove(Object[] ids);
	
	public <T> void remove(Collection<T> objects);

	public void update(Object obj);

	public void update(Object[] objs);

	public <T> void update(Collection<T> objs);

	public void saveOrUpdate(Object obj);

	public void saveOrUpdate(Object[] objs);
	
	public <T> void saveOrUpdate(Collection<T> objs); 

	public <T> void deleteByLogic(Class<T> entity,Serializable[] ids,String id,String flag);
	
	
	
	
}
