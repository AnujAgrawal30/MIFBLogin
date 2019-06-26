package com.example.fblogin.User;

import android.media.Image;
import android.widget.ImageView;

import okhttp3.RequestBody;

public class User {

    private int id;
    private String bloger_name;
    private String pic_url;
    private String types;
    private String College;
    private String bloger_topic;
    private String bloger_blog;
    private String bloger_status;
    private String bloger_pic;
    private String fblink;
    private String instalink;

    public User(int id, String bloger_name, String pic_url, String types, String college, String bloger_topic, String bloger_blog, String bloger_status, String bloger_pic, String fblink, String instalink) {
        this.id = id;
        this.bloger_name = bloger_name;
        this.types = types;
        this.College = college;
        this.bloger_topic = bloger_topic;
        this.bloger_blog = bloger_blog;
        this.bloger_status = bloger_status;
        this.pic_url = pic_url;
        this.bloger_pic = bloger_pic;
        this.fblink = fblink;
        this.instalink = instalink;
    }

    public String getpic_url(){
        return pic_url;
    }

    public String getId(){
        return Integer.toString(id);
    }


    public String getbloger_name() {
        return bloger_name;
    }

    public String getTypes() {
        return types;
    }

    public String getCollege() {
        return College;
    }

    public String getbloger_topic() {
        return bloger_topic;
    }

    public String getbloger_blog() {
        return bloger_blog;
    }

    public String getbloger_status() {
        return bloger_status;
    }

    public String getInstalink() {
        return instalink;
    }

    public String getFblink() {
        return fblink;
    }

    public String getbloger_pic() {
        return bloger_pic;
    }


    public String toString(){
        return "Post{" +
                "bloger_name='" + bloger_name + '\'' +
                ", types='" + types + '\'' +
                ", College='" + College + '\'' +
                ", bloger_topic='" + bloger_topic + '\'' +
                ", bloger_blog='" + bloger_blog + '\'' +
                ", bloger_status='  " + bloger_status + '\'' +
                '}';
    }
}
