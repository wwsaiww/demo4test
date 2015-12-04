package com.jialin.workattendance.service.impl;

import com.jialin.basic.service.impl.BasicService;
import com.jialin.basic.dao.IBasicDao;
import com.jialin.basic.entity.PageModel;
import com.jialin.workattendance.dao.ITeacherDao;
import com.jialin.workattendance.dao.IWorkattenceDao;
import com.jialin.workattendance.entity.TeacherEntity;
import com.jialin.workattendance.entity.TeacherEntity;
import com.jialin.workattendance.entity.WorkattenceEntity;
import com.jialin.workattendance.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author : 贾琳(shan9liang@163.com)
 * @Group : tgb
 * @Date : 2014-5-27 15:08:57
 * @Description :教师管理
 */
public class TeacherServiceImpl extends BasicService<TeacherEntity,String> implements ITeacherService {

    private ITeacherDao teacherDao;

    @Override
    @Autowired
    @Qualifier("teacherDao")    //搜索Qualifier，参考百度百科，就明白这里的意思了
    public void setBaseDao(IBasicDao<TeacherEntity, String> teacherDao) {
        this.baseDao = teacherDao;
        this.teacherDao = (ITeacherDao) teacherDao;
    }

    @Resource
    private IWorkattenceDao workattenceDao;

    public void setWorkattenceDao(IWorkattenceDao workattenceDao) {
        this.workattenceDao = workattenceDao;
    }


    @Override
    public TeacherEntity checkTeacher(TeacherEntity teacherEntity) {
        LinkedHashMap<Object, Object> equalFields =new  LinkedHashMap<Object, Object>();
        equalFields.put("name",teacherEntity.getName());
        equalFields.put("state","是");
        equalFields.put("password", teacherEntity.getPassword());
        return teacherDao.get(equalFields,null,null,null,null);
    }

    @Override
    public TeacherEntity getTeacher(TeacherEntity teacherEntity) {
        LinkedHashMap<Object, Object> equalFields =new  LinkedHashMap<Object, Object>();
        equalFields.put("code",teacherEntity.getCode());
        equalFields.put("state","是");
        return teacherDao.get(equalFields,null,null,null,null);
    }

    @Override
    public void deletePersonAndWorkattenceByArray(String[] ids)
    {
        for(int i=0;i<ids.length;i++)
        {
            this.deletePersonAndWorkattenceById(ids[i]);
        }
    }

    @Override
    public void deletePersonAndWorkattenceById(String id) {
        TeacherEntity teacherEntity= teacherDao.get(id);

        List<WorkattenceEntity> workattenceEntityList=(List<WorkattenceEntity>)teacherEntity.getWorkattencesById();
        if(workattenceEntityList!=null && workattenceEntityList.size()>0)
        {
            String[] ids=new String[workattenceEntityList.size()];
            for(int i=0;i<workattenceEntityList.size();i++)
            {
                ids[i]=workattenceEntityList.get(i).getId();
            }

            workattenceDao.deleteArray(ids);
        }

        teacherDao.deleteObject(teacherEntity);
    }
    
    

    @Override
    public PageModel<TeacherEntity> queryTeachers(TeacherEntity teacherEntity,PageModel<TeacherEntity> pageModel,String dateBegin,String dateEnd) {
        // 初始化Like查询条件承载体
        LinkedHashMap<String, String> likeFields = null;
        // 初始化Like查询条件
        if (teacherEntity != null) {
            likeFields = new LinkedHashMap<String, String>();
            if (teacherEntity.getCode() != null && !"".equals(teacherEntity.getCode())) {
                // 卡号
                likeFields.put("code", teacherEntity.getCode());
            }

            if (teacherEntity.getName() != null && !"".equals(teacherEntity.getName())) {
                // 用户名称
                likeFields.put("name", teacherEntity.getName());
            }

            if (teacherEntity.getSchool() != null && !"".equals(teacherEntity.getSchool())) {
                //学校
                likeFields.put("school", teacherEntity.getSchool());
            }

            if (teacherEntity.getState() != null && !"".equals(teacherEntity.getState())) {
                //是否在职
                likeFields.put("state", teacherEntity.getState());
            }

        }


        String whereHql=null;

        if((dateBegin!=null && !"".equals(dateBegin)) && (dateEnd!=null && !"".equals(dateEnd)))
        {
            whereHql="where cast(o.registtime as date) >= cast('"+dateBegin+"' as date) and  cast(o.registtime as date) <= cast('"+dateEnd+"' as date)";
        }


        LinkedHashMap<String, String> orderByFields =new  LinkedHashMap<String, String>();
        orderByFields.put("code", "DESC");
        return teacherDao.queryPageModel(null,null,likeFields,null,orderByFields,whereHql,pageModel);
    }



    @Override
    public List<TeacherEntity> findTeacherList(TeacherEntity teacherEntity,String dateBegin,String dateEnd) {
        // 初始化Like查询条件承载体
        LinkedHashMap<String, String> likeFields = null;
        // 初始化Like查询条件
        if (teacherEntity != null) {
            likeFields = new LinkedHashMap<String, String>();
            if (teacherEntity.getCode() != null && !"".equals(teacherEntity.getCode())) {
                // 卡号
                likeFields.put("code", teacherEntity.getCode());
            }

            if (teacherEntity.getName() != null && !"".equals(teacherEntity.getName())) {
                // 用户名称
                likeFields.put("name", teacherEntity.getName());
            }

            if (teacherEntity.getSchool() != null && !"".equals(teacherEntity.getSchool())) {
                //学校
                likeFields.put("school", teacherEntity.getSchool());
            }

            if (teacherEntity.getState() != null && !"".equals(teacherEntity.getState())) {
                //是否在职
                likeFields.put("state", teacherEntity.getState());
            }

        }


        String whereHql=null;

        if((dateBegin!=null && !"".equals(dateBegin)) && (dateEnd!=null && !"".equals(dateEnd)))
        {
            whereHql="where cast(o.registtime as date) >= cast('"+dateBegin+"' as date) and  cast(o.registtime as date) <= cast('"+dateEnd+"' as date)";
        }


        LinkedHashMap<String, String> orderByFields =new  LinkedHashMap<String, String>();
        orderByFields.put("code", "DESC");
        return teacherDao.findResultList(null,null,likeFields,null,orderByFields,whereHql);
    }


}
