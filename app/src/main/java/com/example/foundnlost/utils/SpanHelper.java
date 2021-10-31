package com.example.foundnlost.utils;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Color;
//import android.text.Spannable;
//import android.text.SpannableString;
//import android.text.Spanned;
//import android.text.TextPaint;
//import android.text.style.ClickableSpan;
//import android.text.style.ForegroundColorSpan;
//import android.view.View;
//
//import com.example.foundnlost.MainActivity;
//import com.example.foundnlost.R;
//
//public abstract class SpanHelper {
//
//    public static void getClickableSpan(Activity activity, int start, int stop) {
//        SpannableString ss = new SpannableString("Android is a Software stack");
////        ForegroundColorSpan fcs = new ForegroundColorSpan(activity.getResources.getColor(R.color.purple_700));
//        ClickableSpan clickableSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View textView) {
//                ((MainActivity) activity)
//            }
//
//            @Override
//            public void updateDrawState(TextPaint ds) {
//                super.updateDrawState(ds);
//                ds.setUnderlineText(false);
//            }
//        };
//        //       ss.setSpan(fcs, 22, 27, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        ss.setSpan(clickableSpan, start, stop, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//    }
//
//
//}
