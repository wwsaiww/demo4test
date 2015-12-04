package com.jialin.user.dao.impl;

import com.jialin.basic.dao.impl.HibernateBasicDao;
import com.jialin.user.dao.IUserDao;

import com.jialin.user.entity.UserEntity;

public class UserDaoImpHibernate extends HibernateBasicDao<UserEntity,String> implements IUserDao {


}
