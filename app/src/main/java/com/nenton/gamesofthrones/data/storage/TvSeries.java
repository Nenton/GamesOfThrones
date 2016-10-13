package com.nenton.gamesofthrones.data.storage;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TvSeries {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;

    private String series;

    public TvSeries(String name, String series){
        this.name = name;
        this.series = series;
    }

    @Generated(hash = 1084876078)
    public TvSeries(Long id, @NotNull String name, String series) {
        this.id = id;
        this.name = name;
        this.series = series;
    }

    @Generated(hash = 1084203818)
    public TvSeries() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
