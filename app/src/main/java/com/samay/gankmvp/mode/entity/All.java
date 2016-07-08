package com.samay.gankmvp.mode.entity;

import java.util.Date;

/**
 * Created by shaohua.li on 7/7/16.
 */
public class All {

    /**
     * publishedAt : 2016-07-05T11:36:50.61Z
     * desc : 又一个 Material Design 风格的 Preference ，这个效果也很棒！拿来即可使用。
     * source : chrome
     * _id : 577b26a0421aa90191bc2a46
     * createdAt : 2016-07-05T11:16:48.941Z
     * used : true
     * type : Android
     * url : https://github.com/yarolegovich/MaterialPreferences
     * who : 代码家
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
