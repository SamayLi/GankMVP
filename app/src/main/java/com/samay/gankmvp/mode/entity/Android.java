package com.samay.gankmvp.mode.entity;

import java.util.Date;

/**
 * Created by shaohua.li on 7/7/16.
 */
public class Android {

    /**
     * publishedAt : 2016-07-07T11:58:33.45Z
     * desc : 点赞效果 类似twitter的效果
     * source : chrome
     * _id : 577d2227421aa9755674da47
     * createdAt : 2016-07-06T23:22:15.369Z
     * used : true
     * type : Android
     * url : https://github.com/ChadCSong/ShineButton
     * who : Jason
     */
    private Date publishedAt;
    private String desc;
    private String source;
    private String _id;
    private Date createdAt;
    private boolean used;
    private String type;
    private String url;
    private String who;


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWho(String who) {
        this.who = who;
    }


    public String getDesc() {
        return desc;
    }

    public String getSource() {
        return source;
    }

    public String get_id() {
        return _id;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isUsed() {
        return used;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getWho() {
        return who;
    }
}
