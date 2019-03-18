package xyz.hcworld.travel.model.user;

/**
 * 账号类
 *
 * @author: 张红尘
 * @date: 2018/4/23
 **/

import javax.persistence.*;

@Entity(name = "tr_user")
public class User {
    /**id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**账号*/
    @Column(unique=true)
    private String username;
    /**密码*/
    private String password;
    /**用户名*/
    private String netname;
    /**性别*/
    private String sex;
    /**Email*/
    private String email;
    /**电话*/
    private String phone;
    /**注册日期*/
    private String createtime;

    /**获取ID*/
    public Long getId() {
        return id;
    }
    /**设置ID*/
    public void setId(Long id) {
        this.id = id;
    }
    /**获取用户名*/
    public String getNetname() {
        return netname;
    }
    /**设置用户名*/
    public void setNetname(String netname) {
        this.netname = netname;
    }
    /**获取性别*/
    public String getSex() {
        return sex;
    }
    /**设置性别*/
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**获取Email*/
    public String getEmail() {
        return email;
    }
    /**设置Email'*/
    public void setEmail(String email) {
        this.email = email;
    }
    /**获取电话*/
    public String getPhone() {
        return phone;
    }
    /**设置电话*/
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**获取注册日期*/
    public String getCreatetime() {
        return createtime;
    }
    /**设置注册日期*/
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


    /**获取账号*/
    public String getUsername() {
        return username;
    }

    /**设置账号*/
    public void setUsername(String username) {
        this.username = username;
    }

    /**获取密码*/
    public String getPassword() {
        return password;
    }

    /**设置密码*/
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", netname='" + netname + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
