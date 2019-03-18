package xyz.hcworld.travel.model.hotel;

import javax.persistence.*;

/**
 * 景点类
 *
 * @author: 张红尘
 * @date: 2018/11/15
 **/
@Entity(name = "tr_hotel")
public class Hotel {

    /**id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**图片路径*/
    private String image;
    /**酒店名称*/
    private String hotel;
    /**酒店价格*/
    private int money;

    /**酒店邻近景点ID*/
    private Long spotsId;
    /**酒店介绍*/
    @Lob
    @Column(columnDefinition="TEXT")
    private String content;
    /**介绍发表日期*/
    private String createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getMoney() {return money;}

    public void setMoney(int money) { this.money = money;}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Long getSpotsId() {
        return spotsId;
    }

    public void setSpotsId(Long spotsId) {
        this.spotsId = spotsId;
    }
}
