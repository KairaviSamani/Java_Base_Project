package com.example.javabaseproject.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.javabaseproject.R;

public class CustomEditText extends AppCompatEditText {
    public CustomEditText(@NonNull Context context) {
        super(context);
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        customAttr(context, attrs);
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        customAttr(context, attrs);
    }

    @SuppressLint("CustomViewStyleable")
    private void customAttr(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText);
        String customFont = a.getString(R.styleable.CustomEditText_customEditTextFont);
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
