package xyz.hcworld.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hcworld.travel.dao.HotelDao;
import xyz.hcworld.travel.dao.SpotsDao;
import xyz.hcworld.travel.model.hotel.Hotel;
import xyz.hcworld.travel.model.spots.Spots;

import java.util.List;
import java.util.NoSuchElementException;

/**add
 *
 *  Spots表的查询类
 *  @author: 张红尘
 *  @date: 2018/10/30 21:41
 *
 */
@Service
public class HotelService {
    @Autowired
    HotelDao hotelDao;
    /**获得所有酒店*/
    public List<Hotel> findAll() {return hotelDao.findAll();}
    /**获得景点附近酒店*/
    public List<Hotel> findBySpotsID(Long spotsId) {return hotelDao.findBySpotsId(spotsId);}
    /**通过ID获得酒店对象*/
    public Hotel findById(Long id) {try {return hotelDao.findById(id).get(); }catch (NoSuchElementException e){return null; }}
}
