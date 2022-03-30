package com.example.finance.models;

public class HomePageItems {
    private String item_name;
    private int item_images;

    public HomePageItems(String item_name, int item_images) {
        this.item_name = item_name;
        this.item_images = item_images;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_images() {
        return item_images;
    }

    public void setItem_images(int item_images) {
        this.item_images = item_images;
    }

    @Override
    public String toString() {
        return "HomePageItems{" +
                "item_name='" + item_name + '\'' +
                ", item_images=" + item_images +
                '}';
    }
}
