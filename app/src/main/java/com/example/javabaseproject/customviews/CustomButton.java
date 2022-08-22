package com.example.javabaseproject.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.example.javabaseproject.R;

public class CustomButton extends AppCompatButton {
    public CustomButton(@NonNull Context context) {
        super(context);
    }

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        customAttr(context, attrs);
    }

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        customAttr(context, attrs);
    }

    @SuppressLint("CustomViewStyleable")
    private void customAttr(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomButton);
        String customFont = a.getString(R.styleable.CustomButton_customButtonFont);
        setCustomFont(customFont);
        a.recycle();
    }

    public void setCustomFont(String fontName) {
        Typeface myTypeface = null;
        try {
            if (fontName != null && !fontName.isEmpty())
                myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setTypeface(myTypeface);
    }
}
