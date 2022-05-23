package com.example.foundnlost.ui.adapter;

import android.content.Context;
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
import com.example.foundnlost.data.network.dto.AdvertDto;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdvertsAdapter extends RecyclerView.Adapter<AdvertsAdapter.ViewHolder> {

    private final View.OnClickListener listener;
    private List<AdvertDto> data;
    private final int NOT_EXPANDED = -1;
    private int expandedPosition = NOT_EXPANDED;
    private int previousExpandedPosition = NOT_EXPANDED;
    private final Context context;
    private int drawable;

    public AdvertsAdapter(ArrayList<AdvertDto> data, Context context, View.OnClickListener listener) {
        this.data = data;
        this.context = context;
        this.listener = listener;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public void updateData(List<AdvertDto> data) {
        this.data.clear();
        this.data = data;
        notifyDataSetChanged();
    }

    public Long getClickedData() {
        return data.get(expandedPosition).getUserId();
    }


    public int returnPosition() {
        int result = expandedPosition;
        data.remove(expandedPosition);
        notifyItemRemoved(result);
        expandedPosition = -1;
        return expandedPosition;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView titleTextView;
        public final TextView descTextView;
        public final TextView locationTextView;
        public final TextView dateTextView;
        private final ImageView dateImageView;
        private final ImageButton infoButton;
        private final TextView typeTextView;

        public ViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.cardTitle);
            descTextView = view.findViewById(R.id.cardDesc);
            typeTextView = view.findViewById(R.id.typeTextView);
            locationTextView = view.findViewById(R.id.cardLocation);
            dateTextView = view.findViewById(R.id.cardTime);
            dateImageView = view.findViewById(R.id.cardTimeIcon);
            infoButton = view.findViewById(R.id.infoButton);
        }

        private void bindData(int position) {
            AdvertDto advert = data.get(position);
            infoButton.setImageResource(drawable);
            final boolean isExpanded = position == expandedPosition;
            descTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            dateTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            dateImageView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            infoButton.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            titleTextView.setText(advert.getTitle());
            descTextView.setText(advert.getDescription());
            locationTextView.setText(advert.getLocation());
            boolean isFound = advert.getPostType().equals("FOUND");
            typeTextView.setText(isFound ? "Znaleziono:" : "Zgubiono:  ");
            typeTextView.setTextColor(ContextCompat.getColor(context, isFound ? R.color.sapphire : R.color.amethyst));
            dateTextView.setText(advert.getDate() == null ? context.getString(R.string.unknown_date) : DateFormat.getDateInstance(DateFormat.FULL).format(advert.getDate()));

            itemView.setBackgroundColor(ContextCompat.getColor(context, isExpanded ? R.color.black10 : R.color.transparent));
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_advert_card, viewGroup, false);
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

