package xyz.hcworld.travel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hcworld.travel.dao.UserDao;
import xyz.hcworld.travel.model.user.User;

import java.util.List;

/**add
 *
 *  user表的查询类
 *  @author: 张红尘
 *  @date: 2018/10/30 21:32
 *
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    /** 根据username和password获得用户对象*/
    public User findByUsernameAndPassword(String username, String password) { return userDao.findByUsernameAndPassword(username, password); }
    /**保存用户*/
    public void save(User user1) {
        userDao.save(user1);
    }
    /**修改用户*/
    public boolean updata(User user1) { try{userDao.save(user1); return true; }catch (Exception e){return false;}
    }
    /**根据username和netname获得User对象*/
    public User findByName(String username) { return userDao.findByUsername(username); }
    /**根据username和netname获得User对象*/
    public List<User> findByUsernameOrNetname(String username,String netname) { return userDao.findByUsernameOrNetname(username,netname);}
    /**获取所有对象*/
    public List<User> findAll() {
        return userDao.findAll();
    }

}
