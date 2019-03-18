package xyz.hcworld.travel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.hcworld.travel.model.spots.Spots;

/**
 *
 *  Spots表的查询接口
 *  @author: 张红尘
 *  @date: 2018/11/15 21:32
 *
 */
@Repository
public interface SpotsDao extends JpaRepository<Spots, Long> {

}
