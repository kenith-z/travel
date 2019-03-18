package xyz.hcworld.travel.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.hcworld.travel.model.user.User;

import java.util.List;

/**
 *
 *  user表的查询接口
 *  @author: 张红尘
 *  @date: 2018/10/30 21:32
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    /**
     *传入username和password去数据库查询是否有该字段
     * @param username 用户名
     * @param password 密码
     * @return User对象
     */
     User findByUsernameAndPassword(String username, String password);


    /**
     *传入username去数据库查询是否有该字段
     * @param username 用户名
     * @return User对象
     */
    User findByUsername(String username);

    /**
     *传入username和netname去数据库查询是否有该字段
     * @param username 用户名
     *   @param  netname 网名
     * @return User对象
     */
    List<User> findByUsernameOrNetname(String username, String netname);
}
