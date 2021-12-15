package com.android.facebookeg.data;

import com.android.facebookeg.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("posts")
    Observable<List<PostModel>> getPosts();
}
