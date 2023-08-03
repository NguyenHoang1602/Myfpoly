package com.example.asm_nguyenhnpk02250.Fragment.fragment_score.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_tuition.TuitionAdapter.TuitionAdapter;
import com.example.asm_nguyenhnpk02250.Model.News;
import com.example.asm_nguyenhnpk02250.R;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewViewHolder> {
    private Context context;
    private ArrayList<News> list;

    public NewAdapter(Context context, ArrayList<News> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new  NewAdapter.NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        final News news = list.get(position);
        holder.tv_name.setText(news.getPublisher_news());
        holder.tv_datetime.setText(news.getNews_Time());
        holder.tv_title.setText(news.getNew_Title());
        Glide.with(context).load(news.getAvatar()).into(holder.img_avatar);
        Glide.with(context).load(news.getIma()).into(holder.ima);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_name, tv_datetime;
        ImageView img_avatar, ima;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_publisher);
            tv_datetime = itemView.findViewById(R.id.tv_timenews);
            tv_title = itemView.findViewById(R.id.tv_titlenews);
            img_avatar = itemView.findViewById(R.id.img_avatar);
            ima = itemView.findViewById(R.id.ima);
        }
    }
}
