package xyz.hcworld.travel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.hcworld.travel.model.spots.Comment;

import java.util.List;

/**
 *
 *  Comment表的查询接口
 *  @author: 张红尘
 *  @date: 2018/11/15 21:40
 *
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
    /**
     * 通过景点ID获得评论列表
     * @param spotsId 景点ID
     * @return 返回评论列表
     */
    List<Comment> findBySpotsId(Long spotsId);
    /**
     * 通过Netname获得评论列表
     * @param username 对应netname
     * @return 返回评论列表
     */
    List<Comment> findByUserName(String username);
}
