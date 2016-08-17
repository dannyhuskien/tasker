package com.hssn.models;

import java.util.Date;

public class Task {

    private int id;
    private String name;
    private String category;
    private Date Due;
    private Date CreatedAt;
    private boolean IsComplete;
    private Date UpdatedAt;

    public Task() {
        this.CreatedAt = new Date();
        this.UpdatedAt = new Date();
    }

    public boolean getIsComplete() {
        return IsComplete;
    }

    public void setIsComplete(boolean complete) {
        IsComplete = complete;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDue() {
        return Due;
    }

    public void setDue(Date due) {
        Due = due;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }

    protected void updateTime()
    {
        this.setUpdatedAt(new Date());
    }
}
