package com.jialin.workattendance.action;

import com.jialin.basic.action.BasicAction;
import com.jialin.basic.tool.JsonUtil;
import com.jialin.user.entity.UserEntity;
import com.jialin.workattendance.entity.StudentEntity;
import com.jialin.workattendance.entity.TeacherEntity;
import com.jialin.workattendance.service.IStudentService;
import com.jialin.workattendance.service.ITeacherService;
import javax.annotation.Resource;


/**
 * @Author : JiaLin
 * @Group : TGB
 * @Date : 2014/5/31
 * @Description :
 */
public class LoginForAndroid extends BasicAction{


    public void login() {
        try {

            this.response.setContentType("text/html;charset=utf-8");
            this.response.setCharacterEncoding("UTF-8");
            String jsonUser=null;
            System.out.println("来自手机");
            TeacherEntity teacher=new TeacherEntity();
            teacher.setName(userEntity.getName());
            teacher.setPassword(userEntity.getPassword());

            TeacherEntity teacherResutl=teacherService.checkTeacher(teacher);

            if(teacherResutl!=null){
                teacherResutl.setWorkattencesById(null);
                teacherResutl.setOther1("T");
                jsonUser=JsonUtil.toJson(teacherResutl);
            }

            if(jsonUser==null)
            {
                StudentEntity student=new StudentEntity();
                student.setName(userEntity.getName());
                student.setPassword(userEntity.getPassword());

                StudentEntity studentResult=studentService.checkStudent(student);

                if(studentResult!=null){
                    studentResult.setWorkattencesById(null);
                    studentResult.setOther1("S");
                    jsonUser=JsonUtil.toJson(studentResult);
                }

            }

            response.getWriter().write(jsonUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Resource
    private ITeacherService teacherService;
    public void setTeacherService(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @Resource
    private IStudentService studentService;
    public void setStudentService(IStudentService studentManage) {
        this.studentService = studentManage;
    }

    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
