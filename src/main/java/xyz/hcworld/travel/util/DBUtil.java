package xyz.hcworld.travel.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.hcworld.travel.model.hotel.Hotel;
import xyz.hcworld.travel.service.*;

import javax.annotation.PostConstruct;


/**
 * 数据库单例
 * @author: 张红尘
 * @date: 2018/10/30 21:59
 */
@Component
public class DBUtil {
    @Autowired
    public UserService userService;
    @Autowired
    public CommentSerivce commentSerivce;
    @Autowired
    public SpotsService spotsService;
    @Autowired
    public HotelService hotelService;
    @Autowired
    public HotelCommentSerivce hotelCommentSerivce;


    public static DBUtil dbUtil;
    @PostConstruct
    public void init() {
        dbUtil = this;
        dbUtil.userService = this.userService;
        dbUtil.commentSerivce = this.commentSerivce;
        dbUtil.spotsService = this.spotsService;
        dbUtil.hotelService = this.hotelService;
        dbUtil.hotelCommentSerivce = this.hotelCommentSerivce;
    }

}
