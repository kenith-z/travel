package xyz.hcworld.travel.action;

import org.springframework.stereotype.Service;
import xyz.hcworld.travel.model.hotel.Hotel;
import xyz.hcworld.travel.model.hotel.HotelComment;
import xyz.hcworld.travel.model.spots.Comment;
import xyz.hcworld.travel.model.spots.Spots;
import xyz.hcworld.travel.util.DBUtil;

import java.util.Collections;
import java.util.List;

/**
 * 景点介绍及评论模块
 * @author: 张红尘
 * @date: 2018/4/17 11:16
 */
@Service
public class SpotsServer {
    /**获得景点列表并示使得介绍在103个字符以内以免主页布局*/
    public List<Spots> isValidSpotsList() {
        //字符串长度
        int lent = 100,i=0;
        //获取景点的对象
        List<Spots> spotsList= DBUtil.dbUtil.spotsService.findAll();
        //java8新特性Lambda表达式，作用是遍历List每一个对象
        spotsList.forEach((info)->{
            if(info.getContent().length()>lent){
                //裁剪内容并加省略点
                info.setContent(info.getContent().substring(i,lent)+"...");
            }
        });
        return spotsList;
    }
    /**获得酒店列表并示使得介绍在103个字符以内以免主页布局*/
    public List isValidHotelList( Long id) {
        //字符串长度
        int lent = 100,i=0;
        //获取要登录的对象
        List<Hotel> hotelList= DBUtil.dbUtil.hotelService.findBySpotsID(id);
        //java8新特性Lambda表达式，作用是遍历List每一个对象
        hotelList.forEach((info)->{
            if(info.getContent().length()>lent){
                //裁剪内容并加省略点
                info.setContent(info.getContent().substring(i,lent)+"...");
            }
        });
        return hotelList;
    }


    /**获得景点信息*/
    public Spots isValidSpotsInfo(Long id) {
        Spots spotsInfo=  DBUtil.dbUtil.spotsService.findById(id);

        spotsInfo.setContent(spotsInfo.getContent().replaceAll("。\\r\\n","</p><p>"));
        return spotsInfo;
    }
    /**获得酒店信息*/
    public Hotel isValidHotelInfo(Long id) {
        Hotel hotelInfo=  DBUtil.dbUtil.hotelService.findById(id);
        hotelInfo.setContent(hotelInfo.getContent().replaceAll("。\\r\\n","</p><p>"));
        return hotelInfo;
    }
    /**获得景点评论信息*/
    public List<Comment> isValidSpotsCommentInfo(Long id) {
        List<Comment> spotsInfo=  DBUtil.dbUtil.commentSerivce.findBySpotsId(id);
        Collections.reverse(spotsInfo);
        return spotsInfo;
    }
    /**获得酒店评论信息*/
    public List<HotelComment> isValidHotelCommentInfo(Long id) {
        List<HotelComment> hotelInfo=  DBUtil.dbUtil.hotelCommentSerivce.findByHotelId(id);
        Collections.reverse(hotelInfo);
        return hotelInfo;
    }



}
