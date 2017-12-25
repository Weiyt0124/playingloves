package com.weiyt.pojo;


import com.weiyt.base.BasePojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 艾泽拉斯国家地理
 * @create 2017/11/6
 */
@Table(name = "forum")
public class Forum extends BasePojo {
    @Id
    String id ;

    @Column(name = "uid")
    String userId;

    String title;

    String content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
