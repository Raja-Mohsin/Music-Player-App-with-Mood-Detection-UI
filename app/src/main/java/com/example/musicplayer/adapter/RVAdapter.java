package com.example.musicplayer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.IcategoryListener;
import com.example.musicplayer.R;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private String[] data;
    private int[] images;
    private IcategoryListener listener;

    public RVAdapter(String[] data, int[] images, IcategoryListener listener)
    {
        this.data = data;
        this.images = images;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_grid_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String title = data[position];
        holder.rvTextView.setText(title);
        holder.rvLinearLayout.setBackgroundResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView rvTextView;
        LinearLayout rvLinearLayout;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvTextView = itemView.findViewById(R.id.gridTextView);
            rvLinearLayout = itemView.findViewById(R.id.gridLinearLayout);
            cardView = itemView.findViewById(R.id.card_view_category);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.card_view_category:
                    listener.onItemClick(getAdapterPosition());
                    break;
            }
        }
    }


}
