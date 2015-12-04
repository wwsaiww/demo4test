package com.jialin.workattendance.service;

import com.jialin.basic.entity.PageModel;
import com.jialin.basic.service.IBasicService;
import com.jialin.workattendance.entity.WorkattenceEntity;

import java.util.List;

/**
 * @Author : 贾琳(shan9liang@163.com)
 * @Group : tgb
 * @Date : 2014-5-28 19:16:55
 * @Description :考勤记录管理
 */
public interface IMainWorkattenceService extends IBasicService<WorkattenceEntity,String>{

    public WorkattenceEntity getWorkattence(WorkattenceEntity workattenceEntity);

    public PageModel<WorkattenceEntity> queryWorkattences(WorkattenceEntity workattenceEntity, PageModel<WorkattenceEntity> pageModel, String dateBegin, String dateEnd,String type);

    public PageModel<WorkattenceEntity> queryWorkattencesPage(String code,PageModel<WorkattenceEntity> pageModel,String dateNow,String type) ;

    public WorkattenceEntity queryWorkattencesList(WorkattenceEntity workattenceEntity, String dateNow, String type) ;

}
