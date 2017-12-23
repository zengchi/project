package com.iskyshop.foundation.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iskyshop.core.dao.IGenericDAO;
import com.iskyshop.core.query.GenericPageList;
import com.iskyshop.core.query.PageObject;
import com.iskyshop.core.query.support.IPageList;
import com.iskyshop.core.query.support.IQueryObject;
import com.iskyshop.foundation.domain.GoodsInventory;
import com.iskyshop.foundation.domain.GoodsInventoryLog;
import com.iskyshop.foundation.domain.ProductMapping;
import com.iskyshop.foundation.service.IGoodsInventoryLogService;

@Service
@Transactional
public class GoodsInventoryLogServiceImpl implements IGoodsInventoryLogService {

	@Resource(name = "goodsInventoryLogDAO")
	private IGenericDAO<GoodsInventoryLog> goodsInventoryLogDAO;
	@Transactional(readOnly = false)
	public boolean save(GoodsInventoryLog goodsInventoryLog) {
		/**
		 * init other field here
		 */
		try {
			this.goodsInventoryLogDAO.save(goodsInventoryLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional(readOnly = true)
	public List<GoodsInventoryLog> query(String query, Map params, int begin, int max) {
		return this.goodsInventoryLogDAO.query(query, params, begin, max);

	}

	@Transactional(readOnly = true)
	public IPageList list(IQueryObject properties) {
		if (properties == null) {
			return null;
		}
		String query = properties.getQuery();
		String construct = properties.getConstruct();
		Map params = properties.getParameters();
		GenericPageList pList = new GenericPageList(ProductMapping.class, construct,
				query, params, this.goodsInventoryLogDAO);
		if (properties != null) {
			PageObject pageObj = properties.getPageObj();
			if (pageObj != null)
				pList.doList(
						pageObj.getCurrentPage() == null ? 0 : pageObj
								.getCurrentPage(),
						pageObj.getPageSize() == null ? 0 : pageObj
								.getPageSize());
		} else
			pList.doList(0, -1);
		return pList;
	}
	
	@Transactional(readOnly = true)
	public GoodsInventoryLog getObjById(Long id) {
		GoodsInventoryLog goodsInventoryLog = this.goodsInventoryLogDAO.get(id);
		if (goodsInventoryLog != null) {
			return goodsInventoryLog;
		}
		return null;
	}
	
	@Transactional(readOnly = false)
	public boolean update(GoodsInventoryLog goodsInventoryLog) {
		try {
			this.goodsInventoryLogDAO.update(goodsInventoryLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional(readOnly = false)
	public boolean delete(Long id) {
		try {
			this.goodsInventoryLogDAO.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> ids) {
		for (Serializable id : ids) {
			delete((Long) id);
		}
		return true;
	}

}
