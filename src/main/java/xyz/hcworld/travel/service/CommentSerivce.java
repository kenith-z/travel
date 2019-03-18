package xyz.hcworld.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hcworld.travel.dao.CommentDao;
import xyz.hcworld.travel.model.spots.Comment;

import java.util.List;
@Service
public class CommentSerivce {

    @Autowired
    CommentDao commentDao;
    /**获取所有对象*/
    public List<Comment> findAll() {
        return commentDao.findAll();
    }
    /**根据景点ID获取评论*/
    public List<Comment> findBySpotsId(Long spotsId){return  commentDao.findBySpotsId(spotsId);};
    public List<Comment> findByNetName(String username){return  commentDao.findByUserName(username);};
    public void save(Comment comm) {
        commentDao.save(comm);
    }
}
