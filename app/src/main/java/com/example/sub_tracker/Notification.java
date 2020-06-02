package com.example.sub_tracker;

public class Notification {

    int imgNot=R.drawable.user_icon_pic;
    private int id;
    private String mDescription;
    private String mTitle;

    public Notification(int id,String mDescription,String mTitle){
        this.id=id;
        this.mDescription=mDescription;
        this.mTitle=mTitle;
    }

    public int getId() {
        return id;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
