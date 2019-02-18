package com.example.a25fli.myfirsthomework.model;

/**
 * Created by 25fli on 17.02.2019.
 */

public class NewsModel {
    private Integer id;
    private String avatar_url;
    private String username;
    private Long post_date;
    private String post_text;
    private String post_image;
    private Boolean is_user_like;
    private Integer likes_count;
    private Integer comments_count;
    private Integer shares_count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPost_date() {
        return post_date;
    }

    public void setPost_date(Long post_date) {
        this.post_date = post_date;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public Boolean getIs_user_like() {
        return is_user_like;
    }

    public void setIs_user_like(Boolean is_user_like) {
        this.is_user_like = is_user_like;
    }

    public Integer getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(Integer likes_count) {
        this.likes_count = likes_count;
    }

    public Integer getComments_count() {
        return comments_count;
    }

    public void setComments_count(Integer comments_count) {
        this.comments_count = comments_count;
    }

    public Integer getShares_count() {
        return shares_count;
    }

    public void setShares_count(Integer shares_count) {
        this.shares_count = shares_count;
    }
}
