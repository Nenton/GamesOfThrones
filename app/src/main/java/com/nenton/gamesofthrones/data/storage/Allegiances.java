package com.nenton.gamesofthrones.data.storage;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Allegiances {

    @Id(autoincrement = true)
    private Long id;

    private String name;

    private String allegiance;

    public Allegiances(String name, String allegiance) {
        this.name = name;
        this.allegiance = allegiance;
    }

    @Generated(hash = 1937316714)
    public Allegiances(Long id, String name, String allegiance) {
        this.id = id;
        this.name = name;
        this.allegiance = allegiance;
    }

    @Generated(hash = 726077602)
    public Allegiances() {
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

    public String getAllegiance() {
        return this.allegiance;
    }

    public void setAllegiance(String allegiance) {
        this.allegiance = allegiance;
    }

}
