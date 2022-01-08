package com.example.foundnlost.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foundnlost.R;

public class PostCard extends ConstraintLayout {

    TextView titleTextView;
    TextView descriptionTextView;
    TextView timeTextView;
    TextView locationTextView;


    public PostCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.card, this);

        titleTextView = findViewById(R.id.cardTitle);
        descriptionTextView = findViewById(R.id.cardDesc);
        timeTextView = findViewById(R.id.cardTime);
        locationTextView = findViewById(R.id.cardLocation);


    }

}
