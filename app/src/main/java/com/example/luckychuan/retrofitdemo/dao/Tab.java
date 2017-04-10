package com.example.luckychuan.retrofitdemo.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Luckychuan on 2017/4/10.
 */
public class Tab {

    private boolean status;
    @SerializedName("tngou")
    private List<TabData> dataList;

    public class TabData{
        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Tab{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public List<TabData> getDataList() {
        return dataList;
    }

    public boolean isStatus() {
        return status;
    }
}
