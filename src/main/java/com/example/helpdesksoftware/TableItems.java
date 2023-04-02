package com.example.helpdesksoftware;

public class TableItems {


    private int id;
    private String theme;
    private String comment;
    private String status = "in Work";

    public TableItems(String comment, String theme) {
        this.theme = theme;
        this.comment = comment;

    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TableItems(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TableItems(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
