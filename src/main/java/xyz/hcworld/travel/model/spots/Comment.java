package xyz.hcworld.travel.model.spots;

import javax.persistence.*;

/**
 * 评论类
 *
 * @author: 张红尘
 * @date: 2018/11/15
 **/
@Entity(name = "tr_comment")
public class Comment {

    /**id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**用户名*/
    private String userName;
    /**景点ID，代表是什么景点的评论*/
    private Long spotsId;
    /**主评论ID*/
    private Long fatherId;

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

    public Long getSpotsId() {
        return spotsId;
    }

    public void setSpotsId(Long spotsId) {
        this.spotsId = spotsId;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
