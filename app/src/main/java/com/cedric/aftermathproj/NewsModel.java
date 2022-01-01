package com.cedric.aftermathproj;

public class NewsModel {
    String game, title, newsHeader, newsContent, author, date;
    int img;

    public NewsModel(String game, String title, String newsHeader, String newsContent, String author, String date, int img) {
        this.game = game;
        this.title = title;
        this.newsHeader = newsHeader;
        this.newsContent = newsContent;
        this.author = author;
        this.date = date;
        this.img = img;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsHeader() {
        return newsHeader;
    }

    public void setNewsHeader(String newsHeader) {
        this.newsHeader = newsHeader;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
