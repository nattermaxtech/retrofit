package com.targetcompetitions.retrofittutorial;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class GitHubRepo {

    private String name;

    @SerializedName("created_at")
    private Date created;

    public String getName() {
        return name;
    }

    public String getCreateDate(){
        return created.toString();
    }
}
