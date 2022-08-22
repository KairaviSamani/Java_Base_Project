package com.example.javabaseproject.utils;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.javabaseproject.R;

import java.util.Objects;

@SuppressLint("StaticFieldLeak")
public class AlertDialogView {
    public static final int FIRST_BUTTON = 1;
    private static final int SECOND_BUTTON = 2;
    private static final int THIRD_BUTTON = 3;
    public static Dialog dialog;


    public static Dialog showAlert(Context context,
                                   String title,
                                   String message,
                                   String firstButtonText) {
        return showAlertDialog(context, title, message, firstButtonText, "", null);
    }

    public static Dialog showAlert(Context context,
                                   String title,
                                   String message,
                                   String firstButtonText,
                                   OnAlertDialogViewButtonClickListener clickListener,
                                   int tag) {
        return showAlertDialog(context, title, message, firstButtonText, "", clickListener);
    }

    public static Dialog showAlert(Context context,
                                   String title,
                                   String message,
                                   String firstButtonText,
                                   String secondButtonText,
                                   OnAlertDialogViewButtonClickListener clickListener) {
        return showAlertDialog(context, title, message, firstButtonText, secondButtonText, clickListener);
    }


    private static Dialog showAlertDialog(Context context,
                                          String title,
                                          String message,
                                          String firstButtonText,
                                          String secondButtonText,
                                          final OnAlertDialogViewButtonClickListener clickListener) {
        try {
            try {
                if (dialog != null) {
                    dialog.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_alert_view);
            dialog.setCancelable(true);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dialog.dismiss();
                }
                return true;
            });

            TextView txvTitle = dialog.findViewById(R.id.tv_title);
            TextView txvMessage = dialog.findViewById(R.id.tv_message);
            TextView txvFirstButton = dialog.findViewById(R.id.tv_first_button);
            TextView txvSecondButton = dialog.findViewById(R.id.tv_second_button);
            View view = dialog.findViewById(R.id.view);

            txvTitle.setText(title);
            txvMessage.setText(message);
            txvFirstButton.setText(firstButtonText);

            txvFirstButton.setOnClickListener(v -> {
                if (clickListener != null)
                    clickListener.onAlertDialogViewButtonClick(FIRST_BUTTON);
                dialog.dismiss();
            });

            if (!secondButtonText.equals("")) {
                view.setVisibility(View.VISIBLE);
                txvSecondButton.setVisibility(View.VISIBLE);
                txvSecondButton.setText(secondButtonText);
                txvSecondButton.setOnClickListener(v -> {
                    if (clickListener != null)
                        clickListener.onAlertDialogViewButtonClick(AlertDialogView.SECOND_BUTTON);
                    dialog.dismiss();
                });
            } else {
                txvSecondButton.setVisibility(View.GONE);
                view.setVisibility(View.GONE);
            }

            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

            dialog.setOnShowListener(dialogInterface -> {
                try {
                    dialog.getWindow().getDecorView().setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
                    dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dialog;
    }

    public interface OnAlertDialogViewButtonClickListener {
        void onAlertDialogViewButtonClick(int buttonIndex);
    }
}
