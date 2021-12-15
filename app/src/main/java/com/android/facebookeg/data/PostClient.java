package com.android.facebookeg.data;

import com.android.facebookeg.pojo.PostModel;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private PostApi postApi;

    private static PostClient instance;

    private PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        postApi = retrofit.create(PostApi.class);
    }

    public static PostClient getInstance() {

        if (instance == null) {
            instance = new PostClient();
        }
        return instance;
    }

    public Observable<List<PostModel>> getPosts(){
        return postApi.getPosts();
    }
}
