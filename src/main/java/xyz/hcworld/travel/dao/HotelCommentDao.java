package xyz.hcworld.travel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.hcworld.travel.model.hotel.HotelComment;

import java.util.List;

/**
 *
 *  Comment表的查询接口
 *  @author: 张红尘
 *  @date: 2018/11/15 21:45
 *
 */
@Repository
public interface HotelCommentDao extends JpaRepository<HotelComment, Long> {
    /**
     * 通过酒店ID获得评论列表
     * @param hotelId 酒店ID
     * @return 返回评论列表
     */
    List<HotelComment> findByHotelId(Long hotelId);
}
