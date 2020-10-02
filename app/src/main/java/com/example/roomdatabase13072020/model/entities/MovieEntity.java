package com.example.roomdatabase13072020.model.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class MovieEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    private String name;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    @ColumnInfo(typeAffinity = ColumnInfo.REAL)
    private float rating;

    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    private String qualify;

    @Ignore
    public MovieEntity(String name, byte[] image, float rating, String qualify) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.qualify = qualify;
    }

    public MovieEntity() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getQualify() {
        return qualify;
    }

    public void setQualify(String qualify) {
        this.qualify = qualify;
    }
}
