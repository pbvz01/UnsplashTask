package com.pbvz.app.unsplash.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.net.URL;


public class Photo {
    private User user;
    private String description;
    private Urls urls;

    public Photo () {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Photo {" +
                "author='" + user.getName() + '\'' +
                ", description='" + description + '\'' +
                "Image urls: " + urls + '\'' +
                '}';
    }
}

class User {
    private String id;
    private String name;

    public User() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Urls {
    @JsonProperty("small")
    private URL urlImageSmallSize;
    @JsonProperty("regular")
    private URL urlImageBigSize;

    public Urls() {}

    public URL getUrlImageSmallSize() {
        return urlImageSmallSize;
    }
    @JsonSetter("small")
    public void setUrlImageSmallSize(URL urlImageSmallSize) {
        this.urlImageSmallSize = urlImageSmallSize;
    }

    public URL getUrlImageBigSize() {
        return urlImageBigSize;
    }
    @JsonSetter("regular")
    public void setUrlImageBigSize(URL urlImageBigSize) {
        this.urlImageBigSize = urlImageBigSize;
    }

    @Override
    public String toString() {
        return "ImageURL{" +
                "urlImageSmallSize='" + urlImageSmallSize.toString() + '\'' +
                ", urlImageBigSize='" + urlImageBigSize.toString() + '\'' +
                '}';
    }
}