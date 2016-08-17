package com.hssn.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "tasks")
public class Task {

    private int id;
    private String name;
    private String category;
    private Date due;
    private Date CreatedAt;
    private boolean IsComplete;
    private Date UpdatedAt;

    public Task() {
        this.CreatedAt = new Date();
        this.UpdatedAt = new Date();
    }

    @Column(name="is_complete", columnDefinition = "BIT", length = 1)
    public boolean getIsComplete() {
        return IsComplete;
    }

    public void setIsComplete(boolean complete) {
        IsComplete = complete;
    }

    @Id
    @GeneratedValue
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

    @Temporal(TemporalType.DATE)
    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", insertable = true, updatable = false)
    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }

    @PreUpdate
    protected void updateTime()
    {
        this.setUpdatedAt(new Date());
    }
}
