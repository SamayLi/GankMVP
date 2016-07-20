package com.samay.gankmvp.mode.entity;

/**
 * Created by shaohua.li on 7/20/16.
 */
public class Video  {


    /**
     * publishedAt : 2016-07-19T12:13:10.925Z
     * desc : 《本周看不看》:最诚实的观影指南，一周上八部，八部同一天，有毒！
     * source : chrome
     * _id : 577e5aa8421aa97c1bf466fa
     * createdAt : 2016-07-07T21:35:36.324Z
     * used : true
     * type : 休息视频
     * url : http://www.miaopai.com/show/HR6eYCBBVELwo4f8NQYHSg__.htm
     * who : lxxself
     */
    private String publishedAt;
    private String desc;
    private String source;
    private String _id;
    private String createdAt;
    private boolean used;
    private String type;
    private String url;
    private String who;

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public String getPublishedAt() {
        return publishedAt;
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

    public String getCreatedAt() {
        return createdAt;
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
