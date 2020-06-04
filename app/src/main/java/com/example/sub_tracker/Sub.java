package com.example.sub_tracker;

public class Sub {
    private int _id;
    private String _subname;
    private int _price;
    private String _email;
    private String _card;
    private String _startdate;
    private String _enddate;
    private String _color;
    private long expire;
    private String notif = "true";

    public Sub() {}

    public Sub(int id, String subname, int price, String email, String card, String startdate, String enddate, String color, String notif) {
        this._id = id;
        this._subname = subname;
        this._price = price;
        this._email = email;
        this._card = card;
        this._startdate = startdate;
        this._enddate = enddate;
        this._color = color;
        this.notif = notif;
    }

    public Sub(String subname, int price, String email, String card, String startdate, String enddate, String color) {
        this._subname = subname;
        this._price = price;
        this._email = email;
        this._card = card;
        this._startdate = startdate;
        this._enddate = enddate;
        this._color = color;
    }

    public Sub(int id, String subname, int price, String email, String card, String startdate, String enddate) {
        this._id = id;
        this._subname = subname;
        this._price = price;
        this._email = email;
        this._card = card;
        this._startdate = startdate;
        this._enddate = enddate;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setSubname(String subname) {
        this._subname = subname;
    }

    public String getSubname() {
        return this._subname;
    }

    public void setPrice(int price) {
        this._price = price;
    }

    public int getPrice() {
        return this._price;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public String getEmail() {
        return this._email;
    }

    public void setCard(String card) {
        this._card = card;
    }

    public String getCard() {
        return this._card;
    }

    public void setStartdate(String startdate) {
        this._startdate = startdate;
    }

    public String getStartdate() {
        return this._startdate;
    }

    public void setEnddate(String enddate) {
        this._enddate = enddate;
    }

    public String getEnddate() {
        return this._enddate;
    }


    public String get_color() {
        return _color;
    }

    public void set_color(String _color) {
        this._color = _color;
    }


}
