package com.ceng319.listviewdemo;

// TODO 1: Needs a data holder for your List Items. This is the element of the data unit. Finished
// Define a data class that would have the following items:
/*private String itemId;
private String itemName;
private String flagimage;*/

// This is a holder of the data that would be used for your app.
public class DataItem {

    private int itemId;
    private String itemName;
    private String flagimage;

    public DataItem(int itemId, String itemName, String flagimage) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.flagimage = flagimage;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



    public String getImage() {
        return flagimage;
    }

    public void setImage(String image) {
        this.flagimage = image;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", flagimage='" + flagimage + '\'' +
                '}';
    }
}
