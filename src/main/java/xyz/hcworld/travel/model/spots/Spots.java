package xyz.hcworld.travel.model.spots;

import javax.persistence.*;

/**
 * 景点类
 *
 * @author: 张红尘
 * @date: 2018/11/15
 **/
@Entity(name = "tr_spots")
public class Spots {

    /**id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**图片路径*/
    private String image;
    /**景点名称*/
    private String spots;
    /**景点介绍*/
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

    public String getSpots() {
        return spots;
    }

    public void setSpots(String spots) {
        this.spots = spots;
    }

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
}
