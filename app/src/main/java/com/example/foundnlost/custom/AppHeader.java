package com.example.foundnlost.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foundnlost.R;

public class AppHeader extends ConstraintLayout {

    ImageButton backButton;
    ImageButton closeButton;
    TextView titleTextView;

    public AppHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AppHeader, 0, 0);
        String title = a.getString(R.styleable.AppHeader_headerTitle);
        boolean backButtonVisible = a.getBoolean(R.styleable.AppHeader_backButtonVisible, true);
        boolean closeButtonVisible = a.getBoolean(R.styleable.AppHeader_closeButtonVisible, true);
        a.recycle();

        inflate(context, R.layout.item_topbar, this);

        titleTextView = findViewById(R.id.topbar_banner);
        backButton = findViewById(R.id.topbar_back_button);
        closeButton = findViewById(R.id.topbar_close_button);
        titleTextView.setText(title == null ? context.getString(R.string.app_name) : title);
        backButton.setVisibility(backButtonVisible ? View.VISIBLE : View.GONE);
        closeButton.setVisibility(closeButtonVisible ? View.VISIBLE : View.GONE);
    }

    public void setBackClickedListener(OnClickListener listener) {
        backButton.setOnClickListener(listener);
    }

    public void setCloseClickedListener(OnClickListener listener) {
        closeButton.setOnClickListener(listener);
    }

    public void setTitle(int title) {
        titleTextView.setText(title);
    }

}