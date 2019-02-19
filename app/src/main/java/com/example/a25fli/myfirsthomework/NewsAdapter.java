package com.example.a25fli.myfirsthomework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a25fli.myfirsthomework.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private OnItemClickListener clickListener;
    private List<NewsModel> news = new ArrayList<>();
    private static int TYPE_TITLE = 0;
    private static int TYPE_CELL = 1;
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
        View titleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_title, parent, false);
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
        if ( viewType == TYPE_TITLE ) {
            return new NewsTitleHolder(titleView);
        } else {
            return new NewsHolder(cellView);
        }
    }



    @Override
    public int getItemViewType(int position) {
        if ( position == 0) {
            return TYPE_TITLE;
        } else {
            return TYPE_CELL;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if ( getItemViewType(position) != TYPE_TITLE ) {
          /*  Picasso.get()
                    .load(getItem(position - 1).thumbnails.full.url)
                    .into(((NewsHolder)holder).image);
            ((NewsHolder)holder).text.setText(getItem(position - 1).preview);
            ((NewsHolder)holder).date.setText(DateUtils.getDate(getItem(position - 1).timestamp));
            ((NewsHolder)holder).title.setText(getItem(position - 1).title);*/
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
        ImageView image;
        TextView title;
        TextView date;
        TextView text;
        public NewsHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.news_image);
            title = itemView.findViewById(R.id.news_title);
            date = itemView.findViewById(R.id.news_date);
            text = itemView.findViewById(R.id.news_text);
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
