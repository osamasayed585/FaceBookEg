package com.android.facebookeg.ui.main;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.facebookeg.R;
import com.android.facebookeg.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private List<PostModel> arrayList = new ArrayList<PostModel>();

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.userId.setText(String.valueOf(arrayList.get(position).getUserId()));
        holder.title.setText(arrayList.get(position).getTitle());
        holder.body.setText(arrayList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setList(List<PostModel> arrList) {
        this.arrayList = arrList;
        notifyDataSetChanged();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        private TextView userId, title, body;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.tv_userId);
            title = itemView.findViewById(R.id.tvTitle);
            body = itemView.findViewById(R.id.tvBody);
        }

    }
}
