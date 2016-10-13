package com.nenton.gamesofthrones.data.network.res;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListNames {
        public String getUrl() {
                return url;
        }

        public String getName() {
                return name;
        }

        public String getBorn() {
                return born;
        }

        public List<Object> getTitles() {
                return titles;
        }

        public List<String> getAllegiances() {
                return allegiances;
        }

        public String getCulture() {
                return culture;
        }

        public List<String> getAliases() {
                return aliases;
        }

        public String getFather() {
                return father;
        }

        public String getMother() {
                return mother;
        }

        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("gender")
        @Expose
        public String gender;
        @SerializedName("culture")
        @Expose
        public String culture;
        @SerializedName("born")
        @Expose
        public String born;
        @SerializedName("died")
        @Expose
        public String died;
        @SerializedName("titles")
        @Expose
        public List<Object> titles = new ArrayList<Object>();
        @SerializedName("aliases")
        @Expose
        public List<String> aliases = new ArrayList<String>();
        @SerializedName("father")
        @Expose
        public String father;
        @SerializedName("mother")
        @Expose
        public String mother;
        @SerializedName("spouse")
        @Expose
        public String spouse;
        @SerializedName("allegiances")
        @Expose
        public List<String> allegiances = new ArrayList<String>();
        @SerializedName("books")
        @Expose
        public List<String> books = new ArrayList<String>();
        @SerializedName("povBooks")
        @Expose
        public List<Object> povBooks = new ArrayList<Object>();
        @SerializedName("tvSeries")
        @Expose
        public List<String> tvSeries = new ArrayList<String>();
        @SerializedName("playedBy")
        @Expose
        public List<String> playedBy = new ArrayList<String>();

        public List<String> getTvSeries() {
                return tvSeries;
        }

        public String getDied() {
                return died;
        }
}
