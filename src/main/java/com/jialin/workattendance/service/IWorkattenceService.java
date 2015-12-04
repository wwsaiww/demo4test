package com.jialin.workattendance.service;

import com.jialin.basic.service.IBasicService;
import com.jialin.basic.entity.PageModel;
import com.jialin.workattendance.entity.WorkattenceEntity;

import java.util.List;

/**
 * @Author : 贾琳(shan9liang@163.com)
 * @Group : tgb
 * @Date : 2014-5-28 19:16:55
 * @Description :考勤记录管理
 */
public interface IWorkattenceService extends IBasicService<WorkattenceEntity,String>{

    public WorkattenceEntity getWorkattence(WorkattenceEntity workattenceEntity);
    public PageModel<WorkattenceEntity> queryStudentWorkattences(WorkattenceEntity workattenceEntity,PageModel<WorkattenceEntity> pageModel,String dateBegin,String dateEnd);
    public List<WorkattenceEntity> findTeacherWorkattences(WorkattenceEntity workattenceEntity,String dateBegin,String dateEnd);
    public List<WorkattenceEntity> findStudentWorkattences(WorkattenceEntity workattenceEntity,String dateBegin,String dateEnd);
    public PageModel<WorkattenceEntity> queryTeacherWorkattences(WorkattenceEntity workattenceEntity, PageModel<WorkattenceEntity> pageModel,String dateBegin,String dateEnd);
}
