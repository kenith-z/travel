package xyz.hcworld.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hcworld.travel.dao.SpotsDao;
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
public class SpotsService {
    @Autowired
    SpotsDao spotsDao;
    /**获得所有景点*/
    public List<Spots> findAll() {return spotsDao.findAll();}
    /**通过ID获得景点对象*/
    public Spots findById(Long id) {try {return spotsDao.findById(id).get(); }catch (NoSuchElementException e){return null; }}
}
