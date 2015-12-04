package com.jialin.workattendance.service;

import com.jialin.basic.service.IBasicService;
import com.jialin.basic.entity.PageModel;
import com.jialin.workattendance.entity.StudentEntity;
import java.util.List;

/**
 * @Author : 贾琳(shan9liang@163.com)
 * @Group : tgb
 * @Date : 2014-5-27 15:08:57
 * @Description :学生管理
 */
public interface IStudentService extends IBasicService<StudentEntity,String>{

    public StudentEntity checkStudent(StudentEntity studentEntity);
    public StudentEntity getStudent(StudentEntity studentEntity);
    public void deletePersonAndWorkattenceById(String id);
    public void deletePersonAndWorkattenceByArray(String id[]);
    public PageModel<StudentEntity> queryStudents(StudentEntity studentEntity, PageModel<StudentEntity> pageModel,String dateBegin,String dateEnd);
    public List<StudentEntity> findStudentList(StudentEntity studentEntity,String dateBegin,String dateEnd);

}
