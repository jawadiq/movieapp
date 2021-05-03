package com.example.mymove.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Movies implements Serializable {



    private int id;
    private String title;
    private String description;
    private String logo;

    public Movies(int id, String title, String description, String logo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.logo = logo;
    }


    protected Movies(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        logo = in.readString();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }



}
