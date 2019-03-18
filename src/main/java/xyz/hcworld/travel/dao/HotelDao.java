package xyz.hcworld.travel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.hcworld.travel.model.hotel.Hotel;

import java.util.List;

/**
 *
 *  Spots表的查询接口
 *  @author: 张红尘
 *  @date: 2018/11/15 21:32
 *
 */
@Repository
public interface HotelDao extends JpaRepository<Hotel, Long> {
    /**
     *spotsId
     * @param spotsId 景点ID
     * @return List<User>对象
     */
    List<Hotel> findBySpotsId(Long spotsId);

}
