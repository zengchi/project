package com.iskyshop.foundation.dao;

import org.springframework.stereotype.Repository;
import com.iskyshop.core.base.GenericDAO;
import com.iskyshop.foundation.domain.UserConfig;

@Repository("userConfigDAO")
public class UserConfigDAO extends GenericDAO<UserConfig> {

}