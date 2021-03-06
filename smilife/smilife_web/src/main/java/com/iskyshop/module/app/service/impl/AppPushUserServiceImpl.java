package com.iskyshop.module.app.service.impl;
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
import com.iskyshop.module.app.domain.AppPushUser;
import com.iskyshop.module.app.service.IAppPushUserService;

@Service
@Transactional
public class AppPushUserServiceImpl implements IAppPushUserService{
	@Resource(name = "appPushUserDAO")
	private IGenericDAO<AppPushUser> appPushUserDao;
	@Transactional(readOnly = false)
	public boolean save(AppPushUser appPushUser) {
		/**
		 * init other field here
		 */
		try {
			this.appPushUserDao.save(appPushUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional(readOnly = true)
	public AppPushUser getObjById(Long id) {
		AppPushUser appPushUser = this.appPushUserDao.get(id);
		if (appPushUser != null) {
			return appPushUser;
		}
		return null;
	}
	@Transactional(readOnly = false)
	public boolean delete(Long id) {
		try {
			this.appPushUserDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional(readOnly = false)
	public boolean batchDelete(List<Serializable> appPushUserIds) {
		// TODO Auto-generated method stub
		for (Serializable id : appPushUserIds) {
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
		GenericPageList pList = new GenericPageList(AppPushUser.class, construct,query,
				params, this.appPushUserDao);
		if (properties != null) {
			PageObject pageObj = properties.getPageObj();
			if (pageObj != null)
				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
						.getCurrentPage(), pageObj.getPageSize() == null ? 0
						: pageObj.getPageSize());
		} else
			pList.doList(0, -1);
		return pList;
	}
	@Transactional(readOnly = false)
	public boolean update(AppPushUser appPushUser) {
		try {
			this.appPushUserDao.update( appPushUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	@Transactional(readOnly = true)
	public List<AppPushUser> query(String query, Map params, int begin, int max){
		return this.appPushUserDao.query(query, params, begin, max);
		
	}
}
