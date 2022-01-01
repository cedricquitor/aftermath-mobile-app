package com.cedric.aftermathproj;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<NewsModel> newsModelArrayList;

    public NewsAdapter(Context context, ArrayList<NewsModel> newsModelArrayList) {
        this.context = context;
        this.newsModelArrayList = newsModelArrayList;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        NewsModel model = newsModelArrayList.get(position);
        String newsGame, newsTitle, newsHeader, newsContent, newsAuthor, newsDate;
        int newsImg;

        newsGame = newsModelArrayList.get(position).getGame();
        newsTitle = newsModelArrayList.get(position).getTitle();
        newsHeader = newsModelArrayList.get(position).getNewsHeader();
        newsContent = newsModelArrayList.get(position).getNewsContent();
        newsAuthor = newsModelArrayList.get(position).getAuthor();
        newsDate = newsModelArrayList.get(position).getDate();
        newsImg = newsModelArrayList.get(position).getImg();

        holder.setData(newsTitle, newsDate, newsImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsActivity = new Intent(context, NewsActivity.class);
                newsActivity.putExtra("extraNewsGame", model.getGame());
                newsActivity.putExtra("extraNewsTitle", model.getTitle());
                newsActivity.putExtra("extraNewsHeader", model.getNewsHeader());
                newsActivity.putExtra("extraNewsContent", model.getNewsContent());
                newsActivity.putExtra("extraNewsAuthor", model.getAuthor());
                newsActivity.putExtra("extraNewsDate", model.getDate());
                newsActivity.putExtra("extraNewsImg", model.getImg());
                context.startActivity(newsActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, date;
        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title_txt);
            date = itemView.findViewById(R.id.news_date_txt);
            img = itemView.findViewById(R.id.news_img);
        }

        public void setData(String newsTitle, String newsDate, int newsImg) {
            title.setText(newsTitle);
            date.setText(newsDate);
            img.setImageResource(newsImg);
        }
    }
}
