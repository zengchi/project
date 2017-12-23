package com.iskyshop.foundation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.iskyshop.core.query.support.IPageList;
import com.iskyshop.core.query.support.IQueryObject;
import com.iskyshop.foundation.domain.ShipAddress;

public interface IShipAddressService {
	/**
	 * 保存一个ShipAddress，如果保存成功返回true，否则返回false
	 * 
	 * @param instance
	 * @return 是否保存成功
	 */
	boolean save(ShipAddress instance);
	
	/**
	 * 根据一个ID得到ShipAddress
	 * 
	 * @param id
	 * @return
	 */
	ShipAddress getObjById(Long id);
	
	/**
	 * 删除一个ShipAddress
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Long id);
	
	/**
	 * 批量删除ShipAddress
	 * 
	 * @param ids
	 * @return
	 */
	boolean batchDelete(List<Serializable> ids);
	
	/**
	 * 通过一个查询对象得到ShipAddress
	 * 
	 * @param properties
	 * @return
	 */
	IPageList list(IQueryObject properties);
	
	/**
	 * 更新一个ShipAddress
	 * 
	 * @param id
	 *            需要更新的ShipAddress的id
	 * @param dir
	 *            需要更新的ShipAddress
	 */
	boolean update(ShipAddress instance);
	/**
	 * 
	 * @param query
	 * @param params
	 * @param begin
	 * @param max
	 * @return
	 */
	List<ShipAddress> query(String query, Map params, int begin, int max);
	
	ShipAddress getObjByProperty(String construct, String propertyName, Object value);
}
