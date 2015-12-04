package com.jialin.basic.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author : JiaLin
 * @Group : TGB
 * @Date : 2014/5/23
 * @Description :
 */
public abstract class AbstractEntity implements java.io.Serializable  {

    //private static final long serialVersionUID =1L;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    public void save() {
//        ICommonService commonService = SpringContextUtil.getBean("CommonService");
//        commonService.save(this);
    }

    public void delete() {
//        ICommonService commonService = SpringContextUtil.getBean("CommonService");
//        commonService.deleteObject(this);
    }

    public void update() {
//        ICommonService commonService = SpringContextUtil.getBean("CommonService");
//        commonService.update(this);
    }
}
