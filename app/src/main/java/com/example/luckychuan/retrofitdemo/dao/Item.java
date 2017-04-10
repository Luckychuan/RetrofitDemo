package com.example.luckychuan.retrofitdemo.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Luckychuan on 2017/4/10.
 */
public class Item {

    private boolean status;
    @SerializedName("tngou")
    private List<ItemData> dataList;

    public boolean isStatus() {
        return status;
    }

    public List<ItemData> getDataList() {
        return dataList;
    }

    public class ItemData {
        private String title;
        private String description;

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
