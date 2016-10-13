package com.nenton.gamesofthrones.data.storage;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Titles {

    @Id(autoincrement = true)
    private Long id;

    private String name;

    private String title;

    public Titles(String name, String title) {
        this.name = name;
        this.title = title;
    }

    @Generated(hash = 1185567105)
    public Titles(Long id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    @Generated(hash = 2082159104)
    public Titles() {
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
