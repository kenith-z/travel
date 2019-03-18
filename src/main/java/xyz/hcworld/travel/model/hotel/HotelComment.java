package xyz.hcworld.travel.model.hotel;

import javax.persistence.*;

/**
 * 酒店评论类
 *
 * @author: 张红尘
 * @date: 2018/11/15
 **/
@Entity(name = "tr_hotel_comment")
public class HotelComment {

    /**id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**用户名*/
    private String userName;
    /**酒店ID，代表是什么景点的评论*/
    private Long hotelId;
    /**主评论ID*/
    private String createTime;

    /**评论内容*/
    @Lob
    @Column(columnDefinition="TEXT")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long gethotelId() {
        return hotelId;
    }

    public void sethotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
