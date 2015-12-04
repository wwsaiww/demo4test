package com.jialin.workattendance.service;

import com.jialin.basic.service.IBasicService;
import com.jialin.basic.entity.PageModel;
import com.jialin.workattendance.entity.TeacherEntity;

import java.util.List;

/**
 * @Author : 贾琳(shan9liang@163.com)
 * @Group : tgb
 * @Date : 2014-5-27 15:08:57
 * @Description :教师管理
 */
public interface ITeacherService extends IBasicService<TeacherEntity,String>{
    public TeacherEntity checkTeacher(TeacherEntity teacherEntity);
    public TeacherEntity getTeacher(TeacherEntity teacherEntity);
    public void deletePersonAndWorkattenceByArray(String[] ids);
    public void deletePersonAndWorkattenceById(String id);
    public PageModel<TeacherEntity> queryTeachers(TeacherEntity teacherEntity, PageModel<TeacherEntity> pageModel,String dateBegin,String dateEnd);
    public List<TeacherEntity> findTeacherList(TeacherEntity teacherEntity,String dateBegin,String dateEnd);
}
