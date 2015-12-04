package com.jialin.user.service;

import com.jialin.basic.service.IBasicService;
import com.jialin.basic.entity.PageModel;
import com.jialin.user.entity.UserEntity;

public interface IUserService extends IBasicService<UserEntity,String>{

    public UserEntity getUser(UserEntity userEntity);

    public PageModel<UserEntity> queryUsers(UserEntity userEntity,PageModel<UserEntity> pageModel);
}
