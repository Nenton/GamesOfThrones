package com.nenton.gamesofthrones.data.storage;

import com.nenton.gamesofthrones.data.network.res.ListNames;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Aliases {
    @Id(autoincrement = true)
    private Long id;

    private String name;
    
    private String aliase;

    public Aliases(String name, String aliase) {
        this.name = name;
        this.aliase = aliase;
    }

    @Generated(hash = 589257841)
    public Aliases(Long id, String name, String aliase) {
        this.id = id;
        this.name = name;
        this.aliase = aliase;
    }

    @Generated(hash = 1178083776)
    public Aliases() {
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

    public String getAliase() {
        return this.aliase;
    }

    public void setAliase(String aliase) {
        this.aliase = aliase;
    }


}
