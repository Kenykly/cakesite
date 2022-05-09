package com.university.project.domain;

import javax.persistence.*;

@Entity //указываем что это сущность бд
public class Message {

    @Id //указываем что это айди
    @GeneratedValue(strategy= GenerationType.AUTO) //доверяем спрингу в настройке айди
    private  Integer id;

    private  String text;
    private  String tag;

    private  String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    //одному пользователю соотв множество сообщений
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }

    public Message(){

    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public  String getAuthorName(){
        return author != null ? author.getUsername() : "нет автора";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
