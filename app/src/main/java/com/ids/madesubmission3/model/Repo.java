package com.ids.madesubmission3.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created with love by Muhajir Shiddiq Al Faruqi on 01,December,2019.
 * Email : infinitydsolution@gmail.com
 * Phone : 0895411149046
 * Company : Infinity Digital Solution
 */
public class Repo {
    public final long id;
    public final String name;
    public final String description;
    public final User owner;
    @SerializedName("stargazers_count")
    public final long stars;
    @SerializedName("forks_count")
    public final long forks;

    public Repo(long id, String name, String description, User owner, long stars, long forks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.stars = stars;
        this.forks = forks;
    }

}
