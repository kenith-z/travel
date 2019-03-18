package xyz.hcworld.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hcworld.travel.dao.CommentDao;
import xyz.hcworld.travel.dao.HotelCommentDao;
import xyz.hcworld.travel.model.hotel.HotelComment;
import xyz.hcworld.travel.model.spots.Comment;

import java.util.List;
/**
 *
 *  HotelComment表的查询接口实现类
 *  @author: 张红尘
 *  @date: 2018/11/15 10:11
 *
 */
@Service
public class HotelCommentSerivce {

    @Autowired
    HotelCommentDao hotelcommentDao;
    /**获取所有对象*/
    public List<HotelComment> findAll() {
        return hotelcommentDao.findAll();
    }
    /**根据酒店ID获得评论*/
    public List<HotelComment> findByHotelId(Long hotelId){return  hotelcommentDao.findByHotelId(hotelId);};
}
