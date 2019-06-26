package com.example.fblogin.User;

import com.google.gson.annotations.Expose;

import okhttp3.RequestBody;

public class User {

//    private String bloger_name;
//    private String types;
//    private String College;
//    private String bloger_topic;
//    private String bloger_blog;
//    private String bloger_status;
    private RequestBody image;
//
//    public User(String bloger_name, String types, String college, String bloger_topic, String bloger_blog, String bloger_status) {
//        this.bloger_name = bloger_name;
//        this.types = types;
//        College = college;
//        this.bloger_topic = bloger_topic;
//        this.bloger_blog = bloger_blog;
//        this.bloger_status = bloger_status;
    public User(RequestBody image){
        this.image = image;
    }

    public RequestBody getImage(){
        return image;
    }
//
//    public String getBloger_name() {
//        return bloger_name;
//    }
//
//    public String getTypes() {
//        return types;
//    }
//
//    public String getCollege() {
//        return College;
//    }
//
//    public String getBloger_topic() {
//        return bloger_topic;
//    }
//
//    public String getBloger_blog() {
//        return bloger_blog;
//    }
//
//    public String getBloger_status() {
//        return bloger_status;
//    }
//
//    public String toString(){
//        return "Post{" +
//                "bloger_name='" + bloger_name + '\'' +
//                ", types='" + types + '\'' +
//                ", College='" + College + '\'' +
//                ", bloger_topic='" + bloger_topic + '\'' +
//                ", bloger_blog='" + bloger_blog + '\'' +
//                ", bloger_status='  " + bloger_status + '\'' +
//                '}';
//    }
}
