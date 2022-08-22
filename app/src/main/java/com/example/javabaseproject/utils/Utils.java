package com.example.javabaseproject.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.javabaseproject.R;

/**
 * This class is used for global functions used in entire application
 */
public class Utils {

    private static Dialog dialog = null;

    /**
     * This method is used to show Progressbar
     *
     * @param context the context is used to create dialog
     */
    public static void showProgressBar(Context context) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_progress_dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCancelable(false);
        dialog.show();
    }

    /**
     * This method is used to dismiss Progressbar
     */
    public static void dismissProgressBar() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    /**
     * This method is used to hide keyboard
     *
     * @param context the context to hide keyboard
     * @param view    the view is used to get window token
     */
    public static void hideKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * This method is used to load Image URL to ImageView using Glide Library
     *
     * @param imageUrl    the string image url
     * @param imageView   the view to load image url
     * @param placeholder the id of the resource to use as a placeholder and error holder
     */
    public static void loadImageURL(Activity context, String imageUrl, ImageView imageView, int placeholder) {
        showProgressBar(context);
        Glide.with(context)
                .load(imageUrl)
                .placeholder(placeholder)
                .error(placeholder)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        dismissProgressBar();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView);
    }

    /**
     * This method is used to check internet connection
     *
     * @param context
     * @param informToUser Boolean - to inform user via alert dialog or not
     * @return Boolean - Whether there is an internet connection
     */
    public static boolean isNetworkAvailable(Context context, boolean informToUser) {
        boolean isConnected;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        isConnected = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;

        if (informToUser && !isConnected) {
            AlertDialogView.showAlert(
                    context,
                    context.getString(R.string.app_name),
                    context.getString(R.string.error_internet_connection),
                    context.getString(R.string.ok)
            ).show();
        }

        return isConnected;
    }

}
