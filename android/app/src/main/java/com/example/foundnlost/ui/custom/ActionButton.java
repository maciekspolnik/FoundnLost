package com.example.foundnlost.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foundnlost.R;

public class ActionButton extends ConstraintLayout {

    public ActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionButton, 0, 0);
        String title = a.getString(R.styleable.ActionButton_buttonTitle);
        a.recycle();
        inflate(context, R.layout.item_action_button, this);
        TextView titleTextView = findViewById(R.id.action_button_text);
        titleTextView.setText(title == null ? "przycisk nawigujący" : title);
    }

}
