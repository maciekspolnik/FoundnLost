package com.example.foundnlost.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foundnlost.R;
import com.example.foundnlost.data.network.model.Advert;

import java.text.DateFormat;
import java.util.ArrayList;

public class AdvertsAdapter extends RecyclerView.Adapter<AdvertsAdapter.ViewHolder> {

    private final View.OnClickListener listener;
    private ArrayList<Advert> data;
    private final int NOT_EXPANDED = -1;
    private int expandedPosition = NOT_EXPANDED;
    private int previousExpandedPosition = NOT_EXPANDED;
    private final Context context;

    public AdvertsAdapter(ArrayList<Advert> data, Context context, View.OnClickListener listener) {
        this.data = data;
        this.context = context;
        this.listener = listener;
    }

    public void updateData(ArrayList<Advert> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleTextView;
        public final TextView descTextView;
        public final TextView locationTextView;
        public final TextView dateTextView;
        private final ImageView dateImageView;
        private final ImageButton infoButton;

        public ViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.cardTitle);
            descTextView = view.findViewById(R.id.cardDesc);
            locationTextView = view.findViewById(R.id.cardLocation);
            dateTextView = view.findViewById(R.id.cardTime);
            dateImageView = view.findViewById(R.id.cardTimeIcon);
            infoButton = view.findViewById(R.id.infoButton);
        }

        private void bindData(int position) {
            Advert advert = data.get(position);
            final boolean isExpanded = position == expandedPosition;
            descTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            dateTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            dateImageView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            infoButton.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            titleTextView.setText(advert.getTitle());
            descTextView.setText(advert.getDescription());
            locationTextView.setText(advert.getLocation());

            dateTextView.setText(DateFormat.getDateInstance(DateFormat.FULL).format(advert.getDate()));

            itemView.setBackgroundColor(
                    isExpanded
                            ? ContextCompat.getColor(context, R.color.black10)
                            : Color.TRANSPARENT);
            itemView.setActivated(isExpanded);

            if (isExpanded) {
                previousExpandedPosition = position;
            }
            infoButton.setOnClickListener(listener);

            itemView.setOnClickListener(view -> {
                expandedPosition = isExpanded ? NOT_EXPANDED : position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_advert_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
