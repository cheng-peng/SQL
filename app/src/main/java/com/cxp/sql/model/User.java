package com.cxp.sql.model;

/**
 * 文 件 名: User
 * 创 建 人: CXP
 * 创建日期: 2017-01-17 16:05
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

/**
 * @Entity：将我们的java普通类变为一个能够被greenDAO识别的数据库类型的实体类
 * @Id：通过这个注解标记的字段必须是Long类型的，这个字段在数据库中表示它就是主键，并且它默认就是自增的
 * @Transient：表明这个字段不会被写入数据库，只是作为一个普通的java类字段，用来临时存储数据的，不会被持久化, 接下来让我们点击as中Build菜单栏中的Make Project，make完成之后会发现我们的User类中突然多了好多代码，这就是greenDAO自动为你生成的了，代码如下
 */
@Entity
public class User {

    @Id
    private Long id;
    private String name;
    private Integer age;
    @Transient
    private int sex;
    @Generated(hash = 1499888241)
    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return this.age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

}
