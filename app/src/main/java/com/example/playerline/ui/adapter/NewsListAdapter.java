package com.example.playerline.ui.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.playerline.R;
import com.example.playerline.model.News;
import com.example.playerline.model.NewsList;

import java.io.BufferedInputStream;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class NewsListAdapter extends RecyclerView.Adapter {

    Activity activity;
    Fragment fragment;
    NewsList newsList;

    public NewsListAdapter(Activity activity, Fragment fragment, NewsList newsList) {
        this.activity = activity;
        this.fragment = fragment;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list,
                parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((NewsHolder) holder).bind(newsList.get(position), position);
    }

    public void setNewsList(NewsList newsList){
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    private class NewsHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvPosition, tvTitle,
                tvDescription, tvDay, tvResource;
        ImageView imageView;

        public NewsHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_player_name);
            tvPosition = view.findViewById(R.id.tv_position);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDescription = view.findViewById(R.id.tv_details);
            tvDay = view.findViewById(R.id.tv_day);
            tvResource = view.findViewById(R.id.tv_resource);
            imageView = view.findViewById(R.id.player_image);
        }

        public void bind(News news, final int position) {
            tvName.setText(news.getPname());
            tvPosition.setText(news.getPosition());
            tvTitle.setText(news.getTitle());
            tvDescription.setText(news.getDetails());

            Glide.with(fragment).load(news.getPlayerImageUrl()).into(imageView);

        }
    }
}
