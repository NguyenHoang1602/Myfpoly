package com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_tuition.TuitionAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_nguyenhnpk02250.Details.DetailsScreen;
import com.example.asm_nguyenhnpk02250.Details.DetailsScreenAction;
import com.example.asm_nguyenhnpk02250.Details.DetailsScreenTuition;
import com.example.asm_nguyenhnpk02250.Model.NotificationAction;
import com.example.asm_nguyenhnpk02250.Model.NotificationTuition;
import com.example.asm_nguyenhnpk02250.R;

import java.util.ArrayList;

public class TuitionAdapter extends RecyclerView.Adapter<TuitionAdapter.NotificationViewHolder>{

    private Context context;
    private ArrayList<NotificationTuition> list;

    public TuitionAdapter(Context context, ArrayList<NotificationTuition> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        final NotificationTuition notificationTuition = list.get(position);
        holder.tv_title.setText(notificationTuition.getTitle());
        holder.tv_publisher.setText(notificationTuition.getPublishers());
        holder.tv_datetime.setText(notificationTuition.getTime());

        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDetails(notificationTuition);
            }
        });
    }
    private void onClickDetails(NotificationTuition notificationTuition){
        Intent intent = new Intent(context, DetailsScreenTuition.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Details", notificationTuition);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title, tv_publisher, tv_datetime;
        LinearLayout layout_item;


        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.Title_notification);
            tv_publisher = itemView.findViewById(R.id.Publisher);
            tv_datetime = itemView.findViewById(R.id.tv_time);
            layout_item = itemView.findViewById(R.id.layout_item);
        }
    }
}

