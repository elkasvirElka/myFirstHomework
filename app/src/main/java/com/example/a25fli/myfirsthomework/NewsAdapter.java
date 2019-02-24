package com.example.a25fli.myfirsthomework;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a25fli.myfirsthomework.model.NewsModel;
import com.example.a25fli.myfirsthomework.utils.CircleTransform;
import com.example.a25fli.myfirsthomework.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private OnItemClickListener clickListener;
    private List<NewsModel> news = new ArrayList<>();
    public void addItems(List<NewsModel> news) {
        if ( news != null && !news.isEmpty() ) {
            int startPosition = getItemCount();
            int endPosition = startPosition + news.size();
            this.news.addAll(news);
            notifyItemRangeInserted(startPosition, endPosition);
        }
    }
    public void setItems(List<NewsModel> news) {
        if ( news != null) {
            this.news = news;
            notifyDataSetChanged();
        }
    }


    interface OnItemClickListener {
        void onClick(NewsModel model);
    }
    public void setOnClickListener (OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
        return new NewsHolder(cellView);
    }



    @Override
    public int getItemViewType(int position) {
      return position;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //TODO
        Picasso.get()
                .load(getItem(position).getAvatar_url()).transform(new CircleTransform())
                .into(((NewsHolder) holder).ava);
        Picasso.get()
                .load(getItem(position).getPost_image())
                .into(((NewsHolder)holder).image);
        ((NewsHolder)holder).title.setText(getItem(position).getPost_text());
            ((NewsHolder)holder).like_count.setText(getItem(position).getLikes_count().toString());
            ((NewsHolder)holder).repost_count.setText(getItem(position).getShares_count().toString());
        ((NewsHolder)holder).comment_count.setText(getItem(position).getComments_count().toString());
        ((NewsHolder)holder).name.setText(getItem(position).getUsername());
        ((NewsHolder)holder).post_data.setText(DateUtils.getDate(getItem(position).getPost_date()));
        if(getItem(position).getIs_user_like()){
            ((NewsHolder)holder).like.setColorFilter(((NewsHolder)holder).itemView.getContext().getResources().getColor(R.color.red));
        }
        else{
            ((NewsHolder)holder).like.setColorFilter(((NewsHolder)holder).itemView.getContext().getResources().getColor(R.color.grey));
        }

    }

    @Override
    public int getItemCount() {
        return news.size() + 1 ;
    }

    private NewsModel getItem(int position){
        return news.get(position);
    }

    public class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image, ava;
        TextView title;
        TextView post_data, like_count, repost_count, comment_count;
        ImageView comment, like, repost;
        TextView name;
        View itemView;
        @SuppressLint("CutPasteId")
        public NewsHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            image = itemView.findViewById(R.id.news_image);
            title = itemView.findViewById(R.id.news_title);
            ava = itemView.findViewById(R.id.ava_image);
            name = itemView.findViewById(R.id.name);
            post_data = itemView.findViewById(R.id.post_data);
            like_count = itemView.findViewById(R.id.like_count);
            repost_count = itemView.findViewById(R.id.repost_count);
            comment_count = itemView.findViewById(R.id.comment_count);
            comment = itemView.findViewById(R.id.comment);
            comment.setColorFilter(itemView.getContext().getResources().getColor(R.color.grey));
            like = itemView.findViewById(R.id.like);
            repost = itemView.findViewById(R.id.repost);
            repost.setColorFilter(itemView.getContext().getResources().getColor(R.color.grey));
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if ( clickListener != null ) {
                clickListener.onClick( news.get(getAdapterPosition() - 1 ));
            }
        }
    }
    public class NewsTitleHolder extends RecyclerView.ViewHolder {
        public NewsTitleHolder(View itemView) {
            super(itemView);
        }
    }
}
