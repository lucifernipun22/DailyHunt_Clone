package com.DBEample.SQLDBDemo.Entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="source",  nullable=false, unique=false)
    private String source;

    @Column(name="imageurl", nullable=false, unique=false)
    private String imageurl;

    @Column(name="title", nullable=false, unique=false)
    private String title;

    @Column(name="description", nullable=false, unique=false)
    private String description;

    @Column(name="likes", nullable=false, unique=false)
    private String likes;

    @Column(name="comments", nullable=false, unique=false)
    private String comments;

    @Column(name="createdon", nullable=false, unique=false)
    private String createdon;

    public News() {
    }

    public News(int id, String source, String imageurl, String title, String description, String likes, String comments, String createdon) {
        this.id = id;
        this.source = source;
        this.imageurl = imageurl;
        this.title = title;
        this.description = description;
        this.likes = likes;
        this.comments = comments;
        this.createdon = createdon;
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLikes() {
        return likes;
    }

    public String getComments() {
        return comments;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", likes='" + likes + '\'' +
                ", comments='" + comments + '\'' +
                ", createdon='" + createdon + '\'' +
                '}';
    }
}
