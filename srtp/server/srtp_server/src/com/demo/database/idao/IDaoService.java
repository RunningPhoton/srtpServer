package com.demo.database.idao;

import java.util.List;

/**
 * 数据库访问公共接口
 * @author RunningPhoton
 * 
 */
public interface IDaoService {

	/**
	 * 查询数据
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public List<? extends Object> query(String hql) throws Exception;
	
	/**
	 * 保存数据
	 * @param object
	 * @throws Exception
	 */
	public void save(Object object) throws Exception;
	
	/**
	 * 修改数据
	 * @param object
	 * @throws Exception
	 */
	public void update(Object object) throws Exception;
	
	/**
	 * 删除数据
	 * @param id
	 * @throws Exception
	 */
	public void delete(Object...objects) throws Exception;
	
}
