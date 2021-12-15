package com.android.facebookeg.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.facebookeg.R;
import com.android.facebookeg.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);

        postViewModel.getPosts();

        RecyclerView recycler = findViewById(R.id.recycler);
        PostAdapter postAdapter = new PostAdapter();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(postAdapter);

        postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postAdapter.setList(postModels);
            }
        });

    }
}