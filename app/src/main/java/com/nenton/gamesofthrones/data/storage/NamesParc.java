package com.nenton.gamesofthrones.data.storage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class NamesParc implements Parcelable{

    public static final String STARK = "STARK";
    public static final String LANNISTER = "LANNISTER";
    public static final String TARGARIEN = "TARGARIEN";

    private String name;
    private String words;
    private String born;
    private String died;
    private String father;
    private String mother;
    private String culture;
    private String aliases;
    private String titles;
    private String house;
    private String series;

    public NamesParc(Persons person, List<Aliases> aliases,List<Titles> titles, String words, String house,String series){
        name = person.getName();
        born = person.getBorn();
        died = person.getDied();
        father = person.getFather();
        mother = person.getMother();
        culture = person.getCulture();
        StringBuilder aliasesS = new StringBuilder();
        StringBuilder titlesS = new StringBuilder();
        for (int i = 0; i < aliases.size(); i++) {
            aliasesS.append(aliases.get(i).getAliase());
            aliasesS.append("\n");
        }

        for (int i = 0; i < titles.size(); i++) {
            titlesS.append(titles.get(i).getTitle());
            titlesS.append("\n");
        }
        this.aliases = aliasesS.toString();
        this.titles = titlesS.toString();
        this.words = words;
        this.house = house;
        this.series = series;
    }

    public NamesParc(Persons person, List<Aliases> aliases,List<Titles> titles,String series){
        name = person.getName();
        born = person.getBorn();
        died = person.getDied();
        father = person.getFather();
        mother = person.getMother();
        culture = person.getCulture();
        StringBuilder aliasesS = new StringBuilder();
        StringBuilder titlesS = new StringBuilder();
        for (int i = 0; i < aliases.size(); i++) {
            aliasesS.append(aliases.get(i).getAliase());
            aliasesS.append("\n");
        }

        for (int i = 0; i < titles.size(); i++) {
            titlesS.append(titles.get(i).getTitle());
            titlesS.append("\n");
        }
        this.aliases = aliasesS.toString();
        this.titles = titlesS.toString();
        this.series = series;
    }

    protected NamesParc(Parcel in) {
        name = in.readString();
        words = in.readString();
        born = in.readString();
        died = in.readString();
        father = in.readString();
        mother = in.readString();
        culture = in.readString();
        aliases = in.readString();
        titles = in.readString();
        house = in.readString();
        series = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(words);
        dest.writeString(born);
        dest.writeString(died);
        dest.writeString(father);
        dest.writeString(mother);
        dest.writeString(culture);
        dest.writeString(aliases);
        dest.writeString(titles);
        dest.writeString(house);
        dest.writeString(series);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<NamesParc> CREATOR = new Parcelable.Creator<NamesParc>() {
        @Override
        public NamesParc createFromParcel(Parcel in) {
            return new NamesParc(in);
        }

        @Override
        public NamesParc[] newArray(int size) {
            return new NamesParc[size];
        }
    };

    public String getDied() {
        return died;
    }

    public String getSeries() {
        return series;
    }

    public String getHouse() {
        return house;
    }

    public String getName() {
        return name;
    }

    public String getBorn() {
        return born;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getCulture() {
        return culture;
    }

    public String getWords() {
        return words;
    }

    public String getAliases() {
        return aliases;
    }

    public String getTitles() {
        return titles;
    }
}
