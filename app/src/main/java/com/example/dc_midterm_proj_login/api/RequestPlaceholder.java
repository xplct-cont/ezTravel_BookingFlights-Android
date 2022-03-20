package com.example.dc_midterm_proj_login.api;

import com.example.dc_midterm_proj_login.pojos.Booked;
import com.example.dc_midterm_proj_login.pojos.Login;
import com.example.dc_midterm_proj_login.pojos.Register;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestPlaceholder {

    @POST("login")
    Call<Login> login(@Body Login login);


    @GET("get-all-posts")
    Call<List<Booked>> getAllPosts(@Query("token") String token, @Query("userid") String user_id);


    @FormUrlEncoded
    @POST("register")
    Call<Register> adddata (@Field("name") String name, @Field("username") String username, @Field("email") String email, @Field("password") String password);
}