package com.jialin.user;

import com.jialin.user.dao.impl.UserDaoImpHibernateTest;
import com.jialin.user.service.impl.UserServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @Author : JiaLin
 * @Group : TGB
 * @Date : 2014/5/25
 * @Description :
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({UserDaoImpHibernateTest.class, UserServiceImplTest.class})
//@RunWith(Suite.class)集合测试
//@SuiteClasses( { AccountDaoTest.class })集合，包括AccountDaoTest类，多个测试类可使用逗号分隔！
//        这个测试类可用于Dao层集合测试，与Spring无关！
public class UserAllTests {

}
