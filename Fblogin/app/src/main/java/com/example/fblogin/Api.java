package com.example.fblogin;

import android.net.Uri;

import com.example.fblogin.User.User;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Part;
import retrofit2.Call;
import okhttp3.ResponseBody;
import retrofit2.http.Multipart;

public interface Api {

    String BASE_URL = "http://192.168.43.222:8000/";

    @Multipart
    @POST("/api/post/")
    Call<ResponseBody> postFile(@Part MultipartBody.Part file, @Part("description") RequestBody description);
//    Call<User> uploadImage(@Part("desc") MultipartBody.Part desc);
//    Call<User> uploadImage(@Part("College") RequestBody file
//                        @Field("types") String types,
//                        @Field("bloger_topic") String bloger_topic,
//                        @Field("bloger_blog") String bloger_blog,
//                        @Field("bloger_status") String bloger_status


    @GET("/api/post/")
    Call<List<User>> getUsers();
}
