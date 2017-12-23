package com.iskyshop.foundation.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import com.iskyshop.core.query.PageObject;
import com.iskyshop.core.query.support.IPageList;
import com.iskyshop.core.query.support.IQueryObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.iskyshop.core.dao.IGenericDAO;
import com.iskyshop.core.query.GenericPageList;
import com.iskyshop.foundation.domain.WaterMark;
import com.iskyshop.foundation.service.IWaterMarkService;

@Service
@Transactional
public class WaterMarkServiceImpl implements IWaterMarkService {
	@Resource(name = "waterMarkDAO")
	private IGenericDAO<WaterMark> waterMarkDao;
	@Transactional(readOnly = false)
	public boolean save(WaterMark waterMark) {
		/**
		 * init other field here
		 */
		try {
			this.waterMarkDao.save(waterMark);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional(readOnly = true)
	public WaterMark getObjById(Long id) {
		WaterMark waterMark = this.waterMarkDao.get(id);
		if (waterMark != null) {
			return waterMark;
		}
		return null;
	}
	@Transactional(readOnly = false)
	public boolean delete(Long id) {
		try {
			this.waterMarkDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional(readOnly = false)
	public boolean batchDelete(List<Serializable> waterMarkIds) {
		// TODO Auto-generated method stub
		for (Serializable id : waterMarkIds) {
			delete((Long) id);
		}
		return true;
	}
	@Transactional(readOnly = true)
	public IPageList list(IQueryObject properties) {
		if (properties == null) {
			return null;
		}
		String query = properties.getQuery();
		String construct = properties.getConstruct();
		Map params = properties.getParameters();
		GenericPageList pList = new GenericPageList(WaterMark.class,construct,  query,
				params, this.waterMarkDao);
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
	@Transactional(readOnly = false)
	public boolean update(WaterMark waterMark) {
		try {
			this.waterMarkDao.update(waterMark);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional(readOnly = true)
	public List<WaterMark> query(String query, Map params, int begin, int max) {
		return this.waterMarkDao.query(query, params, begin, max);

	}

	@Override
	@Transactional(readOnly = true)
	public WaterMark getObjByProperty(String construct, String propertyName,
			Object value) {
		// TODO Auto-generated method stub
		return this.waterMarkDao.getBy(construct, propertyName, value);
	}
}
